package tmg.za.CapIndex.client;

import java.sql.Timestamp;

import com.google.gwt.user.client.rpc.IsSerializable;

public class GetAdminUser implements IsSerializable {
	private String username;
	private Timestamp last_login;
	private Timestamp created_date;

	@SuppressWarnings("unused")
	public GetAdminUser() {
		// just here because GWT wants it.
	}

	public GetAdminUser(String username, String password) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Timestamp getLast_login() {
		return last_login;
	}

	public void setLast_login(Timestamp last_login) {
		this.last_login = last_login;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp created_date) {
		this.created_date = created_date;
	}
}
