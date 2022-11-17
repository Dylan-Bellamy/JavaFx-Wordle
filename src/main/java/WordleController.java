import java.net.URL;
//import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class WordleController implements Initializable{
    
    String[] words = {"Abuse","Adult","Agent","Anger","Apple","Award","Basis","Beach","Birth","Block","Blood","Board",
    "Brain","Bread","Break","Brown","Buyer","Cause","Chain","Chair","Chest","Chief","Child","China","Claim","Class",
    "Clock","Coach","Coast","Court","Cover","Cream","Crime","Cross","Crowd","Crown","Cycle","Dance","Death","Depth",
    "Doubt","Draft","Drama","Dream","Dress","Drink","Drive","Earth","Enemy","Entry","Error","Event","Faith","Fault",
    "Field","Fight","Final","Floor","Focus","Force","Frame","Frank","Front","Fruit","Glass","Grant","Grass","Green",
    "Group","Guide","Heart","Henry","Horse","Hotel","House","Image","Index","Input","Issue","Japan","Judge","Knife",
    "Layer","Level","Light","Limit","Lunch","Major","March","Match","Metal","Model","Money","Month","Motor","Mouth",
    "Music","Night","Noise","North","Novel","Nurse","Offer","Order","Other","Owner","Panel","Paper","Party","Peace",
    "Peter","Phase","Phone","Piece","Pilot","Pitch","Place","Plane","Plant","Plate","Point","Pound","Power","Press",
    "Price","Pride","Prize","Proof","Queen","Radio","Range","Ratio","Reply","Right","River","Round","Route","Rugby",
    "Scale","Scene","Scope","Score","Sense","Shape","Share","Sheep","Sheet","Shift","Shirt","Shock","Sight","Simon",
    "Skill","Sleep","Smile","Smith","Smoke","Sound","South","Space","Speed","Spite","Sport","Squad","Staff","Stage",
    "Start","State","Steam","Steel","Stock","Stone","Store","Study","Stuff","Style","Sugar","Table","Taste","Terry",
    "Theme","Thing","Title","Total","Touch","Tower","Track","Trade","Train","Trend","Trial","Trust","Truth","Uncle",
    "Union","Unity","Value","Video","Visit","Voice","Waste","Watch","Water","While","White","Whole","Woman","World",
    "Youth"};
   
    
    @FXML 
    VBox mainVBox;
    
    HBox[] horzBox = new HBox[6];
    StackPane[][] stackPane = new StackPane[6][5];
    int pressed = 0;
    
    Rectangle[][] rect = new Rectangle[6][5];

    private Label[][] label = new Label[6][5];
    int column;
    
    String answer = "Abuse";
      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainVBox.setSpacing(5);
        for(int i=0; i<6;i++){ // a,b,c,d,e,f (Columns)

            horzBox[i] = new HBox(5);

            for(int j=0; j<5; j++){ // 1,2,3,4,5 (Rows)
                
                stackPane[i][j] = new StackPane();

                rect[i][j] = new Rectangle(70,70); 
                rect[i][j].setFill(Color.GHOSTWHITE);

                label[i][j] = new Label();
                label[i][j].setFont(new Font("Helvetica",40));

                stackPane[i][j].getChildren().addAll(rect[i][j],label[i][j]);
                horzBox[i].getChildren().add(stackPane[i][j]);
                
             }
        mainVBox.getChildren().add(horzBox[i]);
        }
    }

    @FXML
    void buttonClicked(ActionEvent ae) { 
        
        Button tempButton = (Button)(ae.getSource());
        System.out.println(tempButton.getText());

        if (pressed < 5){
        label[column][pressed].setText((tempButton.getText()));  
        pressed++;
        }
        // System.out.println("pass");
        if(pressed >= 5){
            for(int i=0; i<5;i++){
                
                if(answer.toUpperCase().charAt(i) == label[column][0].getText().charAt(0)){
                    rect[column][0].setFill(Color.YELLOW);
                }
                if(answer.toUpperCase().charAt(i) == label[column][1].getText().charAt(0)){
                    rect[column][1].setFill(Color.YELLOW);
                }
                if(answer.toUpperCase().charAt(i) == label[column][2].getText().charAt(0)){
                    rect[column][2].setFill(Color.YELLOW);
                }
                if(answer.toUpperCase().charAt(i) == label[column][3].getText().charAt(0)){
                    rect[column][3].setFill(Color.YELLOW);
                }
                if(answer.toUpperCase().charAt(i) == label[column][4].getText().charAt(0)){
                    rect[column][4].setFill(Color.YELLOW);
                }
                if(answer.toUpperCase().charAt(i) == label[column][i].getText().charAt(0)){
                    rect[column][i].setFill(Color.GREEN);
                }
                if(rect[column][i].getFill() == Color.GHOSTWHITE){
                    rect[column][i].setFill(Color.LIGHTGREY);
                }
            }
        pressed = 0;
        column++; 
        }
    }
}

    // private void output(String input){
      
    // }
    

    