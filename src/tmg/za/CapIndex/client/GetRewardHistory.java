package tmg.za.CapIndex.client;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetRewardHistory implements IsSerializable {
	private int id;
	private String rewardDescription;
	private Date rewardTransactionTime;
	private int rewardUserId;
	private String userCardNumber;
	private double rewardAmount;
	private double finalAmount;
	private boolean rewardApplied;
	private int tokenIndex;

	@SuppressWarnings("unused")
	public GetRewardHistory() {
		// just here because GWT wants it.
	}

	public GetRewardHistory(int id, String rewardDescription, Date rewardTransactionTime, int rewardUserId,
			String userCardNumber, double rewardAmount, double finalAmount, boolean rewardApplied, int tokenIndex) {
		this.id = id;
		this.rewardDescription = rewardDescription;
		this.rewardTransactionTime = rewardTransactionTime;
		this.rewardUserId = rewardUserId;
		this.userCardNumber = userCardNumber;
		this.rewardAmount = rewardAmount;
		this.finalAmount = finalAmount;
		this.rewardApplied = rewardApplied;
		this.tokenIndex = tokenIndex;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRewardDescription() {
		return rewardDescription;
	}

	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}

	public Date getRewardTransactionTime() {
		return rewardTransactionTime;
	}

	public void setRewardTransactionTime(Date rewardTransactionTime) {
		this.rewardTransactionTime = rewardTransactionTime;
	}

	public int getRewardUserId() {
		return rewardUserId;
	}

	public void setRewardUserId(int rewardUserId) {
		this.rewardUserId = rewardUserId;
	}

	public String getUserCardNumber() {
		return userCardNumber;
	}

	public void setUserCardNumber(String userCardNumber) {
		this.userCardNumber = userCardNumber;
	}

	public double getRewardAmount() {
		return rewardAmount;
	}

	public void setRewardAmount(double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public double getFinalAmount() {
		return finalAmount;
	}

	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	public boolean isRewardApplied() {
		return rewardApplied;
	}

	public void setRewardApplied(boolean rewardApplied) {
		this.rewardApplied = rewardApplied;
	}

	public int getTokenIndex() {
		return tokenIndex;
	}

	public void setTokenIndex(int tokenIndex) {
		this.tokenIndex = tokenIndex;
	}

}
