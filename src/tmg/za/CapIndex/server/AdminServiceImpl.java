package tmg.za.CapIndex.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import tmg.za.CapIndex.client.AdminService;
import tmg.za.CapIndex.client.data.GetBank;
import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetRewardHistory;
import tmg.za.CapIndex.shared.MySQLConnection;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class AdminServiceImpl extends RemoteServiceServlet implements AdminService {
	MySQLConnection conn = new MySQLConnection();

	@Override
	public ArrayList<GetBank> getBanks() {
		return conn.getBanks();
	}

	@Override
	public ArrayList<GetRewardHistory> getRewardHistory() {
		return conn.getRewardHistory();
	}

	@Override
	public ArrayList<GetCapIndex> getCapIndex() {
		return conn.getCapIndex();
	}

	@Override
	public ArrayList<GetCapIndex> setCapIndex(ArrayList<GetCapIndex> updates) {
		return conn.setCapIndex(updates);
	}

	@Override
	public String setRewardHistory(GetRewardHistory record) {
		return conn.setRewardHistory(record);
	}

	@Override
	public String updateRewardHistory(String userId) {
		return conn.updateRewardHistory(userId);
	}

}
