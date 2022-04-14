package service;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import DAO.UserDAOInterface;
import DAO.UserDaoOperations;
import Models.AddressBean;
import Models.UserBean;
import serviceInterface.UserInterface;

public class UserImpl implements UserInterface {
	private static final Logger logger = Logger.getLogger(UserImpl.class.getName());

	@Override
	public boolean userForgotPasswordService(UserBean ubean) throws SQLException {
		UserDAOInterface udao = new UserDaoOperations();
		int count = udao.forgotPasswordUser(ubean);
		logger.info(count);
		if (count != 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userRegistrationService(UserBean ubean, List<AddressBean> address) {
		int count = 0;
		try {
			UserDAOInterface udao = new UserDaoOperations();
			count = udao.insertUser(ubean, address);

			logger.info(count);
			if (count == 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public UserBean getUserByEmail(String email) throws SQLException {
		UserDAOInterface udao = new UserDaoOperations();
		UserBean ubean = udao.getUserEmail(email);
		logger.info("inside service layer" + ubean.getFirstName());
		return ubean;
	}

	@Override
	public int userDeleteService(int userid) throws SQLException {
		UserDAOInterface udao = new UserDaoOperations();
		int count = udao.deleteCurrentUser(userid);
		logger.info(count);
		return count;

	}

	@Override
	public List<AddressBean> getUserAddress(UserBean bean) throws SQLException {
		UserDAOInterface udao = new UserDaoOperations();
		List<AddressBean> abean = udao.getCurrentUserAddress(bean);
		return abean;
	}

	@Override
	public List<Integer> getUserAddressId(int Userid) throws SQLException {
		UserDAOInterface udao = new UserDaoOperations();
		List<Integer> list = udao.getUserByAddressId(Userid);
		return list;
	}

	public int updateUserDetails(UserBean ubean) {
		UserDAOInterface udao = new UserDaoOperations();
		int status = udao.updateUser(ubean);
		return status;
	}

	public int addUserAddress(List<AddressBean> addressList1) {
		UserDAOInterface udao = new UserDaoOperations();
		int status = udao.addCurrentUserAddress(addressList1);
		return status;
	}

	public int updateUserAddress(List<AddressBean> addressList2) {
		UserDAOInterface udao = new UserDaoOperations();
		int status = udao.updateCurrentUserAddress(addressList2);
		return status;
	}

	public int deleteUserAddress(List<Integer> addressList3, int uid) {
		UserDAOInterface udao = new UserDaoOperations();
		int status = udao.deleteCurrentUserAddress(addressList3, uid);
		return status;
	}

//	public boolean userResetPasswordService(UserBean ubean) {
//		UserDAOInterface udao = new UserDaoOperations();
//		int count = udao.resetPasswordUser(ubean);
//		logger.info(count);
//		if (count != 0) {
//			return true;
//		}
//		return false;
//
//	}

	

}
