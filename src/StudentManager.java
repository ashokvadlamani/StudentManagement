import java.io.*;
import java.util.ArrayList;

import enums.Standard;

public class StudentManager {

	private ArrayList<Student> students;

	public StudentManager() {
		students = new ArrayList<>();
		readStudentsFromFile();
		
		
	}

	public void saveStudentsToFile() {
		
		try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter("Data/students.csv",true)))
		{
			
			for(Student stu: students)
			{
				fileWriter.write(stu.getId()+",");
				fileWriter.write(stu.getName()+",");
				fileWriter.write(stu.getStandard().name());
				fileWriter.write("\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void readStudentsFromFile()
	{
		try(BufferedReader fileReader = new BufferedReader(new FileReader("Data/students.csv")))
		{
			String line;
			while((line = fileReader.readLine()) != null)
			{
				String arr[] = line.split(",");
				students.add(new Student(Integer.parseInt(arr[0]),arr[1],Standard.valueOf(arr[2])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
