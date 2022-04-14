//package filter;
//
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.Logger;
//import controller.LoginController;
//import service.Validation;
//
//@WebFilter(servletNames = "LoginController")
//public class AuthenticationFilter extends HttpFilter implements Filter {
//	private static final long serialVersionUID = 1L;
//	private static final Logger logger = Logger.getLogger(LoginController.class.getName());
//
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//
//		BasicConfigurator.configure();
//
//		// Get Email and Password From User
//		String email = request.getParameter("uemail");
//		String pass = request.getParameter("upassword");
//
//		if (email.isEmpty() && pass.isEmpty()) {
//
//			if (Validation.isValidemail(email) && Validation.isValidpass(pass)) {
//				// Sending request to next
//				chain.doFilter(request, response);
//			}
//
//			// Password incorrect
//			else {
//				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
//				rd.include(request, response);
//			}
//		} else {
//			logger.info("Email or Password Can't Be Empty");
//		}
//	}
//}
