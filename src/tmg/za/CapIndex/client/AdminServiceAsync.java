package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>AdminService</code>.
 */
public interface AdminServiceAsync {
	void getBanks(AsyncCallback<ArrayList<GetBank>> callback);

	void getRewardHistory(AsyncCallback<ArrayList<GetRewardHistory>> callback);

	void getCapIndex(AsyncCallback<ArrayList<GetCapIndex>> callback);

	void setCapIndex(ArrayList<GetCapIndex> updates, AsyncCallback<ArrayList<GetCapIndex>> callback);

}
