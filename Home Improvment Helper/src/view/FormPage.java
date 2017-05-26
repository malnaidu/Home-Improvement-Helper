package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javafx.scene.control.Button;

/**
 * Created by malinin on 5/24/17.
 */
public class FormPage extends Application{
    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        Scene sceneFormPage = new Scene(root, 550, 700);

        GridPane gridPane = new GridPane();
        root.setCenter(gridPane);

        GridPane topGrid = new GridPane();
        root.setTop(topGrid);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(0,5,5,5));

        MenuBar menuBar = new MenuBar();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

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

        root.setTop(menuBar);

        primaryStage.setTitle("Adding Menus");
        primaryStage.setScene(sceneFormPage);
        primaryStage.show();


        sceneFormPage.getStylesheets().
                add(HomePage.class.getResource("HomePage.css").toExternalForm());
        primaryStage.setTitle("Home Improvement Helper");
        primaryStage.setScene(sceneFormPage);
        primaryStage.show();

        Button btnLoad = new Button("Upload");

        gridPane.add(btnLoad, 0, 1);

        //upload photo
        FileChooser fileChooser = new FileChooser();

        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            myImageView.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXPixel.class.getName()).log(Level.SEVERE, null, ex);
        }

        Label projectName = new Label("Project Name:");
        TextField userTextField = new TextField();
        Label projectDescription = new Label("Project Description: ");
        TextField userTextField2 = new TextField();
        Label measure1 = new Label("First Measurement:");
        TextField userTextField3 = new TextField();
        Label measure2 = new Label("Second Measurement:");
        TextField userTextField4 = new TextField();

        //add more measurements here

        Label priceItem = new Label("Price of Item 1:");
        TextField userTextField5 = new TextField();
        Label priceItem2 = new Label("Price of Item 2:");
        TextField userTextField6 = new TextField();

        //add more items prices

        Label totalCost = new Label("Total Cost of Project:");
        TextField totalCostField = new TextField();

        gridPane.add(projectName,0,2);
        gridPane.add(userTextField, 1,2);
        gridPane.add(projectDescription,0,3);
        gridPane.add(userTextField2,1,3);

        gridPane.add(measure1,0,4);
        gridPane.add(userTextField3, 1,4);
        gridPane.add(measure2,0,5);
        gridPane.add(userTextField4,1,5);

        gridPane.add(priceItem,0,6);
        gridPane.add(userTextField5, 1,6);
        gridPane.add(priceItem2,0,7);
        gridPane.add(userTextField6,1,7);

        gridPane.add(totalCost,0,8);
        gridPane.add(totalCostField,1,8);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
