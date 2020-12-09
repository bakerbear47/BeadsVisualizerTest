package sample;

import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;

public class Controller {

    private Stage primaryStage;
    SoundPlayer model;

    public Controller(SoundPlayer model, Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.model = model;
    }

    public  void setView(View view) {

        view.sampleLoadbtn.setOnAction( e ->{
            Window primaryStage = null;
            //File selectedFile = model.loadSample().showOpenDialog(primaryStage);
            //model.setSample(selectedFile);
        });

    }

    public void loadSample() {
        File selectedFile = model.loadSample().showOpenDialog(primaryStage);
        model.setSample(selectedFile);
        model.playSample();
    }
}
