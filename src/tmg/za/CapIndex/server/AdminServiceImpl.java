package tmg.za.CapIndex.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.AdminService;
import tmg.za.CapIndex.client.GetBank;
import tmg.za.CapIndex.client.GetCapIndex;
import tmg.za.CapIndex.client.GetRewardHistory;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AdminServiceImpl extends RemoteServiceServlet implements AdminService {
	MySQLConnection conn = new MySQLConnection();

	@Override
	public ArrayList<GetBank> getBanks() {
		// TODO Auto-generated method stub
		return conn.getBanks();
	}

	@Override
	public ArrayList<GetRewardHistory> getRewardHistory() {
		// TODO Auto-generated method stub
		return conn.getRewardHistory();
	}

	@Override
	public ArrayList<GetCapIndex> getCapIndex() {
		// TODO Auto-generated method stub
		return conn.getCapIndex();
	}

}
