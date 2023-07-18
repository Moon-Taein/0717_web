package country;

import java.util.List;

public class CountryService {
	public CountryDTO getPage(int pageNum, int pagePer) {
		CountryDAOMySQL countryList = new CountryDAOMySQL();
		List<Country> list = countryList.getByPage(pageNum, 10);

		// 총 리스트의 길이를 알아야함;
		int wholeNumbers = countryList.getWholePagesNumber();
		int wholePages = (wholeNumbers / 10);
		wholePages += wholeNumbers % 10 == 0 ? 0 : 1;

		return new CountryDTO(list, wholePages);
	}

}
