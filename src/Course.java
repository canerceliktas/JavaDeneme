import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Course {
	
	private String courseName;
	private int studentCapacitiy;
	private int maxMissingCount;
	private ArrayList<CourseStudent> studentList = new ArrayList<CourseStudent>();

	public void evaulateStudent()
	{	
		for(int i = 0; i<studentList.size(); i++)
		{
			if(studentList.get(i).getMissingClassCount()>this.maxMissingCount)
			{
				studentList.get(i).setFailStatus(true);
			}
			else
			{
				studentList.get(i).setFailStatus(false);
			}
		}
		
	}
	
	

	public Course(String courseName, int studentCapacitiy, int maxMissingCount, ArrayList<CourseStudent> studentList) {
		super();
		this.courseName = courseName;
		this.studentCapacitiy = studentCapacitiy;
		this.maxMissingCount = maxMissingCount;
		this.studentList = studentList;
	}
	
	public Course(String courseName, int studentCapacitiy, int maxMissingCount) {
		super();
		this.courseName = courseName;
		this.studentCapacitiy = studentCapacitiy;
		this.maxMissingCount = maxMissingCount;
	}

	public Course(String courseName, int studentCapacitiy, ArrayList<CourseStudent> studentList) {
		super();
		this.courseName = courseName;
		this.studentCapacitiy = studentCapacitiy;
		this.studentList = studentList;
	}

	public Course(String courseName, ArrayList<CourseStudent> studentList) {
		super();
		this.courseName = courseName;
		this.studentList = studentList;
	}

	public Course(String courseName) {
		super();
		this.courseName = courseName;
	}
	
	/********GETTER AND SETTER METHODS*****************/
	public int getMaxMissingCount() {
		return maxMissingCount;
	}

	public void setMaxMissingCount(int maxMissingCount) {
		this.maxMissingCount = maxMissingCount;
	}
	
	public int getStudentCapacitiy() {
		return studentCapacitiy;
	}

	public void setStudentCapacitiy(int studentCapacitiy) {
		this.studentCapacitiy = studentCapacitiy;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public ArrayList<CourseStudent> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<CourseStudent> studentList) {
		this.studentList = studentList;
	}
	
	public void addStudentList(CourseStudent student){
		this.studentList.add(student);
	}
	
	
	public boolean add(CourseStudent e) {
		return studentList.add(e);
	}

	public void add(int index, CourseStudent element) {
		studentList.add(index, element);
	}

	public boolean addAll(Collection<? extends CourseStudent> c) {
		return studentList.addAll(c);
	}

	public void clear() {
		studentList.clear();
	}

	public boolean contains(Object o) {
		return studentList.contains(o);
	}

	public boolean containsAll(Collection<?> arg0) {
		return studentList.containsAll(arg0);
	}

	public CourseStudent get(int index) {
		return studentList.get(index);
	}

	public Iterator<CourseStudent> iterator() {
		return studentList.iterator();
	}

	public CourseStudent remove(int index) {
		return studentList.remove(index);
	}

	public boolean remove(Object o) {
		return studentList.remove(o);
	}

	public boolean removeAll(Collection<?> c) {
		return studentList.removeAll(c);
	}

	@Override
	public String toString() {
		return courseName;
	}
	
	
	
}
