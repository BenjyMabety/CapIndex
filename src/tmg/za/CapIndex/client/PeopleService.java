package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("people")
public interface PeopleService extends RemoteService {
	ArrayList<GetAdminUser> getAdminUsers();

	ArrayList<GetUser> getUsers();

}
