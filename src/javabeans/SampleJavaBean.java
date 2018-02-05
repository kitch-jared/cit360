package javabeans;

/*
 *  JavaBeans are ordinary java classes that conform to certain rules with the aim of creating reusable code
 *  Serializable
 *  Private fields
 *  Zero-argument constructor
 *  Standard getter/setter functions
 */

import java.io.Serializable;

public class SampleJavaBean implements Serializable { // Should be Serializable
	
	private String firstName; // All fields should be private
	private String lastName;
	private int age;
	private double height;
	
	public SampleJavaBean() { // Needs a zero-argument constructor
	}

	public SampleJavaBean(String firstName, String lastName, int age, double height) { // Optionally overload with parameters
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
	}

	public String getFirstName() { // Needs getters and setters with standard names (getX, setX, isX)
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "firstName = " + firstName +
				"\nlastName = " + lastName +
				"\nage = " + age +
				"\nheight = " + height;
	}
	
	

}
