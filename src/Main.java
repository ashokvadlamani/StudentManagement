import enums.Standard;

public class Main {

	public static void main(String[] args) {
//		StudentManager studentManager = new StudentManager();
//		studentManager.saveStudentsToFile();
		StudentManagerMySql studentManagerMySql = new StudentManagerMySql();
		studentManagerMySql.insertStudent(new Student(1,"Ashok",Standard.Tenth));

	}

}
