package view; /**
				* Created by malinin on 5/24/17.
				*/

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

public class UI_Main extends Application
{

	Stage window;
	Scene omparePageScene, formPageScene, loginScene, homePageScene, projectPageScene;

	public static void main(String[] args)
	{
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;

		loginPage(primaryStage);
		homePage(primaryStage);
		formPage(primaryStage);

		window.setScene(loginScene);
		window.setTitle("Home Improvement Helper");
		primaryStage.setResizable(false);
		window.show();
	}

	public void loginPage(Stage window) throws Exception
	{
		List<UserProfile> userlist = new ArrayList<UserProfile>();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		loginScene = new Scene(grid, 550, 700);

		Label userName = new Label("User Name:");
		TextField userTextField = new TextField();
		Label pw = new Label("Password: ");
		PasswordField pwBox = new PasswordField();

		grid.add(userName, 0, 1);
		grid.add(userTextField, 1, 1);
		grid.add(pw, 0, 2);
		grid.add(pwBox, 1, 2);

		grid.setGridLinesVisible(false);

		Button btn = new Button("Sign in");
		Button newAccount = new Button("Register");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		hbBtn.getChildren().add(newAccount);
		grid.add(hbBtn, 1, 4);

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		btn.setOnAction(event -> {

			if (userTextField.getText().equals("") || pwBox.getText().equals(""))
			{
				// error "One or more fields are empty.
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error!");
				alert.setHeaderText("Field(s) Empty!");
				alert.setContentText("Please fill out both fields.");

				alert.showAndWait();
			} else
			{
				boolean found = false;

				for (int i = 0; i < userlist.size(); i++)
				{
					if (userTextField.getText().toString().equals(userlist.get(i).getUsername())
							&& pwBox.getText().toString().equals(userlist.get(i).getPassword()))
					{
						window.setScene(homePageScene);
						found = true;
						break;
					}
				}

				if (!found)
				{
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error!");
					alert.setHeaderText("Wrong credentials!");
					alert.setContentText("The username or password is invalid.");

					alert.showAndWait();
				}
			}
		});

		newAccount.setOnAction(event -> {
			// Create the custom dialog.
			Dialog<Pair<String, String>> dialog = new Dialog<>();
			dialog.setTitle("Register");
			dialog.setHeaderText("Create a new user.");

			// Set the icon (must be included in the project).

			// Set the button types.
			ButtonType loginButtonType = new ButtonType("Login", ButtonData.OK_DONE);
			dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

			// Create the username and password labels and fields.
			GridPane newActgrid = new GridPane();
			newActgrid.setHgap(10);
			newActgrid.setVgap(10);
			newActgrid.setPadding(new Insets(20, 150, 10, 10));

			TextField username = new TextField();
			username.setPromptText("Username");
			PasswordField password = new PasswordField();
			password.setPromptText("Password");

			newActgrid.add(new Label("Username:"), 0, 0);
			newActgrid.add(username, 1, 0);
			newActgrid.add(new Label("Password:"), 0, 1);
			newActgrid.add(password, 1, 1);

			// Enable/Disable login button depending on whether a username was
			// entered.
			Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
			loginButton.setDisable(true);

			// Do some validation (using the Java 8 lambda syntax).
			username.textProperty().addListener((observable, oldValue, newValue) -> {
				loginButton.setDisable(newValue.trim().isEmpty());
			});

			dialog.getDialogPane().setContent(newActgrid);

			// Request focus on the username field by default.
			Platform.runLater(() -> username.requestFocus());

			dialog.setResultConverter(dialogButton -> {
				if (dialogButton == loginButtonType)
				{
					if (!password.getText().equals(""))
					{
						UserProfile newProfile = new UserProfile(username.getText(), password.getText());
						userlist.add(newProfile);
						newProfile.export();
						
					} else
					{
						// error "One or more fields are empty.
						Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Error!");
						alert.setHeaderText("Password Empty!");
						alert.setContentText("Please fill out a password.");

						alert.showAndWait();
					}
				}
				return null;
			});

			dialog.showAndWait();
		});
		loginScene.getStylesheets().add(UI_Main.class.getResource("Login.css").toExternalForm());
	}

