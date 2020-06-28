package Tools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.alibaba.druid.pool.DruidDataSource;

public class DruidTools{
	
	private static DruidDataSource dataSource = null;

	public DruidTools() {
		
	}
	//静态代码块硬连接
	static {
		try {
			    //配置信息
				dataSource = new DruidDataSource();
				dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	            dataSource.setUrl("jdbc:mysql://localhost:3306/study?useSSL=false&allowPublicKeyRetrieval=true");
	            dataSource.setUsername("root");
	            dataSource.setPassword("873802894");
	            dataSource.setInitialSize(10);//初始大小
	            dataSource.setMaxActive(50);//最大
	            dataSource.setMinIdle(10);//最小
	            dataSource.setMaxWait(5000);//最大连接等待超时
	            dataSource.setValidationQuery("SELECT 1");//验证数据库是否连接
		}catch (Exception e) {
			e.printStackTrace();
		}
		//通过配置properties软连接
//		try {
//		Properties properties = new Properties();
//		InputStream inStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("druid.properties");
//			properties.load(inStream);
//			dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	//建立连接时是从连接池中获取一个连接
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//归还连接，关闭语句
	public static void closeAll(ResultSet rs,PreparedStatement pStatement,Connection connection) {
			try {
				if(rs!=null) rs.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}finally {
					try {
					if(pStatement!=null) pStatement.close();
					}catch (SQLException e) {
						e.printStackTrace();
					}finally {
						try {
						if(connection!=null) connection.close();
						}catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
		}
}
