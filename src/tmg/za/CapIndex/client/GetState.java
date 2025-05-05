package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

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

	public GetState(int id, String stateName, String stateCode, int stateCountryId, String countryName) {
		this.id = id;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.stateCountryId = stateCountryId;
		this.countyName = countryName;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public int getStateCountryId() {
		return stateCountryId;
	}

	public void setStateCountryId(int stateCountryId) {
		this.stateCountryId = stateCountryId;
	}

	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

}
