package august;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	public static void main(String[] args) throws SQLException {
		Scanner scanner=new Scanner(System.in);
		String query="Update employee set ename=? where empno=?";
		String url="jdbc:mysql://localhost:3306/august?user=root&password=root";

		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(query);

			System.out.println("Enter the name: ");
			String ename=scanner.next();
			preparedStatement.setString(1, ename);

			System.out.println("Enter empno");
			int empno=scanner.nextInt();
			preparedStatement.setInt(2, empno);

			int update=preparedStatement.executeUpdate();
			System.out.println(update+" row Updated");

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
		}	
	}	
}
