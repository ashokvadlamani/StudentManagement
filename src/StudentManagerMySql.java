import java.util.ArrayList;

import enums.Standard;

import java.sql.*;

public class StudentManagerMySql {

	private ArrayList<Student> students;
	public StudentManagerMySql()
	{
//		students = new ArrayList<>();
//		getStudents();
	}
	public int insertStudent(Student student)
	{
		try(Connection conn = getConnection())
		{
			String insertQuery = "INSERT INTO Students (Id, name, standard) VALUES (?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(insertQuery);
			pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getStandard().name());
            return pstmt.executeUpdate(); //insert, delete update
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return 0;
		}
	}
	private void getStudents()
	{
		String selectStmt = "SELECT id, name, standard FROM students";
		try(Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(selectStmt);
				ResultSet resultSet = pstmt.executeQuery()) //select
		{
			while(resultSet.next())
			{
				students.add( new Student(resultSet.getInt("id"), resultSet.getString("name"),
						Standard.valueOf(resultSet.getString("standard"))));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	private Connection getConnection()
	{
		String url = "jdbc:mysql://localhost:3306/Ashok"; // replace with your DB name
        String user = "root";
        String password = "pwd"; // your MySQL root password
        try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
