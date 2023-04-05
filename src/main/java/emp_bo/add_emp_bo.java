package emp_bo;

public class add_emp_bo {
	private String id;
	
	private String name;
	
	private String Phone_no;
	
	private String Email;
   private String Brith_date;
	
	private String Adhare;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return Phone_no;
	}

	public void setPhone_no(String phone_no) {
		Phone_no = phone_no;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getBrith_date() {
		return Brith_date;
	}

	public void setBrith_date(String brith_date) {
		Brith_date = brith_date;
	}

	public String getAdhare() {
		return Adhare;
	}

	public void setAdhare(String adhare) {
		Adhare = adhare;
	}

	public add_emp_bo(String id, String name, String phone_no, String email, String brith_date, String adhare) {
		super();
		this.id = id;
		this.name = name;
		this.Phone_no = phone_no;
		this.Email = email;
		this.Brith_date = brith_date;
		this.Adhare = adhare;
	}

	@Override
	public String toString() {
		return "add_emp_bo [id=" + id + ", name=" + name + ", Phone_no=" + Phone_no + ", Email=" + Email
				+ ", Brith_date=" + Brith_date + ", Adhare=" + Adhare + "]";
	}

	public add_emp_bo() {
		super();
	}

}