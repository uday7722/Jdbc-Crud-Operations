package august;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Read {
	public static void main(String[] args) throws SQLException{
		
		String query="Select * from employee";
		String url="jdbc:mysql://localhost:3306/august?user=root&password=root";
		String load="com.mysql.cj.jdbc.Driver";
		
		Connection connection=null;
		try {
			Class.forName(load);
			connection=DriverManager.getConnection(url);
			PreparedStatement prepareStatement = connection.prepareStatement(query);
			boolean exe = prepareStatement.execute();
			if(exe==true) {
				ResultSet resultSet = prepareStatement.getResultSet();
				
				while(resultSet.next()) {
					System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
				}
			}
	
				
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null)
				connection.close();
		}
		
		
		
	}

}
