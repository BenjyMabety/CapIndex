package tmg.za.CapIndex.client.data;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class GetBank implements IsSerializable {
	private int id;
	private String bankName;
	private String bankHq;
	private int bankStateId;
	private String bankStateName;
	private String abaRouting;
	private String bankSwiftCode;

	@SuppressWarnings("unused")
	public GetBank() {
		// just here because GWT wants it.
	}

	/**
	 * @param id
	 * @param bankName
	 * @param bankHq
	 * @param bankStateId
	 * @param bankStateNaame
	 * @param abaRouting
	 * @param bankSwiftCode
	 */
	public GetBank(int id, String bankName, String bankHq, int bankStateId, String bankStateNaame, String abaRouting,
			String bankSwiftCode) {
		this.id = id;
		this.bankName = bankName;
		this.bankHq = bankHq;
		this.bankStateId = bankStateId;
		this.abaRouting = abaRouting;
		this.bankSwiftCode = bankSwiftCode;

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
	public String getBankHq() {
		return bankHq;
	}

	/**
	 * @param bankHq
	 */
	public void setBankHq(String bankHq) {
		this.bankHq = bankHq;
	}

	/**
	 * @return
	 */
	public int getBankStateId() {
		return bankStateId;
	}

	/**
	 * @param bankStateId
	 */
	public void setBankStateId(int bankStateId) {
		this.bankStateId = bankStateId;
	}

	/**
	 * @return
	 */
	public String getBankStateName() {
		return bankStateName;
	}

	/**
	 * @param bankStateNaame
	 */
	public void setBankStateName(String bankStateNaame) {
		this.bankStateName = bankStateNaame;
	}

	/**
	 * @return
	 */
	public String getAbaRouting() {
		return abaRouting;
	}

	/**
	 * @param abaRouting
	 */
	public void setAbaRouting(String abaRouting) {
		this.abaRouting = abaRouting;
	}

	/**
	 * @return
	 */
	public String getBankSwiftCode() {
		return bankSwiftCode;
	}

	/**
	 * @param bankSwiftCode
	 */
	public void setBankSwiftCode(String bankSwiftCode) {
		this.bankSwiftCode = bankSwiftCode;
	}

}
