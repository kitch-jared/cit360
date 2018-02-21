package json;

import java.io.*;
import java.util.HashMap;
import org.quickconnectfamily.json.*;

/*
 * JSON is JavaScript Object Notation. Simply, it is a lightweight way to store data in a human readable format.
 * qcJSON is a small java library which was designed to make JSON easier to use in Java.
 */

public class JsonDemo {

	public static void main(String[] args) {
		
		Student jared = new Student("Jared", "Kitch", "CIT360", 99);
		String jsonString = null;
		File jsonFile = new File("src/json/output.json");
		
		try {
			jsonString = JSONUtilities.stringify(jared); // create a JSON line of test
			System.out.println("This is a JSON line stringified from a Student object\n"
					+ jsonString);
		} catch(Exception e) {
			e.printStackTrace();
		}

		try {
			FileOutputStream fileStream = new FileOutputStream(jsonFile); // open a file for output
			JSONOutputStream jsonStream = new JSONOutputStream(fileStream); // direct JSON output to open file
			jsonStream.writeObject(jared); // write object to the JSON stream
			jsonStream.close();
			System.out.println("\nThe object was successfully written to output.json");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream fileStream = new FileInputStream(jsonFile); // open a file to read
			JSONInputStream jsonStream = new JSONInputStream(fileStream); // direct JSON read from open file
			HashMap jsonInput = (HashMap)jsonStream.readObject(); // read line from JSON stream
			jsonStream.close();

			System.out.println("\nThis is a JSON object read from the file\n"
					+ jsonInput);
			
			// Now we will use the retrieved data...
			
			Student temp = new Student("John", "Doe", "B101", 76);
			System.out.println("\nThis is the temp object before changes\n"
					+ temp);
			
			Long retrievedGrade = (Long)jsonInput.get("grade");
			temp.setFirstName((String)jsonInput.get("firstName"));
			temp.setLastName((String)jsonInput.get("lastName"));
			temp.setCourse((String)jsonInput.get("course"));
			temp.setGrade(retrievedGrade.intValue());
			
			System.out.println("\nThis is the temp object after changes\n"
					+ temp);
					
					
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
