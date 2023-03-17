package question3;

import java.util.*;
import java.io.*;

public class ReadFromFile {
	public static void main(String [] args) throws IOException {
		
	File myFile= new File("students.txt");
	File out= new File("output.ext");
	if(!myFile.exists()) {
		System.out.println("file not found");
		System.exit(0);
	}
	String name= "";
	double sum=0;
	int count=0;
	
	
	FileWriter fileWriter= new FileWriter(out);	
	Scanner inpScanner= new Scanner(myFile);
	
	try {
	
	while (inpScanner.hasNext()) {
		
		 name= inpScanner.next();
		 while(inpScanner.hasNextDouble())
		  {
			 sum += inpScanner.nextDouble();
			 count++;
		  }
			fileWriter.write(name + ", average: " + sum/(double)count+"\n");
			
			System.out.println(name + ", average: " + sum/(double)count );

	}
	
	}catch (IOException ex) {
		System.out.println("error while reading file");	
	}

	
	
	fileWriter.close();
	inpScanner.close();
	}

}
