import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CourseStudentListTableModel extends AbstractTableModel {
	
	private ArrayList<CourseStudent> studentList = new ArrayList<CourseStudent>();
	String[] col;
	
	

	public CourseStudentListTableModel(ArrayList<CourseStudent> studentList) {
		super();
		this.studentList = studentList;
		this.col = new String[] {"Status", "Name"};
	}
	
	// The object to render in a cell
	  public Object getValueAt(int row, int col) {
		  CourseStudent student = studentList.get(row);
	    switch(col) {
	      case 0: return student.getFailStatus();
	      case 1: return student.getFullName();
	      //case 2: return student.getGender();
	      // to complete here...
	      default: return null;
	    }
	  }

	  // Optional, the name of your column
	  public String getColumnName(int col) {
	    return this.col[col] ;
	  }
/*
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

*/

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
