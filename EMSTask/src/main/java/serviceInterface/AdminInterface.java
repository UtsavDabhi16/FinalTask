package serviceInterface;

import java.sql.SQLException;

import Models.UserBean;

public interface AdminInterface {

	 boolean checkLogin(String email, String pass) throws SQLException;

	int checkUserType(UserBean bean) throws SQLException;

}
