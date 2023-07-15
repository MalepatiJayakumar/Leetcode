package in.fplanner.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class JdbcUtil {

	public static Connection getConnection() throws IOException, SQLException {
//		FileInputStream fis = new FileInputStream("application.properties");
//		Properties properties = new Properties();
//		properties.load(fis);
//		MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
//		dataSource.setURL(properties.getProperty("url"));
//		dataSource.setUser(properties.getProperty("userName"));
//		dataSource.setPassword(properties.getProperty("password"));
//		return dataSource.getConnection();
		HikariDataSource dataSource = null;
		try {
			HikariConfig config = new HikariConfig("application.properties");
			dataSource = new HikariDataSource(config);
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw e;
		}
	}

	public static void cleanUp(Connection connection, Statement stmt, ResultSet resultSet) throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
	}
}