package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class PeopleCommands {
	private final static PeopleServiceAsync peopleService = GWT.create(PeopleService.class);

	public PeopleCommands() {
		// TODO Auto-generated constructor stub
	}

	public static Command getAdminUsersCommand(SimplePanel canvas) {
		Command admin = new Command() {
			public void execute() {
				peopleService.getAdminUsers(new AsyncCallback<ArrayList<GetAdminUser>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetAdminUser> result) {
						// TODO Auto-generated method stub
						CellTable<GetAdminUser> table = new CellTable<GetAdminUser>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetAdminUser> nameColumn = new TextColumn<GetAdminUser>() {
							@Override
							public String getValue(GetAdminUser object) {
								return object.getUsername();
							}
						};
						table.addColumn(nameColumn, "User Name");

						TextColumn<GetAdminUser> lastLogin = new TextColumn<GetAdminUser>() {
							@Override
							public String getValue(GetAdminUser object) {
								return String.valueOf(object.getLast_login());
							}
						};
						table.addColumn(lastLogin, "Last Login");

						TextColumn<GetAdminUser> createdDate = new TextColumn<GetAdminUser>() {
							@Override
							public String getValue(GetAdminUser object) {
								return String.valueOf(object.getCreated_date());
							}
						};
						table.addColumn(createdDate, "Created Date");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetAdminUser> selectionModel = new SingleSelectionModel<GetAdminUser>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetAdminUser selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getUsername());
								}
							}
						});
						table.setRowCount(result.size(), true);
						table.setRowData(0, result);
						canvas.setWidget(table);

					}
				});
			}
		};

		return admin;
	}

	public static Command getUsersCommand(SimplePanel canvas) {
		Command users = new Command() {
			public void execute() {
				peopleService.getUsers(new AsyncCallback<ArrayList<GetUser>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetUser> result) {
						// TODO Auto-generated method stub
						CellTable<GetUser> table = new CellTable<GetUser>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetUser> nameColumn = new TextColumn<GetUser>() {
							@Override
							public String getValue(GetUser object) {
								return object.getFirstName();
							}
						};
						table.addColumn(nameColumn, "First Name");

						TextColumn<GetUser> lastNameColumn = new TextColumn<GetUser>() {
							@Override
							public String getValue(GetUser object) {
								return object.getLastName();
							}
						};
						table.addColumn(lastNameColumn, "Last Name");

						TextColumn<GetUser> CardNumberColumn = new TextColumn<GetUser>() {
							@Override
							public String getValue(GetUser object) {
								return object.getCardNumber();
							}
						};
						table.addColumn(CardNumberColumn, "Card Number");

						TextColumn<GetUser> userBankName = new TextColumn<GetUser>() {
							@Override
							public String getValue(GetUser object) {
								return object.getBankName();
							}
						};
						table.addColumn(userBankName, "Bank");

						TextColumn<GetUser> loyaltyColumn = new TextColumn<GetUser>() {
							@Override
							public String getValue(GetUser object) {
								return String.valueOf(object.getLoyaltyCredit());
							}
						};
						table.addColumn(loyaltyColumn, "Loyalty Balance");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetUser> selectionModel = new SingleSelectionModel<GetUser>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetUser selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getFirstName());
								}
							}
						});
						table.setRowCount(result.size(), true);
						table.setRowData(0, result);
						canvas.setWidget(table);

					}
				});
			}
		};
		return users;
	}

}
