package tmg.za.CapIndex.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import tmg.za.CapIndex.client.data.GetBank;
import tmg.za.CapIndex.client.data.GetCapIndex;
import tmg.za.CapIndex.client.data.GetCountry;
import tmg.za.CapIndex.client.data.GetRewardHistory;
import tmg.za.CapIndex.client.data.GetState;
import tmg.za.CapIndex.client.data.GetUser;
import tmg.za.CapIndex.shared.StringUtils;

public class Simulator extends Composite {

	private final static LocationServiceAsync locationService = GWT.create(LocationService.class);
	private final static AdminServiceAsync adminService = GWT.create(AdminService.class);
	private final static PeopleServiceAsync peopleService = GWT.create(PeopleService.class);

	private int units = 0;
	private GetCountry country;
	private String countryValue;
	private String stateValue;
	private GetCapIndex selectedIndex;
	private GetRewardHistory historyRecord;
	ArrayList<GetCountry> countries = new ArrayList<GetCountry>();
	ArrayList<GetState> states = new ArrayList<GetState>();
	ArrayList<GetCapIndex> index = new ArrayList<GetCapIndex>();
	ArrayList<GetBank> banks = new ArrayList<GetBank>();

	TextBox tbCup = new TextBox();
	PushButton enterButton = new PushButton("Enter");
	PushButton enterButtonQ2 = new PushButton("Enter");
	PushButton enterButtonQ3 = new PushButton("Enter");
	PushButton enterButtonQ4 = new PushButton("Submit");