	// Homepage Window
	public void homePage(Stage window) throws Exception
	{
		BorderPane root = new BorderPane();

		homePageScene = new Scene(root, 550, 700);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(window.widthProperty());
		root.setTop(menuBar);

		Menu home = new Menu("Home");

		Menu options = new Menu("Options");
		CheckMenuItem about = new CheckMenuItem("About Home Improvement Helper");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem printMenuItem = new MenuItem("Print");
		MenuItem exitMenuItem = new MenuItem("Exit");

		Menu compare = new Menu("Compare Projects");

		options.getItems().addAll(about, saveMenuItem, printMenuItem, new SeparatorMenuItem(), exitMenuItem);

		exitMenuItem.setOnAction(actionEvent -> Platform.exit());

		menuBar.getMenus().addAll(home, options, compare);

		window.setTitle("Adding Menus");
		window.setScene(homePageScene);
		window.show();

		homePageScene.getStylesheets().add(HomePage.class.getResource("HomePage.css").toExternalForm());
		window.setTitle("Home Improvement Helper");
		window.setScene(homePageScene);
		window.show();

		Button projectButton = new Button("Create A New Project");
		projectButton.setMaxWidth(180.0);
		projectButton.setMaxHeight(100.0);
		root.setCenter(projectButton);

		projectButton.setOnAction(e -> window.setScene(formPageScene));
	}

	public void formPage(Stage window) throws Exception
	{

		BorderPane root = new BorderPane();
		formPageScene = new Scene(root, 550, 700);

		GridPane gridPane = new GridPane();
		root.setCenter(gridPane);

		GridPane topGrid = new GridPane();
		root.setTop(topGrid);

		gridPane.setAlignment(Pos.CENTER);
		gridPane.setHgap(10);
		gridPane.setVgap(10);
		gridPane.setPadding(new Insets(0, 5, 5, 5));

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidthProperty().bind(window.widthProperty());

		Menu home = new Menu("Home");

		Menu options = new Menu("Options");
		CheckMenuItem about = new CheckMenuItem("About Home Improvement Helper");
		MenuItem saveMenuItem = new MenuItem("Save");
		MenuItem printMenuItem = new MenuItem("Print");
		MenuItem exitMenuItem = new MenuItem("Exit");

		Menu compare = new Menu("Compare Projects");

		options.getItems().addAll(about, saveMenuItem, printMenuItem, new SeparatorMenuItem(), exitMenuItem);

		exitMenuItem.setOnAction(actionEvent -> Platform.exit());

		menuBar.getMenus().addAll(home, options, compare);

		root.setTop(menuBar);

		window.setTitle("Adding Menus");
		window.setScene(formPageScene);
		window.show();

		formPageScene.getStylesheets().add(HomePage.class.getResource("HomePage.css").toExternalForm());
		window.setTitle("Home Improvement Helper");
		window.setScene(formPageScene);
		window.show();

		Label imageUpload = new Label("Select a Project Image:");
		TextField projectImage = new TextField();
		Button btnLoad = new Button("Upload");

		gridPane.add(imageUpload, 0, 1);
		gridPane.add(projectImage, 1, 1);
		gridPane.add(btnLoad, 2, 1);

		// upload photo
		FileChooser fileChooser = new FileChooser();

		// File file = new File();
		//
		// try {
		// BufferedImage bufferedImage = ImageIO.read(file);
		// Image image = SwingFXUtils.toFXImage(bufferedImage, null);
		// myImageView.setImage(image);
		// } catch (IOException ex) {
		// Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null,
		// ex);
		// }

		Label projectName = new Label("Project Name:");
		TextField userTextField = new TextField();
		Label projectDescription = new Label("Project Description: ");
		TextField userTextField2 = new TextField();
		Label measure1 = new Label("First Measurement:");
		TextField userTextField3 = new TextField();
		Label measure2 = new Label("Second Measurement:");
		TextField userTextField4 = new TextField();

		// add more measurements here

		Label priceItem = new Label("Price of Item 1:");
		TextField userTextField5 = new TextField();
		Label priceItem2 = new Label("Price of Item 2:");
		TextField userTextField6 = new TextField();

		// add more items prices

		Label totalCost = new Label("Total Cost of Project:");
		TextField totalCostField = new TextField();

		gridPane.add(projectName, 0, 2);
		gridPane.add(userTextField, 1, 2);
		gridPane.add(projectDescription, 0, 3);
		gridPane.add(userTextField2, 1, 3);

		gridPane.add(measure1, 0, 4);
		gridPane.add(userTextField3, 1, 4);
		gridPane.add(measure2, 0, 5);
		gridPane.add(userTextField4, 1, 5);

		gridPane.add(priceItem, 0, 6);
		gridPane.add(userTextField5, 1, 6);
		gridPane.add(priceItem2, 0, 7);
		gridPane.add(userTextField6, 1, 7);

		gridPane.add(totalCost, 0, 8);
		gridPane.add(totalCostField, 1, 8);

		Button btn = new Button("Submit");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		gridPane.add(hbBtn, 1, 10);

		btn.setOnAction(e -> window.setScene(homePageScene));
	}
}