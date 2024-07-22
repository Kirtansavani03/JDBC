
public class main {

	public static void main(String[] args) {
		
		//to insert employee data into database
		Employee em = new Employee("kirtan","k@gmail.com","9879879879","it");
		Employee em1 = new Employee("dhaval","d@gmail.com","6546546546","it");

		EmployeeDAOImpl eml = new EmployeeDAOImpl();
		//eml.createEmployee(em);
		
		//to delete data from database
		eml.removeEmployee(1);
		
		//to update the data
		eml.updateEmployee(em1,2);

	}

}
