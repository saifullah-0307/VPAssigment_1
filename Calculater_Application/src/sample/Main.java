package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.event.ActionEvent;


public class Main extends Application {
    private TextField outputtf;
    private Button clearbtn,squarebtn,squareRootbtn,plusbtn,multiplybtn,divisionbtn,minusbtn,equalBtn,
            dotbtn,zerobtn,onebtn,twobtn,threebtn,fourbtn,fivebtn,sixbtn,sevenbtn,eightbtn,ninebtn,
            plus_minus_divisionbtn;
    private HBox textFieldHbox,cHbox,sevenHbox,fourHbox,oneHbox,bottomHbox;
    private VBox root;

    private double data = 0.0;
    private int operation = -1;


    @Override
    public void start(Stage primaryStage) throws Exception{

        outputtf = new TextField();
        outputtf.setPrefWidth(490);
        outputtf.setPrefHeight(80);
        outputtf.setFont(new Font(42));
        outputtf.setAlignment(Pos.CENTER);

        GetButtonInput input = new GetButtonInput();

        clearbtn = createButtons("C");
        clearbtn.setOnAction(input);

        squarebtn = createButtons("x^2");
        mathExpression(squarebtn,"x^2");


        squareRootbtn = createButtons("Sqrt");
        mathExpression(squareRootbtn,"sqrt");

        plusbtn = createButtons("+");
        plusbtn.setOnAction(input);

        multiplybtn = createButtons("x");
        multiplybtn.setOnAction(input);

        divisionbtn = createButtons("/");
        divisionbtn.setOnAction(input);

        minusbtn = createButtons("-");
        minusbtn.setOnAction(input);

        equalBtn = createButtons("=");
        equalBtn.setOnAction(input);

        dotbtn = createButtons(".");
        dotbtn.setOnAction(input);

        zerobtn = createButtons("0");
        zerobtn.setOnAction(input);

        onebtn = createButtons("1");
        onebtn.setOnAction(input);

        twobtn = createButtons("2");
        twobtn.setOnAction(input);

        threebtn = createButtons("3");
        threebtn.setOnAction(input);

        fourbtn = createButtons("4");
        fourbtn.setOnAction(input);

        fivebtn = createButtons("5");
        fivebtn.setOnAction(input);

        sixbtn = createButtons("6");
        sixbtn.setOnAction(input);

        sevenbtn = createButtons("7");
        sevenbtn.setOnAction(input);

        eightbtn = createButtons("8");
        eightbtn.setOnAction(input);

        ninebtn = createButtons("9");
        ninebtn.setOnAction(input);

        plus_minus_divisionbtn = createButtons("+/-");

        textFieldHbox = new HBox(outputtf);

        cHbox = new HBox(clearbtn,squarebtn,squareRootbtn,divisionbtn);

        sevenHbox = new HBox(sevenbtn,eightbtn,ninebtn,multiplybtn);

        fourHbox = new HBox(fourbtn,fivebtn,sixbtn,minusbtn);

        oneHbox = new HBox(onebtn,twobtn,threebtn,plusbtn);

        bottomHbox = new HBox(plus_minus_divisionbtn,zerobtn,dotbtn,equalBtn);

        root = new VBox(textFieldHbox,cHbox,sevenHbox,fourHbox,oneHbox,bottomHbox);

        Scene scene = new Scene(root);
        primaryStage.setTitle("181380044");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    private Button createButtons(String text) {
        Button btn = new Button(text);
        btn.setFont(new Font(32));
        btn.setPrefHeight(60);
        btn.setPrefWidth(120);

        return  btn;
    }

    private void mathExpression(Button btn, String str) {
        btn.setOnAction(e->{
            if (str.equals("sqrt")){
                data=Double.parseDouble( outputtf.getText());
                double ans=Math.sqrt(data);
                outputtf.setText(String.valueOf(ans));
            }
            else if(str.equals("x^2")){
                data=Double.parseDouble( outputtf.getText());
                double square = Math.pow(data,2);
                outputtf.setText(String.valueOf(square));
            }
        });

    }

    private class  GetButtonInput implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(event.getSource()==zerobtn){
                outputtf.setText(outputtf.getText() + "0");
            }
            else if(event.getSource()==onebtn){
                outputtf.setText(outputtf.getText() + "1");
            }
            else if(event.getSource()==twobtn){
                outputtf.setText(outputtf.getText() + "2");
            }
            else if(event.getSource()==threebtn){
                outputtf.setText(outputtf.getText() + "3");
            }
            else if(event.getSource()==fourbtn){
                outputtf.setText(outputtf.getText() + "4");
            }
            else if(event.getSource()==fivebtn){
                outputtf.setText(outputtf.getText() + "5");
            }
            else if(event.getSource()==sixbtn){
                outputtf.setText(outputtf.getText() + "6");
            }
            else if(event.getSource()==sevenbtn){
                outputtf.setText(outputtf.getText() + "7");
            }
            else if(event.getSource()==eightbtn){
                outputtf.setText(outputtf.getText() + "8");
            }
            else if(event.getSource()==ninebtn){
                outputtf.setText(outputtf.getText() + "9");
            }
            else if(event.getSource()==dotbtn){
                outputtf.setText(outputtf.getText() + ".");
            }
            else if(event.getSource()==clearbtn){
                outputtf.setText("");
            }
            else if(event.getSource()==plusbtn){
                data = Double.parseDouble(outputtf.getText());
                operation = 1;
                outputtf.setText("");
            }
            else if(event.getSource()==minusbtn){
                data = Double.parseDouble(outputtf.getText());
                operation = 2;
                outputtf.setText("");
            }
            else if(event.getSource()==multiplybtn){
                data = Double.parseDouble(outputtf.getText());
                operation = 3;
                outputtf.setText("");
            }
            else if(event.getSource()==squarebtn){
                data = Double.parseDouble(outputtf.getText());
                operation = 5;
                outputtf.setText("");

            }
            else if(event.getSource()==divisionbtn){
                data = Double.parseDouble(outputtf.getText());
                operation = 4;
                outputtf.setText("");
            }

            else if(event.getSource()==equalBtn){
                double data1 = Double.parseDouble(outputtf.getText());
                switch (operation){
                    case 1:
                        double add = data + data1;
                        outputtf.setText("" + add);
                        break;
                    case 2:
                        double negative = data - data1;
                        outputtf.setText("" + negative);
                        break;
                    case 3:
                        double mul = data * data1;
                        outputtf.setText("" + mul);
                        break;
                    case 4:
                        double div = 0;
                        try {
                            div = data / data1;
                        }
                        catch (Exception e){
                            outputtf.setText("error");
                        }

                        outputtf.setText("" + div);
                        break;
                }
            }

        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
