
public class Employee {
	
	private long id;
	private String name;
	private String email;
	private String mobile;
	private String department;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", department="
				+ department + "]";
	}
	public Employee(String name, String email, String department, String mobile) {
		this.name = name;
		this.email = email;
		this.department = department;
		this.mobile = mobile;
	}
	
	
}
