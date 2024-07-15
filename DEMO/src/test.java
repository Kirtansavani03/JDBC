import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
	static String url = "jdbc:mysql://localhost:3306/demo_db";
	static String username = "root";
	static String password = "";
	
	public static void main(String[] args) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url,username,password);
			Statement st = connection.createStatement();
			
			st.execute("INSERT INTO test_tbl (name,email,mobile) VALUES ('kirtan','k@email.com','6363636363')");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
