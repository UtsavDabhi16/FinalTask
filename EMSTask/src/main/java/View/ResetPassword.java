package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import DAO.ConnectionClass;

@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ResetPassword.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		String Password = request.getParameter("currentPassword");
		logger.info(Password);
		PreparedStatement pstatement = null;
		ResultSet resultSet = null;

		try {
			String getData = "SELECT * FROM users WHERE password=?";
			pstatement = ConnectionClass.getConnection().prepareStatement(getData);
			pstatement.setString(1, Password);
			resultSet = pstatement.executeQuery();

			if (resultSet.next()) {
				logger.info(resultSet.getString(9));
				response.setContentType("text/html");
				PrintWriter pw = response.getWriter();
				pw.print("Old Password is Correct ");
			} else {
				response.setContentType("text/html");
				PrintWriter pout = response.getWriter();
				pout.print("");
			}
		} catch (SQLException e) {
			logger.error("Error is :" + e);
			e.printStackTrace();
		} finally {
			if (pstatement != null) {
				try {
					pstatement.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (ConnectionClass.getConnection() == null) {
				ConnectionClass.closeConnection();
			}

		}
	}

}
