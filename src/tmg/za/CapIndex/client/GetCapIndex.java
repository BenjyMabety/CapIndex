package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetCapIndex implements IsSerializable {
	private int id;
	private String cityName;
	private int stateId;
	private String stateName;
	private double priceUsd;
	private double priceZar;
	private double unitFirstCharge;
	private double surchargePercentage;
	private double surchargeLimit;
	private double surchargePrice;
	private double unitLastPrice;
	private double surchargeFinal;
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

	public double getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(double priceUsd) {
		this.priceUsd = priceUsd;
	}

	public double getPriceZar() {
		return priceZar;
	}

	public void setPriceZar(double priceZar) {
		this.priceZar = priceZar;
	}

	public double getUnitFirstCharge() {
		return unitFirstCharge;
	}

	public void setUnitFirstCharge(double unitFirstCharge) {
		this.unitFirstCharge = unitFirstCharge;
	}

	public double getSurchargePercentage() {
		return surchargePercentage;
	}

	public void setSurchargePercentage(double surchargePercentage) {
		this.surchargePercentage = surchargePercentage;
	}

	public double getSurchargeLimit() {
		return surchargeLimit;
	}

	public void setSurchargeLimit(double surchargeLimit) {
		this.surchargeLimit = surchargeLimit;
	}

	public double getSurchargePrice() {
		return surchargePrice;
	}

	public void setSurchargePrice(double surchargePrice) {
		this.surchargePrice = surchargePrice;
	}

	public double getUnitLastPrice() {
		return unitLastPrice;
	}

	public void setUnitLastPrice(double unitLastPrice) {
		this.unitLastPrice = unitLastPrice;
	}

	public double getSurchargeFinal() {
		return surchargeFinal;
	}

	public void setSurchargeFinal(double surchargeFinal) {
		this.surchargeFinal = surchargeFinal;
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

}
