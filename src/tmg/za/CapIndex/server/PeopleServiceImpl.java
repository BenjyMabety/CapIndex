
package tmg.za.CapIndex.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.PeopleService;
import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.client.data.GetUser;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class PeopleServiceImpl extends RemoteServiceServlet implements PeopleService {
	MySQLConnection conn = new MySQLConnection();

	@Override
	public ArrayList<GetAdminUser> getAdminUsers() {
		return conn.getAdminUsers();
	}

	@Override
	public ArrayList<GetUser> getUsers() {
		return conn.getUsers();
	}

	@Override
	public ArrayList<GetUser> setUser(GetUser user) {
		return conn.setUser(user);
	}

}
