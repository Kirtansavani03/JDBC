import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class simple_statment {
	
	static String url = "jdbc:mysql://localhost:3306/practice_db";
	static String username = "root";
	static String password = "";
	
	public static void main(String args[]) {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement statement = connection.createStatement();
			
			//to adding data into the database
			statement.execute("insert into student_tbl (name,email,mobile) values ('kirtan savani','kkk@yahoo.com','9898989898')");
			
			//to deleting specific data from the database
			statement.execute("delete from student_tbl where id = 2");
			
			//to deleting all data from the database
			//statement.execute("delete from student_tbl");
			
			//to modify the data into the database
			statement.execute("update student_tbl set name='dhaval' where id = 20");

			//to fetch all data from the database and print using while loop
			ResultSet resultset = statement.executeQuery("select * from student_tbl");
				while(resultset.next()) {
					System.out.println(resultset.getString(1));
					System.out.println(resultset.getString(2));
					System.out.println(resultset.getString(3));
					System.out.println(resultset.getString(4));
				}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
