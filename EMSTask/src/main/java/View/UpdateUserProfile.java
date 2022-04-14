package View;

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
import DAO.UserDaoOperations;
import Models.AddressBean;
import Models.UserBean;

@WebServlet("/UpdateUserProfile")
public class UpdateUserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("UserProfile.jsp");
		} else {
			UserBean ubean = (UserBean) session.getAttribute("User");
			UserDaoOperations udao = new UserDaoOperations();
			List<AddressBean> userdata;
			try {
				userdata = udao.getCurrentUserAddress(ubean);
				session.setAttribute("User", ubean);
				session.setAttribute("UserAddress", userdata);
				response.sendRedirect("updateuser.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			

		}
	}

}
