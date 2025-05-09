package tmg.za.CapIndex.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import tmg.za.CapIndex.client.data.GetAdminUser;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {

	public GetAdminUser authenticateUser(String user, String pass);

}
