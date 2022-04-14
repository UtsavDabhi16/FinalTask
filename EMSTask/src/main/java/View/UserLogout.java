package View;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebServlet("/UserLogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(UserLogout.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try

		{
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.getAttribute("email");
				session.getAttribute("User");
				session.getAttribute("UserAddress");
				session.invalidate();
				response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1 must-revalidate
				response.setHeader("Pragma", "no-cache"); // HTTP 1.0
				response.setHeader("Expires", "0"); // Proxy
				response.sendRedirect("login.jsp");
				logger.info("You are successfully logged out!");

			}
		} catch (Exception e) {
			logger.info(e);
		}
	}
}
