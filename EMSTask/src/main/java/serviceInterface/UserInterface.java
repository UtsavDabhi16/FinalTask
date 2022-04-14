package serviceInterface;

import java.sql.SQLException;
import java.util.List;
import Models.AddressBean;
import Models.UserBean;

public interface UserInterface {

	boolean userRegistrationService(UserBean ubean, List<AddressBean> address);

	boolean userForgotPasswordService(UserBean ubean) throws SQLException;

	UserBean getUserByEmail(String email) throws SQLException;

	List<AddressBean> getUserAddress(UserBean ubean) throws SQLException;

	int userDeleteService(int userid) throws SQLException;

	List<Integer> getUserAddressId(int Userid) throws SQLException;

//	boolean userResetPasswordService(UserBean ubean);
}
