package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import tmg.za.CapIndex.client.data.GetBank;
import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetRewardHistory;

/**
 * The async counterpart of <code>AdminService</code>.
 */
public interface AdminServiceAsync {
	void getBanks(AsyncCallback<ArrayList<GetBank>> callback);

	void getRewardHistory(AsyncCallback<ArrayList<GetRewardHistory>> callback);

	void setRewardHistory(GetRewardHistory record, AsyncCallback<String> callback);

	void updateRewardHistory(String userId, AsyncCallback<String> callback);

	void getCapIndex(AsyncCallback<ArrayList<GetCapIndex>> callback);

	void setCapIndex(ArrayList<GetCapIndex> updates, AsyncCallback<ArrayList<GetCapIndex>> callback);

}
