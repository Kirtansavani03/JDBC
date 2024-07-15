

import java.sql.*;

public class main {
	
	private static final String url="jdbc:mysql://localhost:3306/demo_db";
	private static final String username="root";
	private static final String password="";

	
	public static void main(String args[]) {
		try {
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection(url,username,password);
		Statement st = connection.createStatement();
		st.execute("INSERT INTO student_tbl (name,department,mobile) VALUES ('kirtan','IT','6351731536')");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
