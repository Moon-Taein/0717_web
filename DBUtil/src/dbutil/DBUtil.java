package dbutil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBUtil {
	private static final Properties PROPS = new Properties();
	private static DataSource ds;

	static {
		try {
			PROPS.load(DBUtil.class.getClassLoader().getResourceAsStream("dbutil/worlds.properties"));

			BasicDataSource basic = new BasicDataSource();

			basic.setUrl(PROPS.getProperty("jdbcURL"));
			basic.setDriverClassName(PROPS.getProperty("jdbcDriverName"));
			basic.setUsername(PROPS.getProperty("jdbcUserName"));
			basic.setPassword(PROPS.getProperty("jdbcPassword"));

			// 처음 connection 갯수
			basic.setInitialSize(0);

			// 최대 connection 갯수
			basic.setMaxTotal(20);

			ds = basic;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
