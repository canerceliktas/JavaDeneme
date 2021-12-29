import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CourseStudentListPopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable courseStudentListTable;
	private JTable studentListTable;
	
	private CourseStudentListTableModel myCourseStudentList;
	private JTextField stdntMissCnt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CourseStudentListPopUp dialog = new CourseStudentListPopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CourseStudentListPopUp() {
		setBounds(100, 100, 680, 430);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Course Name :");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 11, 109, 27);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Number of missing class");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(30, 298, 148, 14);
		contentPanel.add(lblNewLabel_1);
		
		JButton addStudentCrsBtn = new JButton("<");
		
		addStudentCrsBtn.setBounds(306, 131, 48, 23);
		contentPanel.add(addStudentCrsBtn);
		
		JButton removeStudentCrsBtn = new JButton(">");
		
		removeStudentCrsBtn.setBounds(306, 165, 48, 23);
		contentPanel.add(removeStudentCrsBtn);
		
		JLabel lblNewLabel_1_1 = new JLabel("Max. number to miss :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(30, 320, 148, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel maxNumOfMisslbl = new JLabel("...");
		maxNumOfMisslbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maxNumOfMisslbl.setBounds(188, 322, 37, 14);
		contentPanel.add(maxNumOfMisslbl);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 264, 215);
		contentPanel.add(scrollPane);
		
		
		courseStudentListTable = new JTable();
		courseStudentListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		myCourseStudentList = new CourseStudentListTableModel(MainPage.myCourseList.get(0).getStudentList());
		courseStudentListTable.setModel(myCourseStudentList);
		
			/*courseStudentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Status", "Name"
			}
		));*/
		courseStudentListTable.getColumnModel().getColumn(1).setPreferredWidth(218);
		scrollPane.setViewportView(courseStudentListTable);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(381, 53, 273, 215);
		contentPanel.add(scrollPane_1);
		
		studentListTable = new JTable();
		studentListTable.setModel(MainPage.myStudentListModel);
		scrollPane_1.setViewportView(studentListTable);
		studentListTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentListTable.setBackground(new Color(240, 248, 255));
		
		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudentList.setBounds(381, 11, 109, 27);
		contentPanel.add(lblStudentList);
		
		
		MainPage.UpdateJList();
		
		DefaultComboBoxModel dml= new DefaultComboBoxModel();
		for (int i = 0; i < MainPage.myCourseList.size(); i++) {
		  dml.addElement(MainPage.myCourseList.get(i).getCourseName());
		}
		JComboBox coursListcomboBox = new JComboBox();
		coursListcomboBox.setBounds(122, 15, 152, 22);
		coursListcomboBox.setModel(dml);;  //CouseList model (we used it in MainPage.java for JList. We can use it here)
		contentPanel.add(coursListcomboBox);
		coursListcomboBox.setSelectedIndex(0);
		
		JLabel studentMissCourseNumlbl = new JLabel("...");
		studentMissCourseNumlbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentMissCourseNumlbl.setBounds(188, 300, 37, 14);
		contentPanel.add(studentMissCourseNumlbl);
		
		stdntMissCnt = new JTextField();
		stdntMissCnt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
	                // something like...
	               //mTextField.getText();
	               // or...
	               //mButton.doClick();
					try {
						int cnt = Integer.parseInt(stdntMissCnt.getText());
						
						for (int i = 0; i < MainPage.myCourseList.size(); i++) {
							  if(coursListcomboBox.getSelectedItem().toString().equals(MainPage.myCourseList.get(i).getCourseName()))
							  {		
								  
								  int row = courseStudentListTable.getSelectedRow();
								  
								  MainPage.myCourseList.get(i).get(row).setMissingClassCount(cnt);
								  MainPage.myCourseList.get(i).evaulateStudent();
								  
								//  System.out.println("Selected Name :"+name);
								//  System.out.println("Selected Number :"+number);
								  
								courseStudentListTable.revalidate();
								  
								  
							  }
							}
					} catch (NumberFormatException e1)
					{
						System.out.println("Only numbers!!");						
						//studentNumberTextField.setText("0");
					}
					
	            }
			}
		});
		stdntMissCnt.setBounds(212, 297, 48, 20);
		contentPanel.add(stdntMissCnt);
		stdntMissCnt.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false); //you can't see me!
						dispose(); //Destroy the JFrame object
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		
		addStudentCrsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (int i = 0; i < MainPage.myCourseList.size(); i++) {
				  if(coursListcomboBox.getSelectedItem().toString().equals(MainPage.myCourseList.get(i).getCourseName()))
				  {		
					  
					  int row = studentListTable.getSelectedRow();
					  String name = studentListTable.getValueAt(row, 1).toString();
					  String number = studentListTable.getValueAt(row, 0).toString();
					  
					  System.out.println("Selected Row :"+studentListTable.getSelectedRow());
					//  System.out.println("Selected Name :"+name);
					//  System.out.println("Selected Number :"+number);
					  
					  CourseStudent student = new CourseStudent(name, Integer.parseInt(number));
					  MainPage.myCourseList.get(i).addStudentList(student);	
					  System.out.println("Added Student :"+student.getFullName()+ " to "+MainPage.myCourseList.get(i).getCourseName());
					  courseStudentListTable.revalidate();
					  
					  
				  }
				}
				
			}
		});
		
		removeStudentCrsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < MainPage.myCourseList.size(); i++) {
				  if(coursListcomboBox.getSelectedItem().toString().equals(MainPage.myCourseList.get(i).getCourseName()))
				  {
					  int row = courseStudentListTable.getSelectedColumn();
					  
					  MainPage.myCourseList.get(i).remove(row);
					  
					  /*System.out.println("Removed Student :"+MainPage.myCourseList.get(i).get(row).getFullName()+ "to "
					  + MainPage.myCourseList.get(i).getCourseName());*/
					  courseStudentListTable.revalidate();
					  
				  }
				}
				
			}
		});
		
		coursListcomboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("Action oluþtu !!");
		    	for (int i = 0; i < MainPage.myCourseList.size(); i++) {
					  if(coursListcomboBox.getSelectedItem().toString().equals(MainPage.myCourseList.get(i).getCourseName()))
					  {	
						  MainPage.myCourseList.get(i).evaulateStudent();
						  
						  myCourseStudentList = new CourseStudentListTableModel(MainPage.myCourseList.get(i).getStudentList());
						  courseStudentListTable.setModel(myCourseStudentList);
						  courseStudentListTable.revalidate();
						  
						  maxNumOfMisslbl.setText(""+MainPage.myCourseList.get(i).getMaxMissingCount());
						  //if(courseStudentListTable.getSelectedRow()!=0)
							 // studentMissCourseNumlbl.setText(""+MainPage.myCourseList.get(i).get(courseStudentListTable.getSelectedRow()).getMissingClassCount());
						  try {
							  studentMissCourseNumlbl.setText(""+MainPage.myCourseList.get(i).get(courseStudentListTable.getSelectedRow()).getMissingClassCount());

						  }
						  catch (IndexOutOfBoundsException e1) {
							// TODO: handle exception
							  System.out.println("IndexOutOfBoundsException exception");
						  }
						  
						  
					  }
					}		    			    	
		    	
		    }
		});
		
		courseStudentListTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Selected row : " + courseStudentListTable.getSelectedRows().toString());
				for (int i = 0; i < MainPage.myCourseList.size(); i++) {
					  if(coursListcomboBox.getSelectedItem().toString().equals(MainPage.myCourseList.get(i).getCourseName()))
					  {	
							 // studentMissCourseNumlbl.setText(""+MainPage.myCourseList.get(i).get(courseStudentListTable.getSelectedRow()).getMissingClassCount());
						  try {
							  studentMissCourseNumlbl.setText(""+MainPage.myCourseList.get(i).get(courseStudentListTable.getSelectedRow()).getMissingClassCount());
							  stdntMissCnt.setText(""+MainPage.myCourseList.get(i).get(courseStudentListTable.getSelectedRow()).getMissingClassCount());
						  }
						  catch (IndexOutOfBoundsException e1) {
							// TODO: handle exception
							  System.out.println("IndexOutOfBoundsException exception");
						  }
						  
						  
					  }
					}
				
			}
		});
	}
}