	VerticalPanel vp = new VerticalPanel();
	SimplePanel panel = new SimplePanel();
	ListBox lbCountry = new ListBox();
	ListBox lbState = new ListBox();
	ListBox lbCityName = new ListBox();
	TextBox firstName = new TextBox();
	TextBox lastName = new TextBox();
	TextBox cardNumber = new TextBox();
	ListBox lbBank = new ListBox();
	ListBox applyLoyalty = new ListBox();

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
				stateValue = lbState.getSelectedValue();
				for (GetCapIndex i : index) {
					if (i.getStateId() == Integer.valueOf(stateValue)) {
						selectedIndex = i;
					}
				}
				vp.clear();
				startQ4();

			}
		});
		enterButtonQ4.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GetUser user = new GetUser();
				user.setId(
						StringUtils.getMd5(firstName.getValue() + " " + lastName.getValue() + cardNumber.getValue()));
				user.setFirstName(firstName.getValue());
				user.setLastName(lastName.getValue());
				user.setCardNumber(cardNumber.getValue());
				user.setBankID(Integer.valueOf(lbBank.getSelectedValue()));
				if (applyLoyalty.getSelectedIndex() == 1) {
					Window.alert("minus");
					user.setLoyaltyCredit(-1.2);
				} else {
					Window.alert("plus");
					user.setLoyaltyCredit(0.2);
				}
				peopleService.setUser(user, new AsyncCallback<ArrayList<GetUser>>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(ArrayList<GetUser> result) {
						if (applyLoyalty.getSelectedIndex() == 1) {
							Window.alert("here 1");
							updateHistoryRecords(user);

						} else {
							Window.alert("here 2");
							insertHistoryRecord(user);
						}

					}

				});
				vp.clear();
				vp.add(new Label("Thank you for your service!"));

			}
		});

		lbState.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// Window.alert(lbState.getSelectedValue());
				filterCity(lbState.getSelectedValue());

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
		adminService.getBanks(new AsyncCallback<ArrayList<GetBank>>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(ArrayList<GetBank> result) {

				banks = result;
				for (GetBank bank : banks) {
					lbBank.addItem(bank.getBankName(), String.valueOf(bank.getId()));
				}

			}
		});

		lbCityName.addItem("Which City?");
	}

	protected void filterCity(String selectedValue) {
		lbCityName.clear();
		// Window.alert(index.size() + "");
		for (GetCapIndex indexItem : index) {
			// Window.alert(selectedValue + " vs " + indexItem.getStateId());
			if (String.valueOf(indexItem.getStateId()) == selectedValue) {
				lbCityName.addItem(indexItem.getCityName(), String.valueOf(indexItem.getId()));
			}
		}

	}

	private void insertHistoryRecord(GetUser user) {
		historyRecord = new GetRewardHistory();
		historyRecord.setRewardDescription(tbCup.getValue() + " cups- Cappuccino");
		historyRecord.setRewardTransactionTime(new Timestamp(new Date().getTime()));
		historyRecord.setRewardAmount(user.getLoyaltyCredit());
		historyRecord.setRewardUserId(user.getId());
		historyRecord.setId(StringUtils
				.getMd5(historyRecord.getTokenIndex() + historyRecord.getRewardTransactionTime().toString()));
		historyRecord.setFinalAmount(user.getLoyaltyCredit() * 18.5);
		historyRecord.setTokenIndex(selectedIndex.getId());
		historyRecord.setRewardApplied(false);
		historyRecord.setUserCardNumber(user.getCardNumber());
		adminService.setRewardHistory(historyRecord, new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(String result) {
				// Window.alert("Here 5");
				Window.alert(result);
			}
		});

	}

	private void updateHistoryRecords(GetUser user) {
		// TODO Auto-generated method stub
		Window.alert("here 3");
		adminService.updateRewardHistory(user.getId(), new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(String result) {
				// Window.alert("Here 5");
				Window.alert(result);
			}
		});

	}

	public void start(SimplePanel panel) {

		vp.clear();
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
		Label forReal = new Label("For real? Which Where?");
		HorizontalPanel hp = new HorizontalPanel();
		Label from = new Label("Straight out of: ");
		hp.add(from);
		hp.add(lbState);
		hp.add(lbCityName);
		vp.add(forReal);
		vp.add(hp);
		vp.add(enterButtonQ3);
		panel.add(vp);

	}

	protected void startQ4() {
		Label sweet = new Label("Sweet! Cool so your Cappuccinno order of " + units + " will cost :R" + getTotalPrice()
				+ " since it costs R" + getZarPrice() + " for one. Your have acquired a Tourism Token: "
				+ getTourismToken()
				+ ". This will be used when redeeming your next order using a coupon discount. Can I have your card please?");
		Label firstNameLabel = new Label("First Name:");
		HorizontalPanel firstPanel = new HorizontalPanel();
		firstPanel.add(firstNameLabel);
		firstPanel.add(firstName);

		Label lastNameLabel = new Label("Last Name:");
		HorizontalPanel lastPanel = new HorizontalPanel();
		lastPanel.add(lastNameLabel);
		lastPanel.add(lastName);

		Label cardNumberLabel = new Label("Card Number:");
		HorizontalPanel cardPanel = new HorizontalPanel();
		cardPanel.add(cardNumberLabel);
		cardPanel.add(cardNumber);

		Label bankLabel = new Label("Bank");
		HorizontalPanel bankPanel = new HorizontalPanel();
		bankPanel.add(bankLabel);
		bankPanel.add(lbBank);

		Label loyaltyLabel = new Label("Apply Loyalty (Yes/No)");
		HorizontalPanel loyaltyPanel = new HorizontalPanel();
		loyaltyPanel.add(loyaltyLabel);
		applyLoyalty.addItem("Nothing Selected");
		applyLoyalty.addItem("Yes");
		applyLoyalty.addItem("No");
		applyLoyalty.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				// TODO Auto-generated method stub
				if (applyLoyalty.getSelectedIndex() == 1) {

				}

			}
		});
		loyaltyPanel.add(applyLoyalty);

		vp.add(sweet);
		vp.add(firstPanel);
		vp.add(lastPanel);
		vp.add(cardPanel);
		vp.add(bankPanel);
		vp.add(loyaltyPanel);
		vp.add(enterButtonQ4);
		panel.add(vp);

	}

	private String getTourismToken() {
		// TODO Auto-generated method stub
		return selectedIndex.getTourismToken();
	}

	// Get via cityname and state what the price is as args for this method
	private String getZarPrice() {
		// TODO Auto-generated method stub

		return selectedIndex.getPriceZar();
	}

	private double getTotalPrice() {
		// TODO Auto-generated method stub

		return Double.valueOf(selectedIndex.getPriceZar()) * units;
	}

	public void setIndex(ArrayList<GetCapIndex> index) {
		// Window.alert(("F" + "from main: " + index.size()));
		this.index = index;
	}

}
