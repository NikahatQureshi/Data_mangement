package emp_bo;

public class singup_bo {
	private String Username;

	 private int Password;
     private String Full_Name;
	
	public singup_bo() {
		super();
	}

	public singup_bo(String username, int password, String full_Name, String phone_number, String email) {
		super();
		Username = username;
		Password = password;
		Full_Name = full_Name;
		Phone_number = phone_number;
		Email = email;
	}

	@Override
	public String toString() {
		return "singup_bo [Username=" + Username + ", Password=" + Password + ", Full_Name=" + Full_Name
				+ ", Phone_number=" + Phone_number + ", Email=" + Email + "]";
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getPassword() {
		return Password;
	}

	public void setPassword(int password) {
		Password = password;
	}

	public String getFull_Name() {
		return Full_Name;
	}

	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	private String Phone_number;
	
	private String Email;

}
