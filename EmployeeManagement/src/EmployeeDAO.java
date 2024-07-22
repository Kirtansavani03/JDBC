
public interface EmployeeDAO {
	
	public void createEmployee(Employee employee);
	public boolean removeEmployee(long id);
	public Employee updateEmployee(Employee employee,long id);
	public Employee getEmployee(long id);
	
}
