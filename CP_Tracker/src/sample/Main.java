package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.awt.*;

public class Main extends Application {
    private Label titleLabel,dateLabel,markslabel;
    private TextField marksTextField;
    private Button saveData;
    private HBox titleHbox,datePickerHbox,marksHbox,buttonHbox;
    private BorderPane root;
    private DatePicker datePicker;
    private VBox centerVbox;

    @Override
    public void start(Stage primaryStage) throws Exception{

        titleLabel = new Label("My CP Tracker");
        titleLabel.setStyle("-fx-font:24px Arial");

        dateLabel = new Label("Date");
        dateLabel.setFont(new Font(18));
        markslabel = new Label("Marks");
        markslabel.setFont(new Font(16));
        datePicker = new DatePicker();
        datePicker.setMaxWidth(150);
        marksTextField = new TextField();
        marksTextField.setMaxWidth(200);
        saveData = new Button("Save Data");
        saveData.setFont(new Font(16));

        ShowAlert show = new ShowAlert();
        saveData.setOnAction(show);
        titleHbox = new HBox(titleLabel);
        titleHbox.setAlignment(Pos.CENTER);
        titleHbox.setPadding(new Insets(42,0,42,0));
        datePickerHbox = new HBox(60,dateLabel,datePicker);
        datePickerHbox.setAlignment(Pos.CENTER);

        marksHbox = new HBox(60,markslabel,marksTextField);
        marksHbox.setAlignment(Pos.CENTER);
        buttonHbox = new HBox(saveData);
        buttonHbox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonHbox.setPadding(new Insets(0,28,0,0));


        buttonHbox.setPrefWidth(250);
        centerVbox = new VBox(30,datePickerHbox,marksHbox,buttonHbox);
        centerVbox.setMaxWidth(300);
        root = new BorderPane();
        root.setPrefHeight(300);
        root.setPrefWidth(250);
        root.setTop(titleHbox);
        root.setCenter(centerVbox);

        primaryStage.setTitle("181380044 CP Calculator");
        primaryStage.setScene(new Scene(root , 500 , 350));
        primaryStage.show();

    }

    private class ShowAlert implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("CP Data Saved");
            alert.setHeaderText("Your CP Data is saved successfully");
            alert.setContentText("CP marks on " + datePicker.getValue().toString() + " \n"+
                    "Marks: " +
                    marksTextField.getText().toString());

            File file = new File("CP.txt");
            Boolean exist = file.exists();

            if(exist){
                try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String str = "\n\n-- CP marks on " + datePicker.getValue().toString()  +
                            "\n" + "Marks: " +
                            marksTextField.getText().toString();
                    bw.write(str);

                    bw.close();
                    fw.close();
                    alert.show();

                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else {
                try {
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("\n-- CP marks on " + datePicker.getValue().toString() + " --\n" + "Marks: " +
                            marksTextField.getText().toString());
                    bw.close();
                }


                catch (IOException e) {
                    e.printStackTrace();
                }
                alert.show();
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
