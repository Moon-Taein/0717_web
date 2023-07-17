package country;

import java.util.List;

public interface CountryDAO {
	List<Country> getAll();

	List<Country> getByContinent(String continent);

	List<Country> getByPage(int page, int pagePer);

	int getWholePagesNumber();
}
