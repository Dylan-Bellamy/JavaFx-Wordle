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
    String[] words = {"Abuse","Adult"};
    // Agent
    // Anger
    // Apple
    // Award
    // Basis
    // Beach
    // Birth
    // Block
    // Blood
    // Board
    // Brain
    // Bread
    // Break
    // Brown
    // Buyer
    // Cause
    // Chain
    // Chair
    // Chest
    // Chief
    // Child
    // China
    // Claim
    // Class
    // Clock
    // Coach
    // Coast
    // Court
    // Cover
    // Cream
    // Crime
    // Cross
    // Crowd
    // Crown
    // Cycle
    // Dance
    // Death
    // Depth
    // Doubt
    // Draft
    // Drama
    // Dream
    // Dress
    // Drink
    // Drive
    // Earth
    // Enemy
    // Entry
    // Error
    // Event
    // Faith
    // Fault
    // Field
    // Fight
    // Final
    // Floor
    // Focus
    // Force
    // Frame
    // Frank
    // Front
    // Fruit
    // Glass
    // Grant
    // Grass
    // Green
    // Group
    // Guide
    // Heart
    // Henry
    // Horse
    // Hotel
    // House
    // Image
    // Index
    // Input
    // Issue
    // Japan
    // Jones
    // Judge
    // Knife
    // Laura
    // Layer
    // Level
    // Lewis
    // Light
    // Limit
    // Lunch
    // Major
    // March
    // Match
    // Metal
    // Model
    // Money
    // Month
    // Motor
    // Mouth
    // Music
    // Night
    // Noise
    // North
    // Novel
    // Nurse
    // Offer
    // Order
    // Other
    // Owner
    // Panel
    // Paper
    // Party
    // Peace
    // Peter
    // Phase
    // Phone
    // Piece
    // Pilot
    // Pitch
    // Place
    // Plane
    // Plant
    // Plate
    // Point
    // Pound
    // Power
    // Press
    // Price
    // Pride
    // Prize
    // Proof
    // Queen
    // Radio
    // Range
    // Ratio
    // Reply
    // Right
    // River
    // Round
    // Route
    // Rugby
    // Scale
    // Scene
    // Scope
    // Score
    // Sense
    // Shape
    // Share
    // Sheep
    // Sheet
    // Shift
    // Shirt
    // Shock
    // Sight
    // Simon
    // Skill
    // Sleep
    // Smile
    // Smith
    // Smoke
    // Sound
    // South
    // Space
    // Speed
    // Spite
    // Sport
    // Squad
    // Staff
    // Stage
    // Start
    // State
    // Steam
    // Steel
    // Stock
    // Stone
    // Store
    // Study
    // Stuff
    // Style
    // Sugar
    // Table
    // Taste
    // Terry
    // Theme
    // Thing
    // Title
    // Total
    // Touch
    // Tower
    // Track
    // Trade
    // Train
    // "Trend"
    // "Trial"
    // "Trust"
    // "Truth"
    // "Uncle"
    // "Union"
    // "Unity"
    // "Value"
    // "Video"
    // "Visit"
    // "Voice"
    // "Waste"
    // "Watch"
    // "Water"
    // "While"
    // "White"
    // "Whole"
    // "Woman"
    // "World"
    // "Youth"
    @FXML 
    VBox mainVBox;

    @FXML
    HBox horzBox1 = new HBox(0);
    HBox horzBox2 = new HBox(0);

    @FXML
    private TextField a1,a2;

   //String in = "";
    
    @FXML
    private AnchorPane wordPane;
    @FXML
    private AnchorPane buttonPane;
      
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // for(int i=0; i<5;i++){ // a,b,c,d,e (Rows)
        //     horzBox[i] = new HBox(0);
        //     for(int j=0; j<4; j++){ // 1,2,3,4,5 (Columns)
                
                
                    
                    
                
        //      }
        // }
        Rectangle rect = new Rectangle(50,50);
        rect.setFill(Color.GRAY);
        horzBox1.getChildren().add(rect);
        horzBox2.getChildren().add(rect);

        mainVBox.getChildren().add(horzBox1);
        mainVBox.getChildren().add(horzBox2);
        
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
    