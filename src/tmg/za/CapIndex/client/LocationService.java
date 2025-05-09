package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetState;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("locate")
public interface LocationService extends RemoteService {
	ArrayList<GetCountry> getCountries();

	ArrayList<GetState> getStates();

}
