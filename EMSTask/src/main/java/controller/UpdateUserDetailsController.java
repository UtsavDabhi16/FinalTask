package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import Models.AddressBean;
import Models.UserBean;
import service.UserImpl;


@WebServlet("/UpdateUserDetailsController")
public class UpdateUserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UpdateUserDetailsController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		// Get the Details From User
		int uid = Integer.parseInt(request.getParameter("Userid"));
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phoneno");
		String bdate = request.getParameter("birthdaydate");
		String gender = request.getParameter("gender");
		String answer = request.getParameter("sanswer");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		// Set the Value into UserBean Class
		UserBean ubean = new UserBean();
		ubean.setUserid(uid);
		ubean.setFirstName(fname);
		ubean.setLastName(lname);
		ubean.setEmail(email);
		ubean.setPhoneNo(phone);
		ubean.setDob(bdate);
		ubean.setGender(gender);
		ubean.setSecurityAnswer(answer);
		ubean.setPassword(password);
		ubean.setCPassword(cpassword);

		// Get All the Multiple Addresses From User
		String[] addressLineOne = request.getParameterValues("AddressLineOne");
		String addressLineTwo[] = request.getParameterValues("AddressLineTwo");
		String[] pincode = request.getParameterValues("pincode");
		String city[] = request.getParameterValues("city");
		String state[] = request.getParameterValues("state");
		String AddressId[] = request.getParameterValues("UserAddressId");

		// Create ArrayList For Add,Update and Delete Address
		List<AddressBean> NewAddress = new ArrayList<AddressBean>();
		List<AddressBean> ExistingAddress = new ArrayList<AddressBean>();
		List<Integer> addressList3 = new ArrayList<Integer>();

		for (int i = 0; i < addressLineOne.length; i++) {
			// Insert the new Address into NewAddress ArrayList
			if (AddressId[i].isEmpty()) {
				AddressBean abean = new AddressBean();
				abean.setUserid(uid);
				abean.setAddressLineOne(addressLineOne[i]);
				abean.setAddressLineTwo(addressLineTwo[i]);
				abean.setPincode(pincode[i]);
				abean.setCity(city[i]);
				abean.setState(state[i]);
				NewAddress.add(abean);
				// Insert the Existing Addresses into Existing ArrayList
			} else {
				AddressBean AddressBean = new AddressBean();
				AddressBean.setAddressId(Integer.parseInt(AddressId[i]));
				AddressBean.setAddressLineOne(addressLineOne[i]);
				AddressBean.setAddressLineTwo(addressLineTwo[i]);
				AddressBean.setPincode(pincode[i]);
				AddressBean.setCity(city[i]);
				AddressBean.setState(state[i]);
				ExistingAddress.add(AddressBean);
				addressList3.add(AddressBean.getAddressId());
			}
		}

		// Find Out AddressId By UserId
		UserImpl cuser = new UserImpl();
		try {
			List<Integer> UserAddtessIdList = cuser.getUserAddressId(uid);
			for (Integer l : UserAddtessIdList) {
				if (addressList3.contains(l)) {
					// Remove the Address
					addressList3.remove(l);
				} else {
					// Add the Address
					addressList3.add(l);
				}
			}
		} catch (SQLException e) {
			logger.info("Error is :"+e);
			e.printStackTrace();
		}
		

		int userData = cuser.updateUserDetails(ubean);
		cuser.updateUserAddress((List<AddressBean>) ExistingAddress);
		cuser.addUserAddress((List<AddressBean>) NewAddress);
		cuser.deleteUserAddress(addressList3, uid);

		if (userData > 0) {
			logger.info("Update");
			HttpSession session = request.getSession(false);
			session.setAttribute("User", ubean);
			response.sendRedirect("UserProfile.jsp");
		} else {
			response.sendRedirect("updateuser.jsp");
			logger.info("Not Updated");
		}
	}
}
