package tmg.za.CapIndex.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class GetCountry implements IsSerializable {
	private int id;
	private String countryName;
	private String countryCode;

	@SuppressWarnings("unused")
	public GetCountry() {
		// just here because GWT wants it.
	}

	/**
	 * @param id
	 * @param countryName
	 * @param countryCode
	 */
	public GetCountry(int id, String countryName, String countryCode) {
		this.id = id;
		this.countryName = countryName;
		this.countryCode = countryCode;
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
