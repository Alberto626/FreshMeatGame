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
public class Pudge { // mythical creature 
	private int health; // if status is 1, pudge is alive, if pudge status is 0, hes dead 
	private char gridChar = 'P'; // this is the player model
	private int killPlayerTimer;
	
	public Pudge() { // when creating a new game, this is the default pudge
		killPlayerTimer = 40;
		health = 3;
	}
	public Pudge(int status) { //this is for loading a game
		this.health = status;
	}
	public void damageTaken(Stage PrimaryStage) {
		--health;
		if(health == 0) {
			System.out.println("Game Over");
			Pane pane = new Pane();
			Image image = new Image("gamepics/ggWin.jpg"); // needs to be a gg image
			pane.getChildren().add(new ImageView(image));
			Scene scene = new Scene(pane, 1000,1000);
			
			PrimaryStage.setScene(scene);
		}
	}
	public char getGridChar() {
		return this.gridChar;
	}
	public int getKillPlayerTimer () {
		return killPlayerTimer;
	}
	public void removeKillPlayerTimerCount() {
		killPlayerTimer--;
	}
	@Override
	public String toString() { // in the grid this will tell you if you are near pudge
		String rep = "Ahh Fresh Meat";
		return rep;
	}
	
}
