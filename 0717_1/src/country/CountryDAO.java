package country;

import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

public interface CountryDAO {
	List<Country> getAll();

	List<Country> getByContinent(String continent);

	List<Country> getByPage(int page, int pagePer);

	int countAll();

	int getWholePagesNumber();
}
