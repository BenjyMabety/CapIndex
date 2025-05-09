package tmg.za.CapIndex.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.LocationService;
import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetState;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LocationServiceImpl extends RemoteServiceServlet implements LocationService {
	MySQLConnection conn = new MySQLConnection();

	public GetAdminUser authenticateUser(String user, String pass) {
		return conn.authenticateUser(user, pass);
	}

	@Override
	public ArrayList<GetCountry> getCountries() {
		return conn.getCountries();
	}

	@Override
	public ArrayList<GetState> getStates() {
		return conn.getStates();
	}
}
