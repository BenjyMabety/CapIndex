/**
 * 
 */
package tmg.za.CapIndex.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import tmg.za.CapIndex.shared.Resources;

/**
 * 
 */
public class MainLayout extends Composite {

	private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);
	Resources resources = GWT.create(Resources.class);

	interface MainLayoutUiBinder extends UiBinder<Widget, MainLayout> {
	}

	@UiField
	VerticalPanel mainPanel;
	@UiField
	SimplePanel canvas;
	Login login;
	@UiField
	VerticalPanel vEast;
	MenuBar menu = new MenuBar(true);
	@UiField
	Label headerLabel;
	Image home;

	public MainLayout() {
		initWidget(uiBinder.createAndBindUi(this));
		headerLabel.getElement().setAttribute("style",
				"font-weight: bold;font-size:30px;text-align:center; color:grey;");

		home = new Image(resources.home());
		login = new Login();
		mainPanel.add(login.getALogin());
		login.getaSignOut().setVisible(false);
		mainPanel.add(login.getaSignOut());
		menu.setVisible(false);
		home.setVisible(false);
		login.getALogin().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				login.center();
				login.setGlassEnabled(true);

			}
		});
		login.addCloseHandler(new CloseHandler<PopupPanel>() {

			@Override
			public void onClose(CloseEvent<PopupPanel> event) {
				// TODO Auto-generated method stub
				if (login.getUser() != null) {
					login.getALogin().setVisible(false);
					login.getaSignOut().setVisible(true);
					mainPanel.add(login.getUserName());
					menu.setVisible(true);
					home.setVisible(true);
					mainPanel.add(home);
				}
			}
		});
		login.getaSignOut().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				mainPanel.remove(login.getUserName());
				login.getaSignOut().setVisible(false);
				login.getALogin().setVisible(true);
				canvas.clear();
				menu.setVisible(false);
				home.setVisible(false);
				AdminCommands.getCapIndex(canvas);

			}
		});

		home.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				AdminCommands.getCapIndex(canvas);
			}
		});

		// Make some sub-menus that we will cascade from the top menu.
		MenuBar locationMenu = new MenuBar(false);
		locationMenu.addItem("Country", LocationCommands.getCountriesCommand(canvas));
		locationMenu.addItem("State", LocationCommands.getStatesCommand(canvas));

		MenuBar peopleMenu = new MenuBar(false);
		peopleMenu.addItem("Users", PeopleCommands.getUsersCommand(canvas));
		peopleMenu.addItem("Administrators", PeopleCommands.getAdminUsersCommand(canvas));

		MenuBar adminMenu = new MenuBar(false);
		adminMenu.addItem("Banks", AdminCommands.getBanksCommand(canvas));
		adminMenu.addItem("Reward History", AdminCommands.getRewardHistoryCommand(canvas));

		// Make a new menu bar, adding a few cascading menus to it.
		menu.addItem("Location", locationMenu);
		menu.addItem("People", peopleMenu);
		menu.addItem("Administration", adminMenu);

		vEast.add(menu);

		AdminCommands.getCapIndex(canvas);

	}

}
