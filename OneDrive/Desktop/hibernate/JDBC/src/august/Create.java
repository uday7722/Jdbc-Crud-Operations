package august;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {
	public static void main(String[] args) throws SQLException {
		String query = "CREATE TABLE employee (empno INT PRIMARY KEY, ename VARCHAR(7), sal INT)";
		String url="jdbc:mysql://localhost:3306/august?user=root&password=root";
		
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url);
			Statement statement=connection.createStatement();
			int rs=statement.executeUpdate(query);
			System.out.println(rs);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
		}
	}

}
