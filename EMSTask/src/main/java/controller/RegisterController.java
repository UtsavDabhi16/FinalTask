package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import Models.AddressBean;
import Models.UserBean;
import service.UserImpl;
import service.Validation;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(RegisterController.class.getName());
	final String secretKey = "HelloWorld!!!";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		// Get the Details From User
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phoneno");
		String bdate = request.getParameter("birthdaydate");
		String gender = request.getParameter("gender");
		String answer = request.getParameter("sanswer");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");

		// Encrypt the Password and Stored Into Database
		String pass = Validation.encrypt(password, secretKey);
		String cpass = Validation.encrypt(cpassword, secretKey);

		// Set the User Details into UserBean Class
		UserBean ubean = new UserBean();
		ubean.setFirstName(fname);
		ubean.setLastName(lname);
		ubean.setEmail(email);
		ubean.setPhoneNo(phone);
		ubean.setDob(bdate);
		ubean.setGender(gender);
		ubean.setSecurityAnswer(answer);
		ubean.setPassword(pass);
		ubean.setCPassword(cpass);

		// Create ArrayList For Storing Multiple Address
		List<AddressBean> address = new ArrayList<>();
		String[] addressLineOne = request.getParameterValues("AddressLineOne");
		String addressLineTwo[] = request.getParameterValues("AddressLineTwo");
		String[] pincode = request.getParameterValues("pincode");
		String city[] = request.getParameterValues("city");
		String state[] = request.getParameterValues("state");

		for (int i = 0; i < addressLineOne.length; i++) {
			AddressBean abean = new AddressBean();
			abean.setAddressLineOne(addressLineOne[i]);
			abean.setAddressLineTwo(addressLineTwo[i]);
			abean.setPincode(pincode[i]);
			abean.setCity(city[i]);
			abean.setState(state[i]);
			address.add(abean);
		}

		try {

			// Create Object of ServiceImpl Class
			UserImpl ck = new UserImpl();
			boolean checkValue = ck.userRegistrationService(ubean, address);
			// If Value is true than SuccessFully Login
			if (checkValue == true) {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("Error" + e);
		}

	}

}
