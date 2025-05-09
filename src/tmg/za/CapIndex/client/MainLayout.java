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

import tmg.za.CapIndex.client.Commands.AdminCommands;
import tmg.za.CapIndex.client.Commands.LocationCommands;
import tmg.za.CapIndex.client.Commands.PeopleCommands;
import tmg.za.CapIndex.shared.MyFoo.MyStyle;
import tmg.za.CapIndex.shared.Resources.Resources;

/**
 * 
 */
public class MainLayout extends Composite {

	private static MainLayoutUiBinder uiBinder = GWT.create(MainLayoutUiBinder.class);
	Resources resources = GWT.create(Resources.class);
	AdminCommands adminCommands = new AdminCommands();

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
	@UiField
	MyStyle style;
	Image home;
	Image edit;
	Image save;

	/**
	 * 
	 */
	public MainLayout() {
		initWidget(uiBinder.createAndBindUi(this));
		setEnabled(true);
		headerLabel.getElement().setAttribute("style",
				"font-weight: bold;font-size:30px;text-align:center; color:grey;");

		home = new Image(resources.home());
		edit = new Image(resources.edit());
		save = new Image(resources.save());

		login = new Login();
		mainPanel.add(login.getALogin());
		login.getaSignOut().setVisible(false);
		mainPanel.add(login.getaSignOut());

		menu.setVisible(false);
		home.setVisible(false);
		edit.setVisible(false);
		save.setVisible(false);

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
				if (login.getUser() != null) {
					setEnabled(false);
					login.getALogin().setVisible(false);
					login.getaSignOut().setVisible(true);
					mainPanel.add(login.getUserName());
					menu.setVisible(true);
					home.setVisible(true);
					edit.setVisible(true);
					save.setVisible(true);
					mainPanel.add(home);
					mainPanel.add(edit);
					mainPanel.add(save);
				}
			}
		});
		login.getaSignOut().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				setEnabled(true);
				mainPanel.remove(login.getUserName());
				login.getaSignOut().setVisible(false);
				login.getALogin().setVisible(true);
				canvas.clear();
				menu.setVisible(false);
				home.setVisible(false);
				edit.setVisible(false);
				save.setVisible(false);
				adminCommands.getCapIndex(canvas, false);

			}
		});

		home.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				adminCommands.getCapIndex(canvas, false);
			}
		});

		home.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				adminCommands.getCapIndex(canvas, false);
			}
		});

		edit.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				adminCommands.getCapIndex(canvas, true);
			}
		});
		save.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {

				adminCommands.setCapIndex(canvas);
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
		adminMenu.addItem("Banks", adminCommands.getBanksCommand(canvas));
		adminMenu.addItem("Reward History", adminCommands.getRewardHistoryCommand(canvas));

		// Make a new menu bar, adding a few cascading menus to it.
		menu.addItem("Location", locationMenu);
		menu.addItem("People", peopleMenu);
		menu.addItem("Administration", adminMenu);

		vEast.add(menu);

		adminCommands.getCapIndex(canvas, false);

	}

	/**
	 * @param enabled
	 */
	void setEnabled(boolean enabled) {
		getElement().addClassName(enabled ? style.enabledBall() : style.enabledSpace());
		getElement().removeClassName(enabled ? style.enabledSpace() : style.enabledBall());

	}

}
