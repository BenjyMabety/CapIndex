package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>LocationService</code>.
 */
public interface PeopleServiceAsync {
	void getAdminUsers(AsyncCallback<ArrayList<GetAdminUser>> callback);

	void getUsers(AsyncCallback<ArrayList<GetUser>> callback);

}
