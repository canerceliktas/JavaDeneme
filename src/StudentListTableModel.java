import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class StudentListTableModel extends AbstractTableModel {
	
	private ArrayList<Student> studentList = new ArrayList<Student>();
	String[] col;
	
	

	public StudentListTableModel(ArrayList<Student> studentList) {
		super();
		this.studentList = studentList;
		this.col = new String[] {"Name", "Number", "Gender"};
	}
	
	// The object to render in a cell
	  public Object getValueAt(int row, int col) {
		  Student student = studentList.get(row);
	    switch(col) {
	      case 0: return student.getNumber();
	      case 1: return student.getFullName();
	      case 2: return student.getGender();
	      // to complete here...
	      default: return null;
	    }
	  }

	  // Optional, the name of your column
	  public String getColumnName(int col) {
	    return this.col[col] ;
	  }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studentList.size();
	}


	
}
