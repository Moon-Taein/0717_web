package country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import dbutil.DBUtil;

public class CountryDAOMySQL implements CountryDAO {

	public CountryDAOMySQL() {
	};

	@Override
	public int countAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT Count(*) AS cnt FROM country");

			while (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return -1;
	}

	@Override
	public List<Country> getAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Country> list = new ArrayList<>();

		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select Name, Population from country");

			while (rs.next()) {
				String name = rs.getString("Name");
				int population = rs.getInt("Population");

				list.add(new Country(name, population));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Country> getByContinent(String continent) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Country> list = new ArrayList<>();

		try {
			String sql = "select Name, Population from country where continent = ?";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, continent);
			rs = stmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("Name");
				int population = rs.getInt("Population");

				list.add(new Country(name, population));
			}

		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Country> getByPage(int page, int pagePer) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Country> list = new ArrayList<>();

		try {
			String sql = "select Name, Population from country order by name limit ? offset ? ";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);

			int offset = (page - 1) * pagePer;
			stmt.setInt(1, pagePer);
			stmt.setInt(2, offset);

			rs = stmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("Name");
				int population = rs.getInt("Population");

				list.add(new Country(name, population));
			}

		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public int getWholePagesNumber() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int countWhole = 0;

		try {
			String sql = "select count(*) as countWhole from country";
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int count = rs.getInt("countWhole");
				countWhole = count;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw e;
			throw new RuntimeException(e);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(conn);
		}

		return countWhole;
	}

}
