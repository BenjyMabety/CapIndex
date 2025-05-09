package tmg.za.CapIndex.client.data;

import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
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

	/**
	 * @param id
	 * @param rewardDescription
	 * @param rewardTransactionTime
	 * @param rewardUserId
	 * @param userCardNumber
	 * @param rewardAmount
	 * @param finalAmount
	 * @param rewardApplied
	 * @param tokenIndex
	 */
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
	public String getRewardDescription() {
		return rewardDescription;
	}

	/**
	 * @param rewardDescription
	 */
	public void setRewardDescription(String rewardDescription) {
		this.rewardDescription = rewardDescription;
	}

	/**
	 * @return
	 */
	public Date getRewardTransactionTime() {
		return rewardTransactionTime;
	}

	/**
	 * @param rewardTransactionTime
	 */
	public void setRewardTransactionTime(Date rewardTransactionTime) {
		this.rewardTransactionTime = rewardTransactionTime;
	}

	/**
	 * @return
	 */
	public int getRewardUserId() {
		return rewardUserId;
	}

	/**
	 * @param rewardUserId
	 */
	public void setRewardUserId(int rewardUserId) {
		this.rewardUserId = rewardUserId;
	}

	/**
	 * @return
	 */
	public String getUserCardNumber() {
		return userCardNumber;
	}

	/**
	 * @param userCardNumber
	 */
	public void setUserCardNumber(String userCardNumber) {
		this.userCardNumber = userCardNumber;
	}

	/**
	 * @return
	 */
	public double getRewardAmount() {
		return rewardAmount;
	}

	/**
	 * @param rewardAmount
	 */
	public void setRewardAmount(double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	/**
	 * @return
	 */
	public double getFinalAmount() {
		return finalAmount;
	}

	/**
	 * @param finalAmount
	 */
	public void setFinalAmount(double finalAmount) {
		this.finalAmount = finalAmount;
	}

	/**
	 * @return
	 */
	public boolean isRewardApplied() {
		return rewardApplied;
	}

	/**
	 * @param rewardApplied
	 */
	public void setRewardApplied(boolean rewardApplied) {
		this.rewardApplied = rewardApplied;
	}

	/**
	 * @return
	 */
	public int getTokenIndex() {
		return tokenIndex;
	}

	/**
	 * @param tokenIndex
	 */
	public void setTokenIndex(int tokenIndex) {
		this.tokenIndex = tokenIndex;
	}

}
