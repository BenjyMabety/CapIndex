package tmg.za.CapIndex.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class GetUser implements IsSerializable {
	private String firstName;
	private String lastName;
	private String cardNumber;
	private int bankID;
	private double loyaltyCredit;
	private String bankName;
	private String id;

	@SuppressWarnings("unused")
	public GetUser() {
		// just here because GWT wants it.
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param cardNumber
	 * @param bankID
	 * @param loyaltyCredit
	 * @param bankName
	 */
	public GetUser(String firstName, String lastName, String cardNumber, int bankID, double loyaltyCredit,
			String bankName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.bankID = bankID;
		this.loyaltyCredit = loyaltyCredit;
		this.bankName = bankName;

	}

	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * @return
	 */
	public int getBankID() {
		return bankID;
	}

	/**
	 * @param bankID
	 */
	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	/**
	 * @return
	 */
	public double getLoyaltyCredit() {
		return loyaltyCredit;
	}

	/**
	 * @param loyaltyCredit
	 */
	public void setLoyaltyCredit(double loyaltyCredit) {
		this.loyaltyCredit = loyaltyCredit;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
