package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetCountry implements IsSerializable {
	private int id;
	private String countryName;
	private String countryCode;

	@SuppressWarnings("unused")
	public GetCountry() {
		// just here because GWT wants it.
	}

	public GetCountry(int id, String countryName, String countryCode) {
		this.id = id;
		this.countryName = countryName;
		this.countryCode = countryCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
