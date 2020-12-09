package sample;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View {
    SoundPlayer model;
    Controller control;
    public View(SoundPlayer model, Controller control){
        this.model = model;
        this.control = control;
        createAndConfigure();
    }

    private HBox Header;
    private BorderPane StartView;
    private GridPane Grid;


    // FileChooser
    Label sampleLbl = new Label("Sample: ");
    Button sampleLoadbtn = new Button("Load sample");
    TextArea samplePath = new TextArea();

    private void createAndConfigure(){

        Header = new HBox();
        Grid = new GridPane();
        StartView = new BorderPane();
        StartView.setTop(Header);
        StartView.setCenter(Grid);

        Header.getChildren().addAll(sampleLbl, sampleLoadbtn, samplePath);

        samplePath.setMaxHeight(2);
        samplePath.setMinWidth(90);

    }

    public Parent asParent() {
        return StartView;
    }

}
