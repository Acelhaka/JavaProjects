

		/******************************************************************
		 * 																  *
		 * 						Amarilda Celhaka						  *
		 * 					Programming Assignment #6					  *
		 * 					     CMP SCI 2261							  *
		 * 				      Due Date: 12/5/2018						  *
		 * In this programming assignment we will be creating the layout  *
		 * for a game. Creating a GUI for a battleship game.			  *
		 *																  *															  *
		 * ****************************************************************/



import javafx.application.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text; 


public class BattleShipGame extends Application {

	/**Creating a grid pane */
	private GridPane gridPane = new GridPane();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		    /**Creating a boarder pane */
			BorderPane boarderPane = new BorderPane();
			
			
			/**Creating a text */
			Text text1 = new Text("Try to sink my battleship");
			text1.setFont(Font.font("Times New Roman", FontWeight.BOLD,20));
			
			/**Creating a new horizontal Box */
 			HBox hBox = new HBox(text1);
			
			/** To move the text field to the center after shrinking or expanding */
			hBox.setAlignment(Pos.BOTTOM_CENTER);
			hBox.setPadding(new Insets(10,10,10,10));
			hBox.setSpacing(50);
			hBox.setStyle("-fx-background-color: white");
			
			
			
			Image shipImage = new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRu9wvAVrP-qb1fawd2WwwHn89tx5lyAV7vN6dhOnaUqyN8o49QYw");
			ImageView imageView1 = new ImageView(shipImage);
		

		
			IntegerProperty hits = new SimpleIntegerProperty();
			
			Label hitLabel = new Label();
			hitLabel.textProperty().bind(hits.asString());
			
			final int misses = 0, sunk = 0;
			Label label1 = new Label("Hits: " );
			
			Label label2 = new Label("Misses: ");
			Label missLabel = new Label(Integer.toString(misses));
			Label label3 = new Label("Sunk:   " );
			Label sunkLabel = new Label(Integer.toString(sunk));
		
			
		
			VBox vBox = new VBox(label1, hitLabel, label2, missLabel, label3,sunkLabel, imageView1);
			vBox.setAlignment(Pos.CENTER);
			vBox.setStyle("-fx-background-color: white");
			vBox.setPadding(new Insets(0,10,0,10));

			vBox.setSpacing(5);
			/**Setting the gap between buttons to 0*/
			gridPane.setHgap(0);
			gridPane.setVgap(0);
			
			
			
			
			/** Creating a nested for loop to create a matrix of buttons */
			for(int i = 1; i <= 10; i++)
			{
				for(int j = 0; j < 10; j++) 
				{
					Button button = new Button(" ");
					button.setStyle("-fx-background-color: lightblue");
					button.setStyle("-fx-border-color: lightblue");
					Border buttonBorder = new Border(new BorderStroke(Color.LIGHTBLUE, 
				            BorderStrokeStyle.SOLID, null, null));
					button.setBorder(buttonBorder);
					
					/** Adding the buttons to the gridPane */
					gridPane.add(button, i, j);
					
					
					/**Binding the buttons, so they expand depending one the size of the grid pane */
					button.prefWidthProperty().bind(gridPane.widthProperty());
					button.prefHeightProperty().bind(gridPane.heightProperty());
					
					
					button.setMinWidth(5);
					button.setMinHeight(5);
					button.setMaxHeight(500);
					button.setMaxWidth(500);
					
					/** Creating and registering a handler 
					 * to increment the number of hits after each button is pressed*/
					button.setOnAction((ActionEvent event) -> 
					{
					    hits.set(hits.get()+1);
					});

				}
			}
			
			
			
			
			
			/**Creating three custom panes, left, top and center */
			boarderPane.setCenter(gridPane); 
			boarderPane.setTop(hBox);
			boarderPane.setLeft(vBox);
			boarderPane.setStyle("-fx-background-color: rgb(255, 255, 204)");
			
			
			/**Creating a scene and placing the boarder pane */
		    Scene scene = new Scene(boarderPane, 550, 375);
		    
		    /** Setting the stage title*/
		    primaryStage.setTitle("Battle Ship Game"); 
		    
		    /** Place the scene in the stage */
		    primaryStage.setScene(scene); 
		    
		    /** Displaying  the stage */
		    primaryStage.show(); 
		    
		  
	}
	
	      
		public static void main(String[] args) { 
		
			launch(args);
	  }	
	  
		
}