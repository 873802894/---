import java.sql.Connection;

import org.junit.Test;

import Tools.DruidTools;

public class TestJUnit {
	@Test
	public void DruidTest() {
		for(int i =0 ;i<101;i++) {
			Connection connection = DruidTools.getConnection();
			if(connection!=null) {
			System.out.println(connection.toString()+"\n----------");}
			DruidTools.closeAll(null, null, connection);
		}
	}
		
	
}
