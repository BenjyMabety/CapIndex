package tmg.za.CapIndex.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class GetState implements IsSerializable {
	private int id;
	private String stateName;
	private String stateCode;
	private int stateCountryId;
	private String countyName;

	@SuppressWarnings("unused")
	public GetState() {
		// just here because GWT wants it.
	}

	/**
	 * @param id
	 * @param stateName
	 * @param stateCode
	 * @param stateCountryId
	 * @param countryName
	 */
	public GetState(int id, String stateName, String stateCode, int stateCountryId, String countryName) {
		this.id = id;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.stateCountryId = stateCountryId;
		this.countyName = countryName;

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
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * @return
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return
	 */
	public int getStateCountryId() {
		return stateCountryId;
	}

	/**
	 * @param stateCountryId
	 */
	public void setStateCountryId(int stateCountryId) {
		this.stateCountryId = stateCountryId;
	}

	/**
	 * @return
	 */
	public String getCountyName() {
		return countyName;
	}

	/**
	 * @param countyName
	 */
	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

}
