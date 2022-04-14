package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import Models.UserBean;
import service.Validation;

public class AdminDatabaseOperations implements AdminDAOInterface {
	private static final Logger logger = Logger.getLogger(AdminDatabaseOperations.class.getName());
	final String secretKey = "HelloWorld!!!";

	@Override
	public ResultSet getLoginData(String email, String pass) throws SQLException {
		logger.info("admindatabase is" + email + "admindatabase is" + pass);
		String query = "select * from admin where Email=? and Password=? ";

		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			try {
				preparedStatement = ConnectionClass.getConnection().prepareStatement(query);
				preparedStatement.setString(1, email);
				preparedStatement.setString(2, pass);
				rs = preparedStatement.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (preparedStatement != null)
					preparedStatement.close();
			}
		} catch (Exception e) {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
				logger.info("Error" + e);
			}
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;

	}

	@Override
	public int userType(UserBean bean) throws SQLException {
		int usertype = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			String LoginCredentials = "select users.email,users.password,AssignRole.Userid,AssignRole.Role from users INNER JOIN AssignRole ON users.Userid = AssignRole.Userid";
			preparedStatement = ConnectionClass.getConnection().prepareStatement(LoginCredentials);

			rs = preparedStatement.executeQuery();
			
			// loop through database to find matching email and pass
			while (rs.next()) {

				String cpass = Validation.encrypt(bean.getPassword(), secretKey);
				if (rs.getString(1).equals(bean.getEmail()) && rs.getString(2).equals(cpass)
						&& rs.getString(4).equals("1")) {
					// UserType defines type of user 1 for user.
					usertype = 1;
					break;
				} else if (rs.getString(1).equals(bean.getEmail())
						&& rs.getString(2).equals(cpass) && rs.getString(4).equals("2")) {
					// UserType defines type of user 2 for Admin.
					usertype = 2;
					break;
				}
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (ConnectionClass.getConnection() == null) {
				ConnectionClass.closeConnection();
			}

		}
		return usertype;
	}

}
