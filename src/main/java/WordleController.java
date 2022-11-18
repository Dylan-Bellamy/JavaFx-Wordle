import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class WordleController implements Initializable{

    // All possible answers //
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
    
    // Creating Id's For Already Created Panes //
    @FXML 
    VBox mainVBox;

    @FXML
    VBox anchor;

    // Initializing Panes, Labels, & Rectangles //
    HBox[] horzBox = new HBox[6];
    StackPane[][] stackPane = new StackPane[6][5];
    private Label[][] label = new Label[6][5];
    Rectangle[][] rect = new Rectangle[6][5];

    // Creating variables // 
    int pressed = 0;
    int correct = 0;
    int column;
    String answer = "";
    Random rand = new Random();

    // Creating buttons //
    Button reset = new Button("Play Again");
    Label win = new Label();
    Label lose = new Label();
    
    /**
     * initialize - Method that creates and starts the game by creating the answer,
     * the Hboxs and everything in them and putting them into a VBox
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        // Resets variables //
        correct = 0;
        pressed = 0;

        // Randomizes The Answer //
        answer = words[rand.nextInt(words.length)];

        mainVBox.setSpacing(5); // Sets the spacing of the already existing VBox
        for(int i=0; i<6;i++){ // (Columns)

            horzBox[i] = new HBox(5); // Creates & Sets the spacing of the HBoxs

            for(int j=0; j<5; j++){ // (Rows)
                
                // Creating StackPanes, Labels, & Rectangles //
                stackPane[i][j] = new StackPane(); 

                rect[i][j] = new Rectangle(70,70); 
                rect[i][j].setFill(Color.GHOSTWHITE);

                label[i][j] = new Label();
                label[i][j].setFont(new Font("Helvetica",40));

                // Distributing //
                stackPane[i][j].getChildren().addAll(rect[i][j],label[i][j]); // Adding labels & rectangles to stackpanes
                horzBox[i].getChildren().add(stackPane[i][j]); // Adding stackpanes to the HBoxs
                
             }
        mainVBox.getChildren().add(horzBox[i]); // Adding HBoxs to the mainVBox
        }
    }
    /**
     * loseScreen - If game is lost, It's creates and shows the 
     * lossing text and reset button. It also creates the reset
     * button ActionEvent for if its pressed it starts the resetClicked
     * method
     */
    private void loseScreen(){
        lose.setFont(new Font("Helvetica",20));
        lose.setText("You Lost, The Word was "+answer);
        reset.setPrefSize(120,40);
        anchor.setAlignment(Pos.CENTER);
        anchor.setSpacing(10);
        anchor.getChildren().addAll(lose,reset);
        reset.setOnAction(this::resetClicked);
    }
    /**
     * winScreen - If game is won, It's creates and shows the 
     * winning text and reset button. It also creates the reset
     * button ActionEvent for if its pressed it starts the resetClicked
     * method
     */
    private void winScreen(){
        win.setFont(new Font("Helvetica",20));
        win.setText("You Won On Your "+column+"th Try");
        reset.setPrefSize(120,40);
        anchor.setAlignment(Pos.CENTER);
        anchor.setSpacing(10);
        anchor.getChildren().addAll(win,reset);
        reset.setOnAction(this::resetClicked);
    }
    /**
     * resetClicked - If the reset button has been press, it 
     * resets the entire code to back when it first started
     * 
     * @param ae An event type that represents javafx.scene.control.Button 
     * has been fired 
     */
    private void resetClicked(ActionEvent ae){
        mainVBox.getChildren().clear();               // Clears everything in the mainVBox (HBoxs)
        anchor.getChildren().removeAll(reset,win,lose);   // Gets rid of the reset button & the added text
        initialize(null, null);  // Starts Initialize method again
    }
    /**
     * buttonClicked - If a button the keyboard is pressed, it gets
     * the text on the button pressed and set it to the label
     * 
     * @param ae An event type that represents javafx.scene.control.Button 
     * has been fired 
     */
    @FXML
    void buttonClicked(ActionEvent ae) { 
        
        Button tempButton = (Button)(ae.getSource()); // Gets the data from the button pressed and stores it in tempButton

        // Checks if the button wasn't ENTER or ⌫ button //
        if(!tempButton.getText().equals("ENTER") && (!tempButton.getText().equals("⌫"))){ // if the button wasn't ENTER or ⌫ button
            label[column][pressed].setText((tempButton.getText())); // Then get the text on the button pressed and set it to the label
        }
        else if(tempButton.getText().equals("⌫")){ // If button is ⌫ button
            if(pressed >= 1){  // And if is equal or greater than 1
            pressed--; // Pressed decreases
            label[column][pressed].setText(""); // Reset Text on the label
            }
        }
        else pressed--; // else pressed decreases

        if (pressed >= 5)  // If button times pressed is equal or greater than 5 
            pressed = 5;  // pressed is equal to 5

        if(!tempButton.getText().equals("⌫")) // If button text is not equal ⌫
            pressed++;   // pressed can increase
        
        
        // If all five letter a put in and and ENTER button is pressed
        // It then will check the guess and see what letters are correct and not and give hints 
        if(pressed >= 5 && tempButton.getText().equals("ENTER")){ 
            for(int i=0; i<5;i++){
                
                if(answer.toUpperCase().charAt(i) == label[column][0].getText().charAt(0)){ // Checks if Label 1's text is equal to any of answers characters
                    rect[column][0].setFill(Color.YELLOW); // Then that rectangle of 1 is the colour green
                }
                if(answer.toUpperCase().charAt(i) == label[column][1].getText().charAt(0)){ // Checks if Label 2's text is equal to any of answers characters
                    rect[column][1].setFill(Color.YELLOW); // Then that rectangle of 2 is the colour green
                }
                if(answer.toUpperCase().charAt(i) == label[column][2].getText().charAt(0)){ // Checks if Label 3's text is equal to any of answers characters
                    rect[column][2].setFill(Color.YELLOW); // Then that rectangle of 3 is the colour green
                }
                if(answer.toUpperCase().charAt(i) == label[column][3].getText().charAt(0)){ // Checks if Label 4's text is equal to any of answers characters
                    rect[column][3].setFill(Color.YELLOW); // Then that rectangle of 4 is the colour green
                }
                if(answer.toUpperCase().charAt(i) == label[column][4].getText().charAt(0)){ // Checks if Label 5's text is equal to any of answers characters
                    rect[column][4].setFill(Color.YELLOW); // Then that rectangle of 5 is the colour green
                }
                if(answer.toUpperCase().charAt(i) == label[column][i].getText().charAt(0)){ // Checks if Label of i's text is equal to answers character of i
                    rect[column][i].setFill(Color.GREEN); // Then that rectangle of i is the colour green
                    correct++; // Correct increases 
                }
                if(rect[column][i].getFill() == Color.GHOSTWHITE){ // If any rectangles haven't changed colour
                    rect[column][i].setFill(Color.LIGHTGREY); // Then set rectangle colour to lightgrey
                }
            }
        if(correct == 5){ // If the guess is equal to the answer
            winScreen(); // Start winScreen()
        }
        if(column == 5){ // If All 6 guesses are used up and don't equal to the answer
            loseScreen(); // Start loseScreen()
        }
        else{ // If not
        correct = 0; // Reset Correct
        pressed = 0; // Reset Pressed
        column++; // Column increases
        }
        }
    }
}