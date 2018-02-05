package javabeans;

public class UseJavaBean {

	public static void main(String[] args) {
		SampleJavaBean jared = new SampleJavaBean(); // using no argument constructor
		
		jared.setFirstName("Jared"); // use setters to create the object's properties
		jared.setLastName("Kitch");
		jared.setAge(41);
		jared.setHeight(180.3);

		System.out.println(jared);
	}

}
