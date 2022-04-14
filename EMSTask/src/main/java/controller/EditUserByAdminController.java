package controller;

import java.io.IOException;
import java.sql.SQLException;
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


@WebServlet("/EditUserByAdminController")
public class EditUserByAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(UpdateUserDetailsController.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		// Get the Email From DataTable
		String Email = request.getParameter("Email");

		try {

			// Create Object of ServiceImpl Class
			UserImpl cuser = new UserImpl();
			UserBean UserData = cuser.getUserByEmail(Email);

			// Get All the Addresses of User
			List<AddressBean> UserAddresses = cuser.getUserAddress(UserData);

			// Set the User Details and Address into Session
			HttpSession session = request.getSession();
			session.setAttribute("User", UserData);
			session.setAttribute("UserAddress", UserAddresses);

		} catch (SQLException e) {
			logger.info("Error" + e);
			e.printStackTrace();
		}

	}

}
