package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import DAO.AdminDAOInterface;
import DAO.AdminDatabaseOperations;
import Models.UserBean;
import serviceInterface.AdminInterface;

public class AdminImpl implements AdminInterface {
	private static final Logger logger = Logger.getLogger(AdminImpl.class.getName());

	@Override
	public boolean checkLogin(String email, String pass) throws SQLException {
		logger.info("check mail is :" + email + " check pass is :" + pass);
		// check email and password is empty or not
		if (email.isEmpty()) {
			return false;
		} else if (pass.isEmpty()) {
			return false;
		} else
			try {
				if (Validation.isValidemail(email)) {
					logger.info("inside " + email);
					AdminDAOInterface adao = new AdminDatabaseOperations();
					ResultSet rs = adao.getLoginData(email, pass);
					if (rs.next()) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}

	
	@Override
	public int checkUserType(UserBean bean) throws SQLException {
		AdminDAOInterface adao=new AdminDatabaseOperations();
		int usertype=adao.userType(bean);
		logger.info("inside checkadmin :"+ usertype);
		return usertype;
	}
}

//	public  boolean checkLogin(String email, String pass) throws ClassNotFoundException, SQLException {
//		logger.info("check mail is :" + email + " check pass is :" + pass);
//		// check email and password is empty or not
//		if (email.isEmpty()) {
//			return false;
//		} else if (pass.isEmpty()) {
//			return false;
//		} else if (Validation.isValidemail(email)) {
//			logger.info("inside "+email);
//			ResultSet rs = AdminDatabaseOperations.getLoginData(email, pass);
//			if (rs.next()) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
//}
