package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionClass {
	private static final String DB_DRIVER_CLASS = "jdbc.driver";
	private static final String DB_USERNAME = "db.username";
	private static final String DB_PASSWORD = "db.password";
	private static final String DB_URL = "db.url";
	static InputStream fis = null;
	private static Connection con = null;
	private static Properties properties = null;
	static String FilePath = "D:/eclipse/EMSTask/src/main/webapp/WEB-INF/properties/database.properties";

	static {
		try {
			properties = new Properties();
			fis = new FileInputStream(FilePath);
			properties.load(fis);
			Class.forName(properties.getProperty(DB_DRIVER_CLASS));
			con = DriverManager.getConnection(properties.getProperty(DB_URL), properties.getProperty(DB_USERNAME),
					properties.getProperty(DB_PASSWORD));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}

			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}

	public static Connection getConnection() {
		return con;
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

//try {
//Class.forName("com.mysql.cj.jdbc.Driver");
//con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EmployeeManagementTask?useSSL=true",
//		UserName, Password);
//} catch (Exception e) {
//System.out.println(e);
//}