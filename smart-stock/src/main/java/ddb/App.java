package ddb;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class App extends Application
{
    public void start(Stage primaryStage)
    {
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        StackPane root = new StackPane();
        Scene scene = new Scene(root, primaryScreenBounds.getWidth()/2, primaryScreenBounds.getHeight()/2);

        Label label = new Label("Hello, JavaFX!");
        root.getChildren().add(label);

        primaryStage.setTitle("JavaFX Example");
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main( String[] args )
    {
        launch(args);
    }
}

