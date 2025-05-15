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

/**
 * 
 */
public class Simulator extends Composite {

	private final static LocationServiceAsync locationService = GWT.create(LocationService.class);
	private final static AdminServiceAsync adminService = GWT.create(AdminService.class);
	private final static PeopleServiceAsync peopleService = GWT.create(PeopleService.class);

	private int units = 0;
	private String stateValue;
	private GetCapIndex selectedIndex;
	private GetRewardHistory historyRecord;
	private GetUser selectedUser = new GetUser();
	ArrayList<GetCountry> countries = new ArrayList<GetCountry>();
	ArrayList<GetState> states = new ArrayList<GetState>();
	ArrayList<GetCapIndex> index = new ArrayList<GetCapIndex>();
	ArrayList<GetBank> banks = new ArrayList<GetBank>();
	ArrayList<GetUser> users = new ArrayList<GetUser>();

	TextBox tbCup = new TextBox();
	PushButton enterButton = new PushButton("Enter");
	PushButton enterButtonQ2 = new PushButton("Enter");
	PushButton enterButtonQ3 = new PushButton("Enter");
	PushButton submitButton = new PushButton("Submit");

	VerticalPanel vpDisplay = new VerticalPanel();
	SimplePanel canvasPanel = new SimplePanel();
	ListBox lbCountry = new ListBox();
	ListBox lbState = new ListBox();
	ListBox lbCityName = new ListBox();
	TextBox lbFirstName = new TextBox();
	TextBox lbLastName = new TextBox();
	TextBox lbCardNumber = new TextBox();
	ListBox lbBank = new ListBox();
	ListBox lbLoyalty = new ListBox();

