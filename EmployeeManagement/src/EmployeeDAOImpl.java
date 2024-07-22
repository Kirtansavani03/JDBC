import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {

	String query;
	Connection connection;
	PreparedStatement preparedstatement;
	static String url = "jdbc:mysql://localhost:3306/demo_db";
	static String username = "root";
	static String password = "";
	
	
	public EmployeeDAOImpl() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		query = "INSERT INTO employee_table (name,email,mobile,department) VALUES (?,?,?,?)";
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1,employee.getName());
			preparedstatement.setString(2,employee.getEmail());
			preparedstatement.setString(3,employee.getMobile());
			preparedstatement.setString(4,employee.getDepartment());
			preparedstatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean removeEmployee(long id) {
		// TODO Auto-generated method stub
		query = "DELETE FROM employee_table WHERE id ="+id;
		
		try {
			
			preparedstatement = connection.prepareStatement(query);
			preparedstatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Employee updateEmployee(Employee employee,long id) {
		// TODO Auto-generated method stub
		query = "UPDATE employee_table SET name=?, email=?, mobile=?, department=? WHERE id=?";
		
		try {
			
			preparedstatement = connection.prepareStatement(query);	
			preparedstatement.setString(1,employee.getName());
			preparedstatement.setString(2,employee.getEmail());
			preparedstatement.setString(3,employee.getMobile());
			preparedstatement.setString(4,employee.getDepartment());
			preparedstatement.setLong(5,employee.getId());

		//	preparedstatement.execute();
			int rowsAffected = preparedstatement.executeUpdate();
	        if (rowsAffected > 0) {
	            return employee;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public Employee getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
