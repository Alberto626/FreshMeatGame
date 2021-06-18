import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainCharacter { // this is character you will be playing 
	private int weaponCharges;
	private int health = 1; // this will never change until player is dead
	private char gridChar = 'M'; 

	public MainCharacter() { // there is the  default character when creating a new game
		weaponCharges = (int)(Math.random() * 2) + 1;

	}
	
	public void addCharges() {
		++weaponCharges;
	}
	
	public void checkHealth() {
		
	}
	public char getGridChar() {
		return gridChar;
	}
	public int getWeaponCharges() {
		
		return weaponCharges;
	}
	public void removeCharges() {
		--weaponCharges;
		if(weaponCharges == 0 || weaponCharges < 0) {
			Stage stage = new Stage();
			Pane pane = new Pane();
			Text text = new Text(12,12, "You have run out of charges"); // needs to be a gg image
			pane.getChildren().add(text);
			Scene scene = new Scene(pane, 100,100);
			stage.show();
			weaponCharges = 0;
			
			stage.setScene(scene);
		}
	}
}


