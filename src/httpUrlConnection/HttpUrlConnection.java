package httpUrlConnection;

import java.io.*;
import java.net.*;

public class HttpUrlConnection {

	public static void main(String[] args) throws Exception {
		
		// specify the URL we're connecting to
		URL url = new URL("http://www.luxsome.com"); 
		
		// open connection to url
		HttpURLConnection urlCon = (HttpURLConnection) url.openConnection(); 
		
		// create a buffer to read the connection into
		BufferedReader buffer = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
		
        System.out.println("Received response code: " + urlCon.getResponseCode() + "\n");
		
		String lineOfCode = null;
		System.out.println("This page (" + url.toString() + ") contains these links:");
		while((lineOfCode = buffer.readLine()) != null) { // loop through lines of code until the end
			if (lineOfCode.toLowerCase().contains("<a href=")) {				
				System.out.println(lineOfCode);
			}
		}
		
		// close the buffer and connection
		buffer.close();
		urlCon.disconnect();

	}

}
