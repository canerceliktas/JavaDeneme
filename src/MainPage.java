import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
 

public class MainPage extends JFrame {

	private JPanel contentPane;
	public static JTable StudentTable;
	
	public static Student student1 = new Student("Enes Karakas", 366768, "Male");
	public static Student student2 = new Student("Fusun Öncel", 366769, "Female");
	public static Student student3 = new Student("Su Adanir", 366770, "Female");
	public static Student student4 = new Student("Erol Adin", 366771, "Male");
	public static Student student5 = new Student("Mazhar Okyar", 366772, "Male");
	public static Student student6 = new Student("Hincal Boz", 366773, "Male");
	public static Student student7 = new Student("Uluç Coskun", 366774, "Male");
	public static Student student8 = new Student("Jale Saydam", 366775, "Female");
	public static Student student9 = new Student("Gökhan Sunay", 366776, "Male");
	public static Student student10 = new Student("Esin Ayranci", 366777, "Female");
	
	public static Student student11 = new Student("Irem Önder", 366778, "Female");
	public static Student student12 = new Student("Birdal Dal", 366779, "Male");
	public static Student student13 = new Student("Funda Remzi", 366780, "Female");
	public static Student student14 = new Student("Bülent Dogan", 366781, "Male");
	public static Student student15 = new Student("Dila Altan", 366782, "Female");
	public static Student student16 = new Student("Güvenç Dagdelen", 366783, "Male");
	public static Student student17 = new Student("Erdem Candan", 366784, "Male");
	public static Student student18 = new Student("Yaðmur Enver", 366785, "Female");
	public static Student student19 = new Student("Eser Koca", 366786, "Male");
	public static Student student20 = new Student("Kara Hoca", 366787, "Male");
	
	
	
	public static Course mathCourse = new Course("Math", 20, 4);
	public static Course physicsCourse = new Course("Physics", 15, 4);
	public static Course chemistryCourse = new Course("Chemstry", 25, 3);
	
	
	
	
	public static ArrayList<Student> myStudentList = new ArrayList<Student>();
	public static ArrayList<Course> myCourseList = new ArrayList<Course>();
	
	
	public static StudentListTableModel myStudentListModel = new StudentListTableModel(myStudentList);
	
	public static JList courseJList = new JList();
	
	public static DefaultListModel<String> model;
	public static void UpdateJList(){
	    model = new DefaultListModel<String>();
	    for(Course c : myCourseList){
	         model.addElement(c.getCourseName().toString());
	    }    
	    courseJList.setModel(model);     
	    courseJList.setSelectedIndex(0);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					myStudentList.add(student1);
					myStudentList.add(student2);
					myStudentList.add(student3);
					myStudentList.add(student4);
					myStudentList.add(student5);
					myStudentList.add(student6);
					myStudentList.add(student7);
					myStudentList.add(student8);
					myStudentList.add(student9);
					myStudentList.add(student10);
					myStudentList.add(student11);
					myStudentList.add(student12);
					myStudentList.add(student13);
					myStudentList.add(student14);
					myStudentList.add(student15);
					myStudentList.add(student16);
					myStudentList.add(student17);
					myStudentList.add(student18);
					myStudentList.add(student19);
					myStudentList.add(student20);
					
					myCourseList.add(mathCourse);
					myCourseList.add(physicsCourse);
					myCourseList.add(chemistryCourse);
					
					
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setTitle("Student Attendance");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		courseJList.setBackground(new Color(240, 248, 255));
		courseJList.setBounds(10, 55, 132, 248);
		contentPane.add(courseJList);
		UpdateJList();
		
		
		

		
		
		
		JButton btnAddCourseButton = new JButton("Add Course");
		btnAddCourseButton.setBounds(10, 323, 132, 42);
		contentPane.add(btnAddCourseButton);
		
		btnAddCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCoursePopUp addCourseFrame = new AddCoursePopUp();
				addCourseFrame.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Course List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 24, 132, 30);
		contentPane.add(lblNewLabel);
		
		/*JScrollPane js = new JScrollPane(StudentTable);
		js.setVisible(true);
		add(js);
		*/
		
		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentList.setBounds(185, 24, 132, 30);
		contentPane.add(lblStudentList);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddStudentPopUp addStudentFrame = new AddStudentPopUp();
				addStudentFrame.setVisible(true);
				
			}
		});
		btnAddStudent.setBounds(185, 323, 126, 42);
		contentPane.add(btnAddStudent);
		
		JButton btnShowAttendanceButton = new JButton("Course Page");
		btnShowAttendanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CourseStudentListPopUp courseStudentListFrame = new CourseStudentListPopUp();
				courseStudentListFrame.setVisible(true);
				//CourseStudentListPopUp.courseNameLabel.setText(courseJList.getSelectedValue().toString());
			}
		});
		btnShowAttendanceButton.setBounds(379, 323, 117, 42);
		contentPane.add(btnShowAttendanceButton);
		
		JButton btnExitButton = new JButton("Exit");
		btnExitButton.setBounds(425, 397, 71, 23);
		contentPane.add(btnExitButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 55, 350, 248);
		contentPane.add(scrollPane);
		
		
		StudentTable = new JTable();
		scrollPane.setViewportView(StudentTable);
		StudentTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		StudentTable.setBackground(new Color(240, 248, 255));
		StudentTable.setModel(myStudentListModel/*new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Number", "Gender"
			}
		)*/);
		StudentTable.getColumnModel().getColumn(0).setPreferredWidth(137);
		StudentTable.getColumnModel().getColumn(1).setPreferredWidth(86);
	}
}
