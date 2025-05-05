package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.IsSerializable;

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

	public GetBank(int id, String bankName, String bankHq, int bankStateId, String bankStateNaame, String abaRouting,
			String bankSwiftCode) {
		this.id = id;
		this.bankName = bankName;
		this.bankHq = bankHq;
		this.bankStateId = bankStateId;
		this.abaRouting = abaRouting;
		this.bankSwiftCode = bankSwiftCode;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankHq() {
		return bankHq;
	}

	public void setBankHq(String bankHq) {
		this.bankHq = bankHq;
	}

	public int getBankStateId() {
		return bankStateId;
	}

	public void setBankStateId(int bankStateId) {
		this.bankStateId = bankStateId;
	}

	public String getBankStateName() {
		return bankStateName;
	}

	public void setBankStateName(String bankStateNaame) {
		this.bankStateName = bankStateNaame;
	}

	public String getAbaRouting() {
		return abaRouting;
	}

	public void setAbaRouting(String abaRouting) {
		this.abaRouting = abaRouting;
	}

	public String getBankSwiftCode() {
		return bankSwiftCode;
	}

	public void setBankSwiftCode(String bankSwiftCode) {
		this.bankSwiftCode = bankSwiftCode;
	}

}
