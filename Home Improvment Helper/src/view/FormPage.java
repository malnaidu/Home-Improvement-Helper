package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by malinin on 5/24/17.
 */
public class FormPage extends Application{
    @Override
    public void start(Stage primaryStage) {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene sceneFormPage = new Scene(grid, 550, 700);

        grid.setGridLinesVisible(false);

        sceneFormPage.getStylesheets().
                add(FormPage.class.getResource("FormPage.css").toExternalForm());
        primaryStage.setTitle("Home Improvement Helper");
        primaryStage.setScene(sceneFormPage);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}