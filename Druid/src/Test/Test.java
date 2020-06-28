package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Tools.DruidTools;

public class Test {

	public static void main(String[] args) throws SQLException{
		
		DruidTools druidTools = new DruidTools();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
//		Statement statement = null;
		ResultSet rs = null;
		connection = druidTools.getConnection();
		
		System.out.println("请输入一个ID");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		scanner.close();
		
		String sql = "select * from person where id=?";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);

		rs = preparedStatement.executeQuery();
		while(rs.next()) {
			int id1 = rs.getInt("id");
			String name = rs.getString("name");
			
			System.out.println("id: " + id1 +
							" name: " + name );
		}
		druidTools.closeAll(rs, preparedStatement, connection);
	
 }
}
