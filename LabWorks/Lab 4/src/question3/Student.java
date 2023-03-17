package question3;

public class Student {
	private int studentId;
	private String studentName;

	public Student() {
	}

	public Student(int stId, String stName) {
		studentId = stId;
		studentName = stName;
	}

	public void setStudentId(int number) {
		studentId = number;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentName(String name) {
		studentName = name;
	}

	public String getStudentName() {
		return studentName;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}
  	
}