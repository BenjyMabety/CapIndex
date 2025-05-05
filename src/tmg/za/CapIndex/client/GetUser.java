package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetUser implements IsSerializable {
	private String firstName;
	private String lastName;
	private String cardNumber;
	private String bankID;
	private double loyaltyCredit;
	private String bankName;

	@SuppressWarnings("unused")
	public GetUser() {
		// just here because GWT wants it.
	}

	public GetUser(String firstName, String lastName, String cardNumber, String bankID, double loyaltyCredit,
			String bankName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.bankID = bankID;
		this.loyaltyCredit = loyaltyCredit;
		this.bankName = bankName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBankID() {
		return bankID;
	}

	public void setBankID(String bankID) {
		this.bankID = bankID;
	}

	public double getLoyaltyCredit() {
		return loyaltyCredit;
	}

	public void setLoyaltyCredit(double loyaltyCredit) {
		this.loyaltyCredit = loyaltyCredit;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
}
