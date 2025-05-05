package tmg.za.CapIndex.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.GetCountry;
import tmg.za.CapIndex.client.GetState;
import tmg.za.CapIndex.client.GetAdminUser;
import tmg.za.CapIndex.client.LocationService;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class LocationServiceImpl extends RemoteServiceServlet implements LocationService {
	MySQLConnection conn = new MySQLConnection();

	public GetAdminUser authenticateUser(String user, String pass) {
		// TODO Auto-generated method stub
		return conn.authenticateUser(user, pass);
	}

	@Override
	public ArrayList<GetCountry> getCountries() {
		// TODO Auto-generated method stub
		return conn.getCountries();
	}

	@Override
	public ArrayList<GetState> getStates() {
		// TODO Auto-generated method stub
		return conn.getStates();
	}
}
