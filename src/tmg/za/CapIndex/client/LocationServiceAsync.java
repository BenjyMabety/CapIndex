package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetState;

/**
 * The async counterpart of <code>LocationService</code>.
 */
public interface LocationServiceAsync {
	void getCountries(AsyncCallback<ArrayList<GetCountry>> callback);

	void getStates(AsyncCallback<ArrayList<GetState>> callback);

}
