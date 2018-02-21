package json;

import java.io.Serializable;

public class Student implements Serializable {

	private String firstName;
	private String lastName;
	private String course;
	private int grade;
	
	public Student () {}
	
	public Student (String firstName, String lastName, String course, int grade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.course = course;
		this.grade = grade;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", course=" + course + ", grade=" + grade
				+ "]";
	}

}
