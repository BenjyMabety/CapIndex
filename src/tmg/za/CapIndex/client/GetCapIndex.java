package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetCapIndex implements IsSerializable {
	private int id;
	private String cityName;
	private int stateId;
	private String stateName;
	private String priceUsd;
	private String priceZar;
	private String unitFirstCharge;
	private String surchargePercentage;
	private String surchargeLimit;
	private String surchargePrice;
	private String unitLastPrice;
	private String surchargeFinal;
	private String tourismToken;
	private int bankId;
	private String bankName;

	@SuppressWarnings("unused")
	public GetCapIndex() {
		// just here because GWT wants it.
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(String priceUsd) {
		this.priceUsd = priceUsd;
	}

	public String getTourismToken() {
		return tourismToken;
	}

	public void setTourismToken(String tourismToken) {
		this.tourismToken = tourismToken;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPriceZar() {
		return priceZar;
	}

	public void setPriceZar(String priceZar) {
		this.priceZar = priceZar;
	}

	public String getUnitFirstCharge() {
		return unitFirstCharge;
	}

	public void setUnitFirstCharge(String unitFirstCharge) {
		this.unitFirstCharge = unitFirstCharge;
	}

	public String getSurchargePercentage() {
		return surchargePercentage;
	}

	public void setSurchargePercentage(String surchargePercentage) {
		this.surchargePercentage = surchargePercentage;
	}

	public String getSurchargeLimit() {
		return surchargeLimit;
	}

	public void setSurchargeLimit(String surchargeLimit) {
		this.surchargeLimit = surchargeLimit;
	}

	public String getSurchargePrice() {
		return surchargePrice;
	}

	public void setSurchargePrice(String surchargePrice) {
		this.surchargePrice = surchargePrice;
	}

	public String getUnitLastPrice() {
		return unitLastPrice;
	}

	public void setUnitLastPrice(String unitLastPrice) {
		this.unitLastPrice = unitLastPrice;
	}

	public String getSurchargeFinal() {
		return surchargeFinal;
	}

	public void setSurchargeFinal(String surchargeFinal) {
		this.surchargeFinal = surchargeFinal;
	}

}
