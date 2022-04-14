package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Models.AddressBean;
import Models.UserBean;

public interface UserDAOInterface {

	int forgotPasswordUser(UserBean ubean) throws SQLException;

	int insertUser(UserBean bean, List<AddressBean> address) throws SQLException;

	ResultSet getData(String query) throws SQLException;

	List<UserBean> showAllUsers() throws SQLException;

	UserBean getUserEmail(String email) throws SQLException;

	List<AddressBean> getCurrentUserAddress(UserBean bean) throws SQLException;

	int deleteCurrentUser(int userid) throws SQLException;

	List<Integer> getUserByAddressId(int userid) throws SQLException;

	int updateUser(UserBean ubean);

	int updateCurrentUserAddress(List<AddressBean> addressList2);

	int addCurrentUserAddress(List<AddressBean> addressList1);

	int deleteCurrentUserAddress(List<Integer> addressList3, int uid);

//	int resetPasswordUser(UserBean ubean);

}
