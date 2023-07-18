package country;

import java.util.List;

public class CountryDTO {
	private List<Country> list;
	private int totalPage;

	public CountryDTO() {
	};

	public CountryDTO(List<Country> list, int totalPage) {
		super();
		this.list = list;
		this.totalPage = totalPage;
	}

	public List<Country> getList() {
		return list;
	};

	public void setList(List<Country> list) {
		this.list = list;
	};

	public int getTotalPage() {
		return totalPage;
	};

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	};

}
