package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Models.UserBean;


public interface AdminDAOInterface {
	
	ResultSet getLoginData(String email, String pass) throws SQLException;

	int userType(UserBean bean) throws SQLException;
}
