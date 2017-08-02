package it.cast.jdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class jdbcUtils {
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASS;
	static{
		DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverclass");
		URL = ResourceBundle.getBundle("jdbc").getString("url");
		USERNAME = ResourceBundle.getBundle("jdbc").getString("user");
		PASS = ResourceBundle.getBundle("jdbc").getString("pass");
	}
	static{
		try {
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnect() throws SQLException{
		Connection con = DriverManager.getConnection(URL, USERNAME, PASS);
		return con;
	}
	public static void closeCon(Connection con) throws SQLException{
		if(con != null){
			con.close();
		}
	}
	public static void closeSt(Statement st) throws SQLException{
		if(st != null){
			st.close();
		}
	}
	public static void closeRs(ResultSet rs) throws SQLException{
		if(rs != null){
			rs.close();
		}
	}
}
