package tmg.za.CapIndex.client.data;

import java.sql.Timestamp;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * 
 */
public class GetAdminUser implements IsSerializable {
	private String username;
	private Timestamp lastLogin;
	private Timestamp createdDate;

	@SuppressWarnings("unused")
	public GetAdminUser() {
		// just here because GWT wants it.
	}

	/**
	 * @param username
	 * @param password
	 */
	public GetAdminUser(String username, String password) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public Timestamp getlastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 */
	public void setlastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return
	 */
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
}
