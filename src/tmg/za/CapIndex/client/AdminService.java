package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import tmg.za.CapIndex.client.data.GetBank;
import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetRewardHistory;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("admin")
public interface AdminService extends RemoteService {
	ArrayList<GetBank> getBanks();

	ArrayList<GetRewardHistory> getRewardHistory();

	ArrayList<GetCapIndex> getCapIndex();

	ArrayList<GetCapIndex> setCapIndex(ArrayList<GetCapIndex> updates);

}
