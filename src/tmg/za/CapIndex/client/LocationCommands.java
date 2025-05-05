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

public class LocationCommands {
	private final static LocationServiceAsync locationService = GWT.create(LocationService.class);
	private final static PeopleServiceAsync peopleService = GWT.create(PeopleService.class);

	public LocationCommands() {
		// TODO Auto-generated constructor stub
	}

	public static Command getCountriesCommand(SimplePanel canvas) {
		Command countries = new Command() {
			public void execute() {
				locationService.getCountries(new AsyncCallback<ArrayList<GetCountry>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetCountry> result) {
						// TODO Auto-generated method stub
						CellTable<GetCountry> table = new CellTable<GetCountry>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetCountry> nameColumn = new TextColumn<GetCountry>() {
							@Override
							public String getValue(GetCountry object) {
								return object.getCountryName();
							}
						};
						table.addColumn(nameColumn, "Name");
						TextColumn<GetCountry> codeColumn = new TextColumn<GetCountry>() {
							@Override
							public String getValue(GetCountry object) {
								return object.getCountryCode();
							}
						};
						table.addColumn(codeColumn, "Code");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetCountry> selectionModel = new SingleSelectionModel<GetCountry>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetCountry selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getCountryName());
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

		return countries;
	}

	public static Command getStatesCommand(SimplePanel canvas) {
		Command states = new Command() {
			public void execute() {
				locationService.getStates(new AsyncCallback<ArrayList<GetState>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetState> result) {
						// TODO Auto-generated method stub
						CellTable<GetState> table = new CellTable<GetState>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetState> nameColumn = new TextColumn<GetState>() {
							@Override
							public String getValue(GetState object) {
								return object.getStateName();
							}
						};
						table.addColumn(nameColumn, "Name");
						TextColumn<GetState> codeColumn = new TextColumn<GetState>() {
							@Override
							public String getValue(GetState object) {
								return object.getStateCode();
							}
						};
						table.addColumn(codeColumn, "Code");
						TextColumn<GetState> countryNameCol = new TextColumn<GetState>() {
							@Override
							public String getValue(GetState object) {
								return object.getCountyName();
							}
						};
						table.addColumn(countryNameCol, "Country");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetState> selectionModel = new SingleSelectionModel<GetState>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetState selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getStateName());
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
		return states;
	}

}
