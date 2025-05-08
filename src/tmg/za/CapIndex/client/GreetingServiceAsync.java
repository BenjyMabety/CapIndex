package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {

	public void authenticateUser(String user, String pass, AsyncCallback<GetAdminUser> callback);

}
