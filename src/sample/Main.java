package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        SoundPlayer model = new SoundPlayer();
        Controller controller = new Controller(model, primaryStage);
        controller.loadSample();
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        View view = new View(model, controller);
        primaryStage.setTitle("Visualizer Test");

        primaryStage.setScene(new Scene(view.asParent(), 900, 500));
        controller.setView(view);
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
