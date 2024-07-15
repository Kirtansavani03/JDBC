import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main{
	
	private static final String url="jdbc:mysql://localhost:3306/demo_db";
	private static final String username="root";
	private static final String password="";
	private static final String query="INSERT INTO student_tbl (name,department,mobile) VALUES (?,?,?)";
	
	public static void main(String args[]) {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection= DriverManager.getConnection(url,username,password);
		Statement st = connection.createStatement();
		PreparedStatement pstm = connection.prepareStatement(query);
		
		//to add data to database
		st.execute("INSERT INTO student_tbl (name,department,mobile) VALUES ('kirtan','IT','6351731536')");
		st.execute("INSERT INTO student_tbl (name,department,mobile) VALUES ('dhaval','IT','8758582282')");
		st.execute("INSERT INTO student_tbl (name,department,mobile) VALUES ('kirtan','IT','9106868415')");
		
		//to delete data from database
		st.execute("DELETE FROM student_tbl WHERE id=2");
		
		//to get data from database and print it
		ResultSet rs= st.executeQuery("SELECT * FROM student_tbl");   
		while(rs.next()){
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println(rs.getString(4));
		}
		
		//to add data into database via prepared statement
		pstm.setString(1,"dhaval");
		pstm.setString(2,"cp");
		pstm.setString(3,"9879879879");
		pstm.execute();
		
		//to add data into database via prepared statement from an csv file 
		FileReader fr = new FileReader("D://eclipse-workspace/csv file/fakedata.csv");
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		while((line = br.readLine())!=null) {
			String data[] = line.split(",");
			
			pstm.setString(1,data[0]);
			pstm.setString(2,data[1]);
			pstm.setString(3,data[2]);
			
			pstm.addBatch();
		}
		pstm.executeBatch();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}