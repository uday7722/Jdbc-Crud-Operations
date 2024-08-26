package august;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		String query="delete from employee where empno=?";
		String url="jdbc:mysql://localhost:3306/august?user=root&password=root";
		String load="com.mysql.cj.jdbc.Driver";
		
		Connection connection=null;
		try {
			Class.forName(load);
			connection  = DriverManager.getConnection(url);
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			
			System.out.println("Enter empno: ");
			int empno=scanner.nextInt();
			prepareStatement.setInt(1, empno);
			
			int delete = prepareStatement.executeUpdate();
			System.out.println(delete+" rows deleted");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
		}
		
	}

}
