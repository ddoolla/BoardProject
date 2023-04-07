package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection conn;
	public Statement stmt;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public JDBConnect(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("OracleDriver"));
			conn = DriverManager.getConnection(
						application.getInitParameter("OracleURL"),
						application.getInitParameter("OracleId"),
						application.getInitParameter("OraclePass")
					);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	public void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//close()
	
	
}
