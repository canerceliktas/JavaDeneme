import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddStudentPopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField studentNameTextField;
	private JTextField studentNumberTextField;
	
	String gender[] = {"Female", "Male", "Other"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddStudentPopUp dialog = new AddStudentPopUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddStudentPopUp() {
		setBounds(100, 100, 253, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			studentNameTextField = new JTextField();
			studentNameTextField.setBounds(10, 47, 202, 20);
			contentPanel.add(studentNameTextField);
			studentNameTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Student Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel.setBounds(10, 11, 137, 29);
			contentPanel.add(lblNewLabel);
		}
		{
			studentNumberTextField = new JTextField();
			studentNumberTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					try {
						int i = Integer.parseInt(studentNumberTextField.getText());
					} catch (NumberFormatException e1)
					{
						System.out.println("Only numbers!!");						
						studentNumberTextField.setText("0");
					}
				}
			});
			studentNumberTextField.setBounds(10, 110, 202, 20);
			contentPanel.add(studentNumberTextField);
			studentNumberTextField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Student Number");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 78, 122, 21);
			contentPanel.add(lblNewLabel_1);
		}
		
		JComboBox comboBox = new JComboBox(gender);
		comboBox.setBounds(10, 177, 74, 22);
		contentPanel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 141, 122, 21);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveStudentBtn = new JButton("Save");
				saveStudentBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Student student = new Student(studentNameTextField.getText(), Integer.parseInt(studentNumberTextField.getText()));
						student.setGender(comboBox.getSelectedItem().toString());
						
						MainPage.myStudentList.add(student);
						MainPage.StudentTable.revalidate();
					}
				});
				saveStudentBtn.setActionCommand("OK");
				buttonPane.add(saveStudentBtn);
				getRootPane().setDefaultButton(saveStudentBtn);
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
