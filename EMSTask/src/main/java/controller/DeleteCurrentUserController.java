package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import service.UserImpl;

@WebServlet("/DeleteCurrentUserController")
public class DeleteCurrentUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(DeleteCurrentUserController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		// Get the UserID
		String UserID = request.getParameter("uid");

		// Create Object of ServiceImpl Class
		UserImpl cuser = new UserImpl();

		int result;

		try {
			// User Delete SuccessFully
			result = cuser.userDeleteService(Integer.parseInt(UserID));
			logger.info(result);

		} catch (NumberFormatException e) {

			e.printStackTrace();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
