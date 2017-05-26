package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class HomePage extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        Scene sceneHomePage = new Scene(root, 550, 700);

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        root.setTop(menuBar);

        Menu home = new Menu("Home");

        Menu options = new Menu("Options");
        CheckMenuItem about = new CheckMenuItem("About Home Improvement Helper");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem printMenuItem = new MenuItem("Print");
        MenuItem exitMenuItem = new MenuItem("Exit");

        Menu compare = new Menu("Compare Projects");

        options.getItems().addAll(about, saveMenuItem, printMenuItem,
                new SeparatorMenuItem(), exitMenuItem);


        exitMenuItem.setOnAction(actionEvent -> Platform.exit());

        menuBar.getMenus().addAll(home, options, compare);

        primaryStage.setTitle("Adding Menus");
        primaryStage.setScene(sceneHomePage);
        primaryStage.show();


        sceneHomePage.getStylesheets().
                add(HomePage.class.getResource("HomePage.css").toExternalForm());
        primaryStage.setTitle("Home Improvement Helper");
        primaryStage.setScene(sceneHomePage);
        primaryStage.show();

        Button button1 = new Button("Create A New Project");
        button1.setMaxWidth(180.0);
        button1.setMaxHeight(100.0);
        root.setCenter(button1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
