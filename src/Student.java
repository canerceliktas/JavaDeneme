import java.util.Date;

public class Student {
	
	private String FullName;
	private int number;
	private String gender;


	
	
	
	public Student(String fullName, int number, String gender) {
		super();
		FullName = fullName;
		this.number = number;
		this.gender = gender;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public Student(String fullName, int number) {
		super();
		FullName = fullName;
		this.number = number;
	}
	
	
	
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}

		
	
}
