package in.fplanner.dto;

public class Employee {
	//INSERT INTO employee(`name`,age,address) VALUES('sai',24,'CHE',20000)
	
	private Long id;
	private String name;
	private Integer age;
	private String address;
	private Long salary;
	
	public Employee(Long id , String name, Integer age, String address,Long salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	
}
