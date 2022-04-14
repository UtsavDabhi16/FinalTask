package controller;

import java.io.IOException;
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
import service.AdminImpl;
import service.UserImpl;
import service.Validation;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginController.class.getName());
	final String secretKey = "HelloWorld!!!";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BasicConfigurator.configure();

		// Get the Details From User
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upassword");

		UserImpl userImpl = new UserImpl();
		UserBean userData;
		try {
			userData = userImpl.getUserByEmail(email);
			String dpass = Validation.decrypt(userData.getPassword(), secretKey);
			logger.info("decrypt pass is" + dpass);
			boolean validUser = Validation.comparePassword(pass, dpass);
			logger.info(validUser);
			if (validUser) {
				// Create the Object of UserBean Class
				UserBean bean = new UserBean();
				try {
					AdminImpl cadmin = new AdminImpl();
					bean.setEmail(email);
					bean.setPassword(dpass);

					// Check Which Type of User
					int UserType = cadmin.checkUserType(bean);

					if (UserType == 2) {

						// Create Session and redirect to Admin Profile
						HttpSession session = request.getSession();
						session.setAttribute("adminname", email);
						response.sendRedirect("admin.jsp");

					} else if (UserType == 1) {

						// Create Object Of ServiceImpl Class
						UserImpl cuser = new UserImpl();

						// Create Session and redirect to User Profile
						HttpSession session = request.getSession();
						session.setAttribute("email", email);

						// Get User Details and Addresses
						UserBean UserData = cuser.getUserByEmail(email);
						List<AddressBean> UserAddresses = cuser.getUserAddress(UserData);
						session.setAttribute("User", UserData);
						session.setAttribute("UserAddress", UserAddresses);
						response.sendRedirect("UserProfile.jsp");

					} else {
						request.getRequestDispatcher("login.jsp").include(request, response);
					}

				} catch (Exception e) {

					e.printStackTrace();
					logger.error("Error" + e);
				}
			} else {
				logger.info("User is Not Valid !!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error" + e);
		}
	}
}
