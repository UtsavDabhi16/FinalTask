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

@WebServlet("/ResetPasswordController")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private static final Logger logger = Logger.getLogger(ResetPasswordController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BasicConfigurator.configure();

		// Get the Details From User
//		String currentPassword = request.getParameter("oldpassword");
//		logger.info(currentPassword);
//		String newPassword = request.getParameter("newpassword");
//		String confirmPassword = request.getParameter("cpassword");
//		
//
//		// Set the Val	ue into UserBean
//		UserBean ubean = new UserBean();
//		ubean.setNewPassword(currentPassword);
//		ubean.setPassword(newPassword);
//		ubean.setCPassword(confirmPassword);
//		
//		try {
//			UserImpl cuser = new UserImpl();
//			boolean checkValue = cuser.userResetPasswordService(ubean);
//			logger.info(checkValue);
//			// If it is true than User Can SuccessFully Login
//			if (checkValue == true) {
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//				rd.forward(request, response);
//			} else {
//				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
//				rd.include(request, response);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.info("Error" + e);
//		}
//
	}

}
