package tmg.za.CapIndex.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.GreetingService;
import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	MySQLConnection conn = new MySQLConnection();

	public GetAdminUser authenticateUser(String user, String pass) {
		return conn.authenticateUser(user, pass);
	}
}
