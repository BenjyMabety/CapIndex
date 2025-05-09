package tmg.za.CapIndex.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
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
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * @return
	 */
	public int getStateId() {
		return stateId;
	}

	/**
	 * @param stateId
	 */
	public void setStateId(int stateId) {
		this.stateId = stateId;
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
	public String getPriceUsd() {
		return priceUsd;
	}

	/**
	 * @param priceUsd
	 */
	public void setPriceUsd(String priceUsd) {
		this.priceUsd = priceUsd;
	}

	/**
	 * @return
	 */
	public String getTourismToken() {
		return tourismToken;
	}

	/**
	 * @param tourismToken
	 */
	public void setTourismToken(String tourismToken) {
		this.tourismToken = tourismToken;
	}

	/**
	 * @return
	 */
	public int getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 */
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return
	 */
	public String getPriceZar() {
		return priceZar;
	}

	/**
	 * @param priceZar
	 */
	public void setPriceZar(String priceZar) {
		this.priceZar = priceZar;
	}

	/**
	 * @return
	 */
	public String getUnitFirstCharge() {
		return unitFirstCharge;
	}

	/**
	 * @param unitFirstCharge
	 */
	public void setUnitFirstCharge(String unitFirstCharge) {
		this.unitFirstCharge = unitFirstCharge;
	}

	/**
	 * @return
	 */
	public String getSurchargePercentage() {
		return surchargePercentage;
	}

	/**
	 * @param surchargePercentage
	 */
	public void setSurchargePercentage(String surchargePercentage) {
		this.surchargePercentage = surchargePercentage;
	}

	/**
	 * @return
	 */
	public String getSurchargeLimit() {
		return surchargeLimit;
	}

	/**
	 * @param surchargeLimit
	 */
	public void setSurchargeLimit(String surchargeLimit) {
		this.surchargeLimit = surchargeLimit;
	}

	/**
	 * @return
	 */
	public String getSurchargePrice() {
		return surchargePrice;
	}

	/**
	 * @param surchargePrice
	 */
	public void setSurchargePrice(String surchargePrice) {
		this.surchargePrice = surchargePrice;
	}

	/**
	 * @return
	 */
	public String getUnitLastPrice() {
		return unitLastPrice;
	}

	/**
	 * @param unitLastPrice
	 */
	public void setUnitLastPrice(String unitLastPrice) {
		this.unitLastPrice = unitLastPrice;
	}

	/**
	 * @return
	 */
	public String getSurchargeFinal() {
		return surchargeFinal;
	}

	/**
	 * @param surchargeFinal
	 */
	public void setSurchargeFinal(String surchargeFinal) {
		this.surchargeFinal = surchargeFinal;
	}

}
