package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.client.data.GetUser;

/**
 * The async counterpart of <code>PeopleService</code>.
 */
public interface PeopleServiceAsync {
	void getAdminUsers(AsyncCallback<ArrayList<GetAdminUser>> callback);

	void getUsers(AsyncCallback<ArrayList<GetUser>> callback);

	void setUser(GetUser user, AsyncCallback<ArrayList<GetUser>> callback);

}