	/**
	 * 
	 */
	public Simulator() {

		enterButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				units = Integer.valueOf(tbCup.getValue());
				vpDisplay.clear();
				startQ2();

			}
		});

		enterButtonQ2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				vpDisplay.clear();
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
				vpDisplay.clear();
				startQ4();

			}
		});
		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				GetUser user = new GetUser();
				user.setId(StringUtils
						.getMd5(lbFirstName.getValue() + " " + lbLastName.getValue() + lbCardNumber.getValue()));
				user.setFirstName(lbFirstName.getValue());
				user.setLastName(lbLastName.getValue());
				user.setCardNumber(lbCardNumber.getValue());
				user.setBankID(Integer.valueOf(lbBank.getSelectedValue()));
				if (lbLoyalty.getSelectedIndex() == 1) {
					user.setLoyaltyCredit(-selectedUser.getLoyaltyCredit());
				} else {
					user.setLoyaltyCredit(0.2);
				}
				peopleService.setUser(user, new AsyncCallback<ArrayList<GetUser>>() {

					@Override
					public void onFailure(Throwable caught) {

					}

					@Override
					public void onSuccess(ArrayList<GetUser> result) {
						users = result;
						if (lbLoyalty.getSelectedIndex() == 1) {
							updateHistoryRecords(user);

						} else {
							insertHistoryRecord(user);
						}
						// reloadSim();
					}

				});
				vpDisplay.clear();
				vpDisplay.add(new Label("Thank you for your service!"));

			}
		});

		lbState.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
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
					if (country.getId() == 1) {
						lbCountry.addItem(country.getCountryName(), String.valueOf(country.getId()));
					}
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

		peopleService.getUsers(new AsyncCallback<ArrayList<GetUser>>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(ArrayList<GetUser> result) {
				users = result;

			}
		});

		lbCityName.addItem("Which City?");
	}

	/*
	 * protected void reloadSim() { peopleService.getUsers(new
	 * AsyncCallback<ArrayList<GetUser>>() {
	 * 
	 * @Override public void onFailure(Throwable caught) {
	 * 
	 * }
	 * 
	 * @Override public void onSuccess(ArrayList<GetUser> result) { users = result;
	 * 
	 * } }); tbCup.setValue(""); lbCountry.setSelectedIndex(0);
	 * lbState.setSelectedIndex(0); lbCityName.clear(); lbFirstName.setValue("");
	 * lbLastName.setValue(""); lbCardNumber.setValue("");
	 * lbBank.setSelectedIndex(0); lbLoyalty.setSelectedIndex(0);
	 * 
	 * }
	 */

	/**
	 * @param selectedValue
	 */
	protected void filterCity(String selectedValue) {
		lbCityName.clear();
		for (GetCapIndex indexItem : index) {
			if (String.valueOf(indexItem.getStateId()) == selectedValue) {
				lbCityName.addItem(indexItem.getCityName(), String.valueOf(indexItem.getId()));
			}
		}

	}

	/**
	 * @param user
	 */
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
				Window.alert(result);
			}
		});

	}

	/**
	 * @param user
	 */
	private void updateHistoryRecords(GetUser user) {
		adminService.updateRewardHistory(user.getId(), new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {

			}

			@Override
			public void onSuccess(String result) {
				Window.alert(result);
			}
		});

	}

	/**
	 * @param panel
	 */
	public void start(SimplePanel panel) {

		vpDisplay.clear();
		this.canvasPanel = panel;
		Label greeting = new Label("Hi! My name is Sim. May I take your order please?");
		vpDisplay.add(greeting);
		HorizontalPanel inputCup = new HorizontalPanel();
		Label cup = new Label("Cappuccino Unit(s)");
		inputCup.add(tbCup);
		inputCup.add(cup);
		vpDisplay.add(inputCup);
		vpDisplay.add(enterButton);
		this.canvasPanel.add(vpDisplay);

	}

	/**
	 * 
	 */
	protected void startQ2() {
		Label tellMe = new Label("Tell me, where are you from buddy?");
		HorizontalPanel hp = new HorizontalPanel();
		Label from = new Label("I'm from: ");
		hp.add(from);
		hp.add(lbCountry);
		vpDisplay.add(tellMe);
		vpDisplay.add(hp);
		vpDisplay.add(enterButtonQ2);
		canvasPanel.add(vpDisplay);

	}

	/**
	 * 
	 */
	protected void startQ3() {
		Label forReal = new Label("For real? Where?");
		HorizontalPanel hp = new HorizontalPanel();
		Label from = new Label("Straight out of: ");
		hp.add(from);
		hp.add(lbState);
		hp.add(lbCityName);
		vpDisplay.add(forReal);
		vpDisplay.add(hp);
		vpDisplay.add(enterButtonQ3);
		canvasPanel.add(vpDisplay);

	}

	/**
	 * 
	 */
	protected void startQ4() {
		Label sweet = new Label("Sweet! Cool so your Cappuccinno order of " + units + " will cost :R" + getTotalPrice()
				+ " since it costs R" + getZarPrice() + " for one. Your have acquired a Tourism Token: "
				+ getTourismToken()
				+ ". This will be used when redeeming your next order using a coupon discount. Can I have your card please?");
		Label firstNameLabel = new Label("First Name:");
		HorizontalPanel firstPanel = new HorizontalPanel();
		firstPanel.add(firstNameLabel);
		firstPanel.add(lbFirstName);

		Label lastNameLabel = new Label("Last Name:");
		HorizontalPanel lastPanel = new HorizontalPanel();
		lastPanel.add(lastNameLabel);
		lastPanel.add(lbLastName);

		Label cardNumberLabel = new Label("Card Number:");
		HorizontalPanel cardPanel = new HorizontalPanel();
		cardPanel.add(cardNumberLabel);
		cardPanel.add(lbCardNumber);

		Label bankLabel = new Label("Bank");
		HorizontalPanel bankPanel = new HorizontalPanel();
		bankPanel.add(bankLabel);
		bankPanel.add(lbBank);

		Label loyaltyLabel = new Label("Apply Loyalty (Yes/No)");
		HorizontalPanel loyaltyPanel = new HorizontalPanel();
		loyaltyPanel.add(loyaltyLabel);
		lbLoyalty.clear();
		lbLoyalty.addItem("Nothing Selected");
		lbLoyalty.addItem("Yes");
		lbLoyalty.addItem("No");
		lbLoyalty.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				if (lbLoyalty.getSelectedIndex() == 1) {
					checkUserLoyalty();
					Window.alert("Your loyalty balance is: " + selectedUser.getLoyaltyCredit() + " USD. R"
							+ selectedUser.getLoyaltyCredit() * 18.5 + " will be deducted from your total price of: R"
							+ getTotalPrice() + " Your final price is now: R"
							+ (getTotalPrice() - selectedUser.getLoyaltyCredit() * 18.5));
					if (selectedUser.getLoyaltyCredit() == 0) {
						lbLoyalty.setSelectedIndex(2);
					}
				}

			}
		});
		loyaltyPanel.add(lbLoyalty);

		vpDisplay.add(sweet);
		vpDisplay.add(firstPanel);
		vpDisplay.add(lastPanel);
		vpDisplay.add(cardPanel);
		vpDisplay.add(bankPanel);
		vpDisplay.add(loyaltyPanel);
		vpDisplay.add(submitButton);
		canvasPanel.add(vpDisplay);

	}

	/**
	 * 
	 */
	protected void checkUserLoyalty() {
		for (GetUser user : users) {
			if (user.getId().equals(StringUtils
					.getMd5(lbFirstName.getValue() + " " + lbLastName.getValue() + lbCardNumber.getValue()))) {
				selectedUser = user;
				break;

			}
		}

	}

	/**
	 * @return
	 */
	private String getTourismToken() {
		return selectedIndex.getTourismToken();
	}

	/**
	 * @return
	 */
	private String getZarPrice() {
		return selectedIndex.getPriceZar();
	}

	/**
	 * @return
	 */
	private double getTotalPrice() {
		return Double.valueOf(selectedIndex.getPriceZar()) * units;
	}

	/**
	 * @param index
	 */
	public void setIndex(ArrayList<GetCapIndex> index) {
		this.index = index;
	}

}
