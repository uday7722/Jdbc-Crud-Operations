package august;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert {
	
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		String query="insert into employee values(?,?,?)";
		String url="jdbc:mysql://localhost:3306/august?user=root&password=root";
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			
			System.out.println("Enter Empno");
			int empno=scanner.nextInt();	
			preparedStatement.setInt(1, empno);
			
			System.out.println("Enter Ename");
			String ename=scanner.next();
			preparedStatement.setString(2, ename);
			
			System.out.println("Enter Salary");
			int salary=scanner.nextInt();
			preparedStatement.setInt(3, salary);
			
			int insert = preparedStatement.executeUpdate();
			System.out.println(insert+" Records inserted");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
		}
		 
	}

}
