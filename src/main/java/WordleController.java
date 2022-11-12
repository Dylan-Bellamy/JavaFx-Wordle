import java.net.URL;
//import java.util.Random;
import java.util.ResourceBundle;

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WordleController implements Initializable {
    
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
    
    @FXML
    HBox horzBox1 = new HBox(5);
    HBox horzBox2 = new HBox(5);
    HBox horzBox3 = new HBox(5);
    HBox horzBox4 = new HBox(5);
    HBox horzBox5 = new HBox(5);
    HBox horzBox6 = new HBox(5);

    @FXML
    private TextField a1,a2;

   //String in = "";
    
    @FXML
    private AnchorPane wordPane;
    @FXML
    private AnchorPane buttonPane;
      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mainVBox.setSpacing(5);
        for(int i=0; i<6;i++){ // a,b,c,d,e (Rows)
            
            for(int j=0; j<5; j++){ // 1,2,3,4,5 (Columns)
                
                Rectangle[][] rect = new Rectangle[6][5];
                rect[i][j] = new Rectangle(70,70);    

                if (i == 0){
                    horzBox1.getChildren().add(rect[i][j]);
                }
                if (i == 1){
                    horzBox2.getChildren().add(rect[i][j]);
                }
                if (i == 2){
                    horzBox3.getChildren().add(rect[i][j]);
                }
                if (i == 3){
                    horzBox4.getChildren().add(rect[i][j]);
                }
                if (i == 4){
                    horzBox5.getChildren().add(rect[i][j]);
                }
                if (i == 5){
                    horzBox6.getChildren().add(rect[i][j]);
                }
             }
        }

        mainVBox.getChildren().add(horzBox1);
        mainVBox.getChildren().add(horzBox2);
        mainVBox.getChildren().add(horzBox3);
        mainVBox.getChildren().add(horzBox4);
        mainVBox.getChildren().add(horzBox5);
        mainVBox.getChildren().add(horzBox6);
        
    }
    // @FXML
    // void buttonQClicked(ActionEvent event) {
    //     addString("Q");
    // }
    // public void updateTextField(){
    //     textField.setText();
    // }
    // public void addString(String number){
    //     updateTextField();
    // }
    
}
    