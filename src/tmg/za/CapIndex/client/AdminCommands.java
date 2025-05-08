package tmg.za.CapIndex.client;

import java.util.ArrayList;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

public class AdminCommands {
	private final static AdminServiceAsync adminService = GWT.create(AdminService.class);
	ArrayList<GetCapIndex> updates = new ArrayList<GetCapIndex>();

	public AdminCommands() {
		// TODO Auto-generated constructor stub

	}

	public Command getBanksCommand(SimplePanel canvas) {
		Command banks = new Command() {
			public void execute() {
				adminService.getBanks(new AsyncCallback<ArrayList<GetBank>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetBank> result) {
						// TODO Auto-generated method stub
						CellTable<GetBank> table = new CellTable<GetBank>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetBank> nameColumn = new TextColumn<GetBank>() {
							@Override
							public String getValue(GetBank object) {
								return object.getBankName();
							}
						};
						table.addColumn(nameColumn, "Bank Name");

						TextColumn<GetBank> bankHq = new TextColumn<GetBank>() {
							@Override
							public String getValue(GetBank object) {
								return String.valueOf(object.getBankHq());
							}
						};
						table.addColumn(bankHq, "Head Quarters");

						TextColumn<GetBank> state = new TextColumn<GetBank>() {
							@Override
							public String getValue(GetBank object) {
								return String.valueOf(object.getBankStateName());
							}
						};
						table.addColumn(state, "State");

						TextColumn<GetBank> abaRouting = new TextColumn<GetBank>() {
							@Override
							public String getValue(GetBank object) {
								return String.valueOf(object.getAbaRouting());
							}
						};
						table.addColumn(abaRouting, "ABA Routing");

						TextColumn<GetBank> bankSwiftCode = new TextColumn<GetBank>() {
							@Override
							public String getValue(GetBank object) {
								return String.valueOf(object.getBankSwiftCode());
							}
						};
						table.addColumn(bankSwiftCode, "Bank Swift Code");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetBank> selectionModel = new SingleSelectionModel<GetBank>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetBank selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getBankName());
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

		return banks;
	}

	public Command getRewardHistoryCommand(SimplePanel canvas) {
		Command banks = new Command() {
			public void execute() {
				adminService.getRewardHistory(new AsyncCallback<ArrayList<GetRewardHistory>>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(ArrayList<GetRewardHistory> result) {
						// TODO Auto-generated method stub
						CellTable<GetRewardHistory> table = new CellTable<GetRewardHistory>();
						table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

						// Add a text column to show the name.
						TextColumn<GetRewardHistory> description = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return object.getRewardDescription();
							}
						};
						table.addColumn(description, "Description");

						TextColumn<GetRewardHistory> transactionDate = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getRewardTransactionTime());
							}
						};
						table.addColumn(transactionDate, "Transaction Date");

						TextColumn<GetRewardHistory> rewardAmount = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getRewardAmount());
							}
						};
						table.addColumn(rewardAmount, "Reward Amount");

						TextColumn<GetRewardHistory> finalAmount = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getFinalAmount());
							}
						};
						table.addColumn(finalAmount, "Final Amount");

						TextColumn<GetRewardHistory> appliedColumn = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.isRewardApplied());
							}
						};
						table.addColumn(appliedColumn, "Applied/Redeemed");

						TextColumn<GetRewardHistory> tokenColumn = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getTokenIndex());
							}
						};
						table.addColumn(tokenColumn, "Token Index");

						TextColumn<GetRewardHistory> userColumn = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getRewardUserId());
							}
						};
						table.addColumn(userColumn, "User ID");
						TextColumn<GetRewardHistory> userCard = new TextColumn<GetRewardHistory>() {
							@Override
							public String getValue(GetRewardHistory object) {
								return String.valueOf(object.getUserCardNumber());
							}
						};
						table.addColumn(userCard, "Card Number");

						// Add a selection model to handle user selection.
						final SingleSelectionModel<GetRewardHistory> selectionModel = new SingleSelectionModel<GetRewardHistory>();
						table.setSelectionModel(selectionModel);
						selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
							public void onSelectionChange(SelectionChangeEvent event) {
								GetRewardHistory selected = selectionModel.getSelectedObject();
								if (selected != null) {
									Window.alert("You selected: " + selected.getRewardDescription());
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

		return banks;
	}

	public void getCapIndex(SimplePanel canvas, boolean edit) {

		adminService.getCapIndex(new AsyncCallback<ArrayList<GetCapIndex>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(ArrayList<GetCapIndex> result) {
				// TODO Auto-generated method stub
				CellTable<GetCapIndex> table = new CellTable<GetCapIndex>();
				table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

				// Add a text column to show the name.
				if (edit) {
					bind(table);
				} else {
					bindReadOnly(table);
				}
				table.setRowCount(result.size(), true);
				table.setRowData(0, result);
				canvas.setWidget(table);

			}
		});

	}

	public void setCapIndex(SimplePanel canvas) {

		adminService.setCapIndex(getUpdates(), new AsyncCallback<ArrayList<GetCapIndex>>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onSuccess(ArrayList<GetCapIndex> result) {
				// TODO Auto-generated method stub
				CellTable<GetCapIndex> table = new CellTable<GetCapIndex>();
				table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
				bindReadOnly(table);
				table.setRowCount(result.size(), true);
				table.setRowData(0, result);
				canvas.setWidget(table);
				updates.clear();

			}
		});

	}

	protected void bindReadOnly(CellTable<GetCapIndex> table) {

		// Add a selection model to handle user selection.
		SingleSelectionModel<GetCapIndex> selectionModel = new SingleSelectionModel<GetCapIndex>();
		table.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				GetCapIndex selected = selectionModel.getSelectedObject();

				if (selected != null) {
					// Window.alert("You selected: " + );
				}
			}
		});

		TextColumn<GetCapIndex> cityColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return object.getCityName();
			}
		};
		table.addColumn(cityColumn, "City Name");

		TextColumn<GetCapIndex> stateColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getStateName());
			}
		};
		table.addColumn(stateColumn, "State");

		TextColumn<GetCapIndex> usdPriceColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getPriceUsd());
			}
		};
		table.addColumn(usdPriceColumn, "USD/Cuppino Price");

		TextColumn<GetCapIndex> zarPriceColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getPriceZar());
			}
		};
		table.addColumn(zarPriceColumn, "ZAR (18.5x)");

		TextColumn<GetCapIndex> unitFirstPriceColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getUnitFirstCharge());
			}
		};
		table.addColumn(unitFirstPriceColumn, "Unit First Price");

		TextColumn<GetCapIndex> surchargePercentColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargePercentage());
			}
		};
		table.addColumn(surchargePercentColumn, "Surcharge Percentage");

		TextColumn<GetCapIndex> surchargeLimitColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargeLimit());
			}
		};
		table.addColumn(surchargeLimitColumn, "Surcharge Limitv/R");

		TextColumn<GetCapIndex> surchargePrice = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargePrice());
			}
		};
		table.addColumn(surchargePrice, "Surcharge Price");

		TextColumn<GetCapIndex> lastPriceColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getUnitLastPrice());
			}
		};
		table.addColumn(lastPriceColumn, "Unit Last Price");

		TextColumn<GetCapIndex> surchargeColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargeFinal());
			}
		};
		table.addColumn(surchargeColumn, "Surcharge");

		TextColumn<GetCapIndex> tokenColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getTourismToken());
			}
		};
		table.addColumn(tokenColumn, "Tourism Token");

		TextColumn<GetCapIndex> bankColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getBankName());
			}
		};
		table.addColumn(bankColumn, "Bank");
	}

	protected void bind(CellTable<GetCapIndex> table) {

		SingleSelectionModel<GetCapIndex> selectionModel = new SingleSelectionModel<GetCapIndex>();
		table.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				GetCapIndex selected = selectionModel.getSelectedObject();

				if (selected != null) {
					// Window.alert("You selected: " + );
				}
			}
		});

		TextInputCell nameCell = new TextInputCell();
		Column<GetCapIndex, String> cityColumn = new Column<GetCapIndex, String>(nameCell) {
			@Override
			public String getValue(GetCapIndex object) {
				return object.getCityName();
			}
		};
		table.addColumn(cityColumn, "City Name");

		// Add a field updater to be notified when the user enters a new name.
		cityColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getCityName() + " to " +
				// value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setCityName(value);
				// selectionModel.getSelectedObject().setCityName(value);
				updates.add(object);
				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextColumn<GetCapIndex> stateColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getStateName());
			}
		};
		table.addColumn(stateColumn, "State");

		TextInputCell usdPrice = new TextInputCell();
		Column<GetCapIndex, String> usdPriceColumn = new Column<GetCapIndex, String>(usdPrice) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getPriceUsd());
			}
		};
		table.addColumn(usdPriceColumn, "USD/Cuppino Price");
		usdPriceColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getPriceUsd() + " to " +
				// value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.

				object.setPriceUsd(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell zarPrice = new TextInputCell();
		Column<GetCapIndex, String> zarPriceColumn = new Column<GetCapIndex, String>(zarPrice) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getPriceZar());
			}
		};
		table.addColumn(zarPriceColumn, "ZAR (18.5x)");
		zarPriceColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getPriceZar() + " to " +
				// value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setPriceZar(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell firstPrice = new TextInputCell();
		Column<GetCapIndex, String> unitFirstPriceColumn = new Column<GetCapIndex, String>(firstPrice) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getUnitFirstCharge());
			}
		};
		table.addColumn(unitFirstPriceColumn, "Unit First Price");
		unitFirstPriceColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getUnitFirstCharge() + " to
				// " + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setUnitFirstCharge(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell percentage = new TextInputCell();
		Column<GetCapIndex, String> surchargePercentColumn = new Column<GetCapIndex, String>(percentage) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargePercentage());
			}
		};
		table.addColumn(surchargePercentColumn, "Surcharge Percentage");
		surchargePercentColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getSurchargePercentage() + "
				// to " + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setSurchargePercentage(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});
		TextInputCell limit = new TextInputCell();
		Column<GetCapIndex, String> surchargeLimitColumn = new Column<GetCapIndex, String>(limit) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargeLimit());
			}
		};
		table.addColumn(surchargeLimitColumn, "Surcharge Limitv/R");
		surchargeLimitColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getSurchargeLimit() + " to "
				// + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setSurchargeLimit(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell price = new TextInputCell();
		Column<GetCapIndex, String> surchargePrice = new Column<GetCapIndex, String>(price) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargePrice());
			}
		};
		table.addColumn(surchargePrice, "Surcharge Price");
		surchargePrice.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getSurchargePrice() + " to "
				// + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setSurchargePrice(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell last = new TextInputCell();
		Column<GetCapIndex, String> lastPriceColumn = new Column<GetCapIndex, String>(last) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getUnitLastPrice());
			}
		};
		table.addColumn(lastPriceColumn, "Unit Last Price");
		lastPriceColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getUnitLastPrice() + " to "
				// + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setUnitLastPrice(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell surcharge = new TextInputCell();
		Column<GetCapIndex, String> surchargeColumn = new Column<GetCapIndex, String>(surcharge) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getSurchargeFinal());
			}
		};
		table.addColumn(surchargeColumn, "Surcharge");
		surchargeColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getSurchargeFinal() + " to "
				// + value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setSurchargeFinal(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextInputCell token = new TextInputCell();
		Column<GetCapIndex, String> tokenColumn = new Column<GetCapIndex, String>(token) {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getTourismToken());
			}
		};
		table.addColumn(tokenColumn, "Tourism Token");
		tokenColumn.setFieldUpdater(new FieldUpdater<GetCapIndex, String>() {

			@Override
			public void update(int index, GetCapIndex object, String value) {
				// Inform the user of the change.
				// Window.alert("You changed the name of " + object.getTourismToken() + " to " +
				// value);

				// Push the changes into the Contact. At this point, you could send an //
				// asynchronous request to the server to update the database.
				object.setTourismToken(value);
				// selectionModel.getSelectedObject().setTourismToken(value);
				updates.add(object);

				// Redraw the table with the new data.
				table.redraw();
			}
		});

		TextColumn<GetCapIndex> bankColumn = new TextColumn<GetCapIndex>() {
			@Override
			public String getValue(GetCapIndex object) {
				return String.valueOf(object.getBankName());
			}
		};
		table.addColumn(bankColumn, "Bank");
		// Add a selection model to handle user selection.

	}

	public ArrayList<GetCapIndex> getUpdates() {

		return updates;
	}

}
