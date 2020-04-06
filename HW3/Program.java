import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;
import java.util.AbstractMap.SimpleEntry;
import java.util.Collections;

public class Program {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter the input filename: ");
		String fileName = reader.next();
		reader.close();
		try {
			List<SimpleEntry<String, Date>> people = new ArrayList<SimpleEntry<String, Date>>();
			File file = new File(fileName);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            String line = "";
            String[] columns;
            while ((line = bufferedReader.readLine()) != null) {
            	columns = line.split(" ");
            	people.add(new SimpleEntry<String, Date>(columns[0], new Date(columns[1])));
            }

            bufferedReader.close();
            file = new File("output.txt");
            FileOutputStream outputStream = new FileOutputStream(file);

            if (!file.exists()) {
				file.createNewFile();
			}

            Collections.sort(people, Collections.reverseOrder(new DateComparator()));

        	line = "";
        	for (SimpleEntry<String, Date> entry : people) {
        		line = entry.getValue().toString() + " " + entry.getKey() + "\r\n";
        		outputStream.write(line.getBytes());
        		outputStream.flush();
        	}
        	outputStream.close();
        	System.out.println("output.txt has been created");
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
