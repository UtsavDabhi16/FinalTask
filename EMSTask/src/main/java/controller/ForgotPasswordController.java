package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import Models.UserBean;
import service.UserImpl;


@WebServlet("/ForgotPasswordController")
public class ForgotPasswordController extends HttpServlet {

	private static final Logger logger = Logger.getLogger(ForgotPasswordController.class.getName());
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		// Get the Details From User
		String email = request.getParameter("useremail");
		String phone = request.getParameter("userphoneno");
		String answer = request.getParameter("useranswer");
		String nPassword = request.getParameter("newpassword");

		// Set the Value into UserBean
		UserBean ubean = new UserBean();
		ubean.setEmail(email);
		ubean.setPhoneNo(phone);
		ubean.setSecurityAnswer(answer);
		ubean.setNewPassword(nPassword);

		try {
			UserImpl cuser = new UserImpl();
			boolean checkValue = cuser.userForgotPasswordService(ubean);
			logger.info(checkValue);
			// If it is true than User Can SuccessFully Login
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
