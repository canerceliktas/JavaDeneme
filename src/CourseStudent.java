

public class CourseStudent extends Student {
	
	//this class inherited from student class
	private boolean failStatus;
	private int missingClassCount;
	
	public CourseStudent(String fullName, int number) {
		super(fullName, number);
		// TODO Auto-generated constructor stub
	}
	
	public String getFailStatus()
	{	
		
		
		if(failStatus)
		{
			return "Fail";
		}
		else
		{
			return "Not Fail";
		}
	}
	
	public boolean isFailStatus() {
		return failStatus;
	}

	public void setFailStatus(boolean failStatus) {
		this.failStatus = failStatus;
	}

	public int getMissingClassCount() {
		return missingClassCount;
	}

	public void setMissingClassCount(int missingClassCount) {
		this.missingClassCount = missingClassCount;
	}

	@Override
	public String toString() {
		return "CourseStudent [failStatus=" + failStatus + ", missingClassCount=" + missingClassCount + "]";
	}

	
	
	
	
	
}
