import java.awt.BorderLayout;

import static javax.swing.JOptionPane.*;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Console;


public class AddCoursePopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField courseNameTextField;
	private JTextField courseMaxCapTextField;
	private JTextField courseFailureLimitTextField;
	
	public void UpdateJList(){
	    MainPage.model = new DefaultListModel<String>();
	    for(Course c : MainPage.myCourseList){
	    	MainPage.model.addElement(c.getCourseName().toString());
	    }    
	    MainPage.courseJList.setModel(MainPage.model);     
	    MainPage.courseJList.setSelectedIndex(0);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddCoursePopUp dialog = new AddCoursePopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddCoursePopUp() {
		setTitle("Add Course");
		setBounds(100, 100, 230, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Course Name");
			lblNewLabel.setBounds(10, 22, 89, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblMaxCapacity = new JLabel("Max. Capacity");
			lblMaxCapacity.setBounds(10, 74, 89, 23);
			contentPanel.add(lblMaxCapacity);
		}
		
		courseNameTextField = new JTextField();
		courseNameTextField.setBounds(10, 43, 190, 20);
		contentPanel.add(courseNameTextField);
		courseNameTextField.setColumns(10);
		
		courseMaxCapTextField = new JTextField();
		courseMaxCapTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					int i = Integer.parseInt(courseMaxCapTextField.getText());
				} catch (NumberFormatException e1)
				{
					showMessageDialog(null, "Only numbers!");
					courseFailureLimitTextField.setText("0");
				}
			}
		});
		
		courseMaxCapTextField.setBounds(10, 96, 73, 20);
		contentPanel.add(courseMaxCapTextField);
		courseMaxCapTextField.setColumns(10);
		
		JLabel lblFailureLimit = new JLabel("Failure Limit");
		lblFailureLimit.setBounds(111, 74, 89, 23);
		contentPanel.add(lblFailureLimit);
		
		courseFailureLimitTextField = new JTextField();
		courseFailureLimitTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				try {
					int i = Integer.parseInt(courseFailureLimitTextField.getText());
				} catch (NumberFormatException e1)
				{
					showMessageDialog(null, "Only numbers!");
					courseFailureLimitTextField.setText("0");
				}
			}
		});
		courseFailureLimitTextField.setColumns(10);
		courseFailureLimitTextField.setBounds(109, 96, 73, 20);
		contentPanel.add(courseFailureLimitTextField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						String courseName = courseNameTextField.getText();
						int studentCapacitiy = Integer.parseInt(courseMaxCapTextField.getText()) ;
						int maxMissingCount = Integer.parseInt(courseFailureLimitTextField.getText());
						Course course = new Course(courseName, studentCapacitiy, maxMissingCount);
						
						MainPage.myCourseList.add(course);
						UpdateJList();
						
						System.out.println("Course added.");
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
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
	}
}
