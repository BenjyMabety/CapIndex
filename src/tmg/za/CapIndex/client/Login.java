package tmg.za.CapIndex.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import tmg.za.CapIndex.client.data.GetAdminUser;
import tmg.za.CapIndex.shared.FieldVerifier;

public class Login extends DialogBox {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	interface LoginUiBinder extends UiBinder<Widget, Login> {
	}

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	@UiField
	Button sendButton;
	@UiField
	Button closeButton;
	@UiField
	TextBox nameField;
	@UiField
	TextBox passField;
	Anchor aLogin;
	Anchor aSignOut;
	GetAdminUser user;
	Label userName = new Label();

	@UiField
	Label errorLabel = new Label();

	public Login() {
		setWidget(uiBinder.createAndBindUi(this));
		aLogin = new Anchor("Login");
		aSignOut = new Anchor("Sign Out");
		sendButton.setText("Send");

		closeButton.setText("Close");

		sendButton.addStyleName("sendButton");
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();
		passField.getElement().setAttribute("type", "password");
		closeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				hide();
				passField.setValue("");

			}
		});

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}
				greetingService.authenticateUser(textToServer, passField.getValue(), new AsyncCallback<GetAdminUser>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Something went wrong");

					}

					@Override
					public void onSuccess(GetAdminUser result) {
						if (result != null) {
							user = result;
							userName.setText(result.getUsername());
							hide();
							nameField.setText("");
							passField.setText("");
						} else {
							Window.alert("Could not Authenticate Username");
						}

					}
				});
			}
		}

		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);

	}

	/**
	 * @return
	 */
	public Anchor getALogin() {
		return aLogin;
	}

	/**
	 * @param pbLogin
	 */
	public void setALogin(Anchor aLogin) {
		this.aLogin = aLogin;
	}

	/**
	 * @return
	 */
	public GetAdminUser getUser() {
		return user;
	}

	/**
	 * @param user
	 */
	public void setUser(GetAdminUser user) {
		this.user = user;
	}

	public Anchor getaSignOut() {
		return aSignOut;
	}

	/**
	 * @param aSignOut
	 */
	public void setaSignOut(Anchor aSignOut) {
		this.aSignOut = aSignOut;
	}

	/**
	 * @return
	 */
	public Label getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(Label userName) {
		this.userName = userName;
	}

}
