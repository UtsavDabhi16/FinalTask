package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import Models.AddressBean;
import Models.UserBean;

public class UserDaoOperations implements UserDAOInterface {
	private static final Logger logger = Logger.getLogger(UserDaoOperations.class.getName());

	// Forgot PassWord of User Method
	@Override
	public int forgotPasswordUser(UserBean ubean) throws SQLException {
		String useremail = ubean.getEmail();
		String newPassword = ubean.getNewPassword();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		int status = 0;
		try {
			try {
				String UserData = "select email,phone,sanswer from users where email=?";
				String UpdatedData = "update users set password=? , cpassword=? where email=?";
				ps1 = ConnectionClass.getConnection().prepareStatement(UserData);
				ps1.setString(1, useremail);
				ps2 = ConnectionClass.getConnection().prepareStatement(UpdatedData);
				ps2.setString(1, newPassword);
				ps2.setString(2, newPassword);
				ps2.setString(3, useremail);
				status = ps2.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps1 != null) {
						ps1.close();
					}
				} catch (Exception ex) {
					logger.info("Error is :" + ex);
					ex.printStackTrace();
				}
				try {
					if (ps2 != null) {
						ps2.close();
					}
				} catch (Exception ex) {
					logger.info("Error is :" + ex);
					ex.printStackTrace();
				}
			}

		} catch (Exception e) {
			logger.info("Error" + e);
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	// Insert All the User Details into DataBase
	@Override
	public int insertUser(UserBean bean, List<AddressBean> address) throws SQLException {

		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String fname = bean.getFirstName();
		String lname = bean.getLastName();
		String email = bean.getEmail();
		String phoneno = bean.getPhoneNo();
		String bdate = bean.getDob();
		String gender = bean.getGender();
		String sanswer = bean.getSecurityAnswer();
		String pass = bean.getPassword();
		String cpass = bean.getCPassword();

		try {
			try {

				ps = ConnectionClass.getConnection().prepareStatement(
						"insert into users values(NULL,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, fname);
				ps.setString(2, lname);
				ps.setString(3, email);
				ps.setString(4, phoneno);
				ps.setString(5, bdate);
				ps.setString(6, gender);
				ps.setString(7, sanswer);
				ps.setString(8, pass);
				ps.setString(9, cpass);
				ps.executeUpdate();

				rs = ps.getGeneratedKeys();

				while (rs.next()) {
					int name = rs.getInt(1);

					String SetUserType = "insert into AssignRole values(?,?)";
					ps1 = ConnectionClass.getConnection().prepareStatement(SetUserType);
					ps1.setInt(1, name);
					ps1.setInt(2, 1);
					ps1.executeUpdate();

					pstmt = ConnectionClass.getConnection()
							.prepareStatement("insert into address values(NULL,?,?,?,?,?,?)");
					for (int i = 0; i < address.size(); i++) {
						AddressBean abean = address.get(i);
						pstmt.setString(1, abean.getAddressLineOne());
						pstmt.setString(2, abean.getAddressLineTwo());
						pstmt.setString(3, abean.getPincode());
						pstmt.setString(4, abean.getCity());
						pstmt.setString(5, abean.getState());
						pstmt.setInt(6, name);
						pstmt.addBatch();
					}
					pstmt.executeBatch();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
				if (ps1 != null)
					ps1.close();
				if (pstmt != null)
					pstmt.close();
			}

		} catch (Exception e) {
			rs.close();
			logger.info("Error" + e);
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public ResultSet getData(String query) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			try {
				stmt = ConnectionClass.getConnection().createStatement();
				rs = stmt.executeQuery(query);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (stmt != null)
					stmt.close();
			}

		} catch (NullPointerException e) {
			if (rs != null) {
				rs.close();
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
	public List<UserBean> showAllUsers() throws SQLException {
		List<UserBean> list = new ArrayList<>();
		PreparedStatement prestmt = null;
		ResultSet rs = null;
		try {

			String get = "SELECT * FROM users";
			prestmt = ConnectionClass.getConnection().prepareStatement(get);
			rs = prestmt.executeQuery();
			while (rs.next()) {
				UserBean ubean = new UserBean();
				ubean.setUserid(rs.getInt(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setEmail(rs.getString(4));
				ubean.setPhoneNo(rs.getString(5));
				ubean.setDob(rs.getString(6));
				ubean.setGender(rs.getString(7));
				list.add(ubean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (prestmt != null) {
				try {
					prestmt.close();
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
		return list;
	}

	@Override
	public UserBean getUserEmail(String email) throws SQLException {

		UserBean ubean = new UserBean();
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		try {

			String getData = "SELECT * FROM users WHERE email=?";
			pstmt1 = ConnectionClass.getConnection().prepareStatement(getData);
			pstmt1.setString(1, email);
			rs = pstmt1.executeQuery();
			if (rs.next()) {
				ubean.setUserid(rs.getInt(1));
				ubean.setFirstName(rs.getString(2));
				ubean.setLastName(rs.getString(3));
				ubean.setEmail(rs.getString(4));
				ubean.setPhoneNo(rs.getString(5));
				ubean.setDob(rs.getString(6));
				ubean.setGender(rs.getString(7));
				ubean.setSecurityAnswer(rs.getString(8));
				ubean.setPassword(rs.getString(9));
				ubean.setCPassword(rs.getString(10));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt1 != null) {
				try {
					pstmt1.close();
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

		return ubean;
	}

	@Override
	public int deleteCurrentUser(int userid) throws SQLException {
		PreparedStatement ps = null;
		int userDeleted = 0;
		try {
			try {
				String getUserID = "DELETE users FROM users INNER JOIN address ON users.Userid= address.Userid where users.Userid ='"
						+ userid + "'";
				ps = ConnectionClass.getConnection().prepareStatement(getUserID);
				userDeleted = ps.executeUpdate();
				logger.info("User Deleted SuccessFullly :" + userDeleted);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userDeleted;
	}

	@Override
	public List<AddressBean> getCurrentUserAddress(UserBean ubean) throws SQLException {
		PreparedStatement preparedstmt = null;
		ResultSet rs = null;
		List<AddressBean> address = null;
		try {

			String getAddress = "SELECT * FROM address WHERE Userid=?";
			preparedstmt = ConnectionClass.getConnection().prepareStatement(getAddress);
			int uid = ubean.getUserid();
			preparedstmt.setInt(1, ubean.getUserid());
			rs = preparedstmt.executeQuery();
			address = new ArrayList<>();
			while (rs.next()) {
				AddressBean abean = new AddressBean();
				abean.setAddressId(rs.getInt(1));
				abean.setAddressLineOne(rs.getString(2));
				abean.setAddressLineTwo(rs.getString(3));
				abean.setPincode(rs.getString(4));
				abean.setCity(rs.getString(5));
				abean.setState(rs.getString(6));
				abean.setUserid(uid);
				address.add(abean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (preparedstmt != null) {
				try {
					preparedstmt.close();
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

		return address;
	}

	@Override
	public List<Integer> getUserByAddressId(int userid) throws SQLException {
		List<Integer> AddrerssIdList = new ArrayList<Integer>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			String set = "SELECT Addressid from address where Userid=?";
			ps = ConnectionClass.getConnection().prepareStatement(set);
			ps.setInt(1, userid);
			rs = ps.executeQuery();
			while (rs.next()) {
				AddrerssIdList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
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

		return AddrerssIdList;
	}

	@Override
	public int updateUser(UserBean ubean) {
		PreparedStatement ps = null;
		int count = 0;

		try {
			try {
				String set = "update users set fname = ? , lname = ? , phone = ? , bdate = ?, gender = ?, sanswer = ? , password = ? ,cpassword = ? where Userid = ? ";
				ps = ConnectionClass.getConnection().prepareStatement(set);
				ps.setString(1, ubean.getFirstName());
				ps.setString(2, ubean.getLastName());
				ps.setString(3, ubean.getPhoneNo());
				ps.setString(4, ubean.getDob());
				ps.setString(5, ubean.getGender());
				ps.setString(6, ubean.getSecurityAnswer());
				ps.setString(7, ubean.getPassword());
				ps.setString(8, ubean.getCPassword());
				ps.setInt(9, ubean.getUserid());
				count = ps.executeUpdate();
				logger.info("Update User SuccessFully:" + count);
				return count;

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int updateCurrentUserAddress(List<AddressBean> addressList2) {
		PreparedStatement ps = null;
		try {
			try {
				String set = "update address set AddLineOne = ? , AddLineTwo = ? , Pincode = ? , City = ?, State = ? where Addressid = ? ";
				ps = ConnectionClass.getConnection().prepareStatement(set);
				for (int i = 0; i < addressList2.size(); ++i) {
					AddressBean addressBean = addressList2.get(i);
					ps.setString(1, addressBean.getAddressLineOne());
					ps.setString(2, addressBean.getAddressLineTwo());
					ps.setString(3, addressBean.getPincode());
					ps.setString(4, addressBean.getCity());
					ps.setString(5, addressBean.getState());
					ps.setInt(6, addressBean.getAddressId());
					ps.addBatch();
				}
				ps.executeBatch();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int addCurrentUserAddress(List<AddressBean> addressList1) {
		PreparedStatement ps = null;

		try {
			try {
				String setAddress = "INSERT INTO address VALUES (NULL,?,?,?,?,?,?)";
				ps = ConnectionClass.getConnection().prepareStatement(setAddress);
				for (int i = 0; i < addressList1.size(); ++i) {
					AddressBean addressBean = addressList1.get(i);
					ps.setString(1, addressBean.getAddressLineOne());
					ps.setString(2, addressBean.getAddressLineTwo());
					ps.setString(3, addressBean.getPincode());
					ps.setString(4, addressBean.getCity());
					ps.setString(5, addressBean.getState());
					ps.setInt(6, addressBean.getUserid());
					ps.addBatch();
					logger.info("Address Added SuccessFully");
				}
				ps.executeBatch();
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int deleteCurrentUserAddress(List<Integer> addressList3, int uid) {
		PreparedStatement ps = null;
		final String DeleteAddress = "DELETE FROM address WHERE Addressid=? and Userid=?";
		try {
			try {
				ps = ConnectionClass.getConnection().prepareStatement(DeleteAddress);
				for (Integer addresslist : addressList3) {
					ps.setInt(1, addresslist);
					ps.setInt(2, uid);
					ps.addBatch();
				}
				ps.executeBatch();
				logger.info("Deleted SuccessFully");
				return 1;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (ps != null)
					ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ConnectionClass.getConnection() == null)
					ConnectionClass.closeConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return 0;
	}

//	@Override
//	public int resetPasswordUser(UserBean ubean) {
//		String oldPass=ubean.getNewPassword();
//		String pass = ubean.getPassword();
//		String cpass = ubean.getCPassword();
//		PreparedStatement ps1 = null;
//		int status = 0;
//		try {
//			try {
//				
//				String UpdatedData = "update users set password=? , cpassword=? where email=?";
//				ps1 = ConnectionClass.getConnection().prepareStatement(UpdatedData);
//				ps1.setString(1, pass);
//				ps1.setString(2, cpass);
//				ps1.setString(3, oldPass);
//				status = ps1.executeUpdate();
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (ps1 != null) {
//						ps1.close();
//					}
//				} catch (Exception ex) {
//					logger.info("Error is :" + ex);
//					ex.printStackTrace();
//				}
//			}
//
//		} catch (Exception e) {
//			logger.info("Error" + e);
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ConnectionClass.getConnection() == null)
//					ConnectionClass.closeConnection();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return status;
//	}
//	
}
