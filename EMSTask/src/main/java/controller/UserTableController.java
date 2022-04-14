package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.BasicConfigurator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import DAO.UserDaoOperations;
import Models.UserBean;

@WebServlet("/UserTableController")
public class UserTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BasicConfigurator.configure();

		UserDaoOperations udao = new UserDaoOperations();

		// Show All the User List into DataTable
		List<UserBean> userdata;
		try {
			// Convert Data into JSON
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			JsonObject json = new JsonObject();
			userdata = udao.showAllUsers();
			json.add("data", gson.toJsonTree(userdata));
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.println(json);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
