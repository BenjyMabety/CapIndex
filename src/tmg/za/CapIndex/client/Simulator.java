package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetState;

public class Simulator extends Composite {

	private final static LocationServiceAsync locationService = GWT.create(LocationService.class);

	private int units = 0;
	private GetCountry country;
	private String countryValue;
	private String stateValue;
	ArrayList<GetCountry> countries = new ArrayList<GetCountry>();
	ArrayList<GetState> states = new ArrayList<GetState>();
	ArrayList<GetCapIndex> index = new ArrayList<GetCapIndex>();

	TextBox tbCup = new TextBox();
	PushButton enterButton = new PushButton("Enter");
	PushButton enterButtonQ2 = new PushButton("Enter");
	PushButton enterButtonQ3 = new PushButton("Enter");
	VerticalPanel vp = new VerticalPanel();
	SimplePanel panel = new SimplePanel();
	ListBox lbCountry = new ListBox();
	ListBox lbState = new ListBox();

	public Simulator() {

		enterButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				units = Integer.valueOf(tbCup.getValue());
				vp.clear();
				startQ2();

			}
		});

		enterButtonQ2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				countryValue = lbCountry.getSelectedValue();
				vp.clear();
				startQ3();

			}
		});
		enterButtonQ3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				vp.clear();
				startQ4();

			}
		});

		locationService.getCountries(new AsyncCallback<ArrayList<GetCountry>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(ArrayList<GetCountry> result) {

				for (GetCountry country : result) {
					lbCountry.addItem(country.getCountryName(), String.valueOf(country.getId()));
				}
			}
		});

		locationService.getStates(new AsyncCallback<ArrayList<GetState>>() {

			@Override
			public void onFailure(Throwable caught) {
			}

			@Override
			public void onSuccess(ArrayList<GetState> result) {

				for (GetState state : result) {
					lbState.addItem(state.getStateName(), String.valueOf(state.getId()));
				}
			}
		});
	}

	public void start(SimplePanel panel) {

		this.panel = panel;
		Label greeting = new Label("Hi! My name is Sim. May I take your order please?");
		vp.add(greeting);
		HorizontalPanel inputCup = new HorizontalPanel();
		Label cup = new Label("Cappuccino Unit(s)");
		inputCup.add(tbCup);
		inputCup.add(cup);
		vp.add(inputCup);
		vp.add(enterButton);
		this.panel.add(vp);

	}

	protected void startQ2() {
		Label tellMe = new Label("Tell me, where are you from buddy?");
		HorizontalPanel hp = new HorizontalPanel();
		Label from = new Label("I'm from: ");
		hp.add(from);
		hp.add(lbCountry);
		vp.add(tellMe);
		vp.add(hp);
		vp.add(enterButtonQ2);
		panel.add(vp);

	}

	protected void startQ3() {
		Label forReal = new Label("For real? Which state?");
		HorizontalPanel hp = new HorizontalPanel();
		Label from = new Label("Straight out of: ");
		hp.add(from);
		hp.add(lbState);
		vp.add(forReal);
		vp.add(hp);
		vp.add(enterButtonQ3);
		panel.add(vp);

	}

	protected void startQ4() {
		// Label sweet = new Label("Sweet! Cool so your Cappuccinno order of "+units+"
		// will cost :"+getPrice()+" since it costs"+"");

	}

	public ArrayList<GetCountry> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<GetCountry> countries) {
		this.countries = countries;
	}

	public ArrayList<GetCapIndex> getIndex() {
		return index;
	}

	public void setIndex(ArrayList<GetCapIndex> index) {
		this.index = index;
	}

}
