package View;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import DAO.ConnectionClass;

@WebServlet("/CheckEmailExist")
public class CheckEmailExist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CheckEmailExist.class.getName());

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		String UserEmail = request.getParameter("Email");
		logger.info(UserEmail);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String getData = "SELECT * FROM users WHERE email=?";
			ps = ConnectionClass.getConnection().prepareStatement(getData);
			ps.setString(1, UserEmail);
			rs = ps.executeQuery();

			if (rs.next()) {
				logger.info(rs.getString(4));
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("Already Exist!!");
			} else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.print("");
			}
		} catch (SQLException e) {
			logger.error("Error is :" + e);
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					logger.info("Error" + e);
					e.printStackTrace();
				}
			}
			if (ConnectionClass.getConnection() == null) {
				ConnectionClass.closeConnection();
			}

		}
	}

}
