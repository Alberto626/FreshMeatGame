/*Alberto Landeros
 * CIN:306512276
 * CS2012 section 1 & 2
 * In this game, you control a player and u are supposed to move around using the WASD
 * and to fight pudge(mythical creature in this game) use UP DOWN LEFT RIGHT arrow keys
 * remeber there are obstacles in this game that will prevent u from killing pudge
 */
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
import java.io.File;
import java.util.Scanner;

public class tester extends Application {
	public static int c;
	public static int r;
	public static String textBox;
	public void start(Stage PrimaryStage) { 

		Scene mainScene = new Scene(mainPane(PrimaryStage), 1000,1000);
		PrimaryStage.setTitle("This title means nothing");
		PrimaryStage.setScene(mainScene);

		PrimaryStage.show();


	}
	public GridPane mainPane(Stage PrimaryStage) { 
		VBox allButtons = new VBox(125);
		allButtons.setAlignment(Pos.CENTER);


		GridPane mainPane = new GridPane();
		Image mainImage = new Image("gamepics/mainBackground.jpg");

		Button newGame = new Button("New game");
		Button loadGame = new Button("Load Game");
		Button about = new Button("About");
		Button story = new Button("Story");

		newGame.setMaxSize(200, 200);
		loadGame.setMaxSize(200, 200);
		about.setMaxSize(200, 200);
		story.setMaxSize(200, 200);

		allButtons.getChildren().addAll(newGame,loadGame,about,story);
		newGame.setOnAction(e -> {
			newGame(PrimaryStage);
		});
		about.setOnAction(e -> {
			about();
		});
		story.setOnAction(e -> {
			story();
		});
		loadGame.setOnAction(e -> {
			loadGame(PrimaryStage);
		});

		mainPane.getChildren().add(new ImageView(mainImage));
		mainPane.getChildren().add(allButtons);

		return mainPane;
	}
	public void newGame(Stage PrimaryStage) {
		GridPane grid = new GridPane();
		Scene scene = new Scene(grid,1000,1000);

		Button button5 = new Button("5x5");
		Button button7 = new Button("7x7");
		Button button10 = new Button("10x7");

		VBox buttons = new VBox(200);
		button5.setMaxSize(200, 200);
		button7.setMaxSize(200, 200);
		button10.setMaxSize(200, 200);
		button5.setOnAction(e -> {
			actualGame(5,5,PrimaryStage);
		});
		button7.setOnAction(e -> {
			actualGame(7,7,PrimaryStage);
		});
		button10.setOnAction(e -> {
			actualGame(10,7,PrimaryStage); // remember this is columns first then rows 
		});
		Image background = new Image("gamepics/mainbackground.jpg");
		grid.getChildren().add(new ImageView(background));
		buttons.getChildren().addAll(button5,button7,button10);
		buttons.setAlignment(Pos.CENTER);
		grid.getChildren().add(buttons);


		PrimaryStage.setScene(scene);
	}
	public void actualGame(int row, int column,Stage PrimaryStage) {
		GridPane map = new GridPane();
		Scene scene = new Scene(map,1000,1000); 
		for(int r = 0; r < row; r++) {
			for(int c = 0; c < column; c++) {

				map.add(new ImageView(new Image("gamepics/room.png")), r, c); // these are inverted 
			}
		}
		
		Image character = new Image("gamepics/mainCharacter.png");
		ImageView characterImage = new ImageView(character);

		c = 0; //this is column position, MAINLY FOR REFERCENCE
		r = 0; //this is the row position for the grid
		MainCharacter mainCharacter = new MainCharacter();

		map.add(characterImage, c, r);
		GridMaps backEndMap = new GridMaps(row, column);
		backEndMap.setCharacterAtXY(c,r,mainCharacter.getGridChar());


		Pudge pudge = new Pudge();
		
		TechiesMine mine1 = new TechiesMine();
		int cMine = (int)(Math.random() * backEndMap.getGrid().length); // 7
		int rMine = (int)(Math.random() * backEndMap.getGrid()[0].length); //10
		
		int c2Mine = (int)(Math.random() * backEndMap.getGrid().length); // 7
		int r2Mine = (int)(Math.random() * backEndMap.getGrid()[0].length); //10
		
		int c3Mine = (int)(Math.random() * backEndMap.getGrid().length); // 7
		int r3Mine = (int)(Math.random() * backEndMap.getGrid()[0].length); //10
		
		LootWhore whore = new LootWhore();
		int cWhore = (int)(Math.random() * backEndMap.getGrid().length);
		int rWhore = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		int c2Whore = (int)(Math.random() * backEndMap.getGrid().length);
		int r2Whore = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		int c3Whore = (int)(Math.random() * backEndMap.getGrid().length);
		int r3Whore = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		Chest chest = new Chest();
		
		int cChest = (int)(Math.random() * backEndMap.getGrid().length);
		int rChest = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		int c2Chest = (int)(Math.random() * backEndMap.getGrid().length);
		int r2Chest = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		int c3Chest = (int)(Math.random() * backEndMap.getGrid().length);
		int r3Chest = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		int cPudge = (int)(Math.random() * backEndMap.getGrid().length);
		int rPudge = (int)(Math.random() * backEndMap.getGrid()[0].length);
		
		
		backEndMap.getGrid()[cMine][rMine] = mine1.getGridChar();
		backEndMap.getGrid()[c2Mine][r2Mine] = mine1.getGridChar();
		backEndMap.getGrid()[c3Mine][r3Mine] = mine1.getGridChar();
		
		backEndMap.getGrid()[cWhore][rWhore] = whore.getGridChar();
		backEndMap.getGrid()[c2Whore][r2Whore] = whore.getGridChar();
		backEndMap.getGrid()[c3Whore][r3Whore] = whore.getGridChar();
		
		backEndMap.getGrid()[cChest][rChest] = chest.getGridChar();
		backEndMap.getGrid()[c2Chest][r2Chest] = chest.getGridChar();
		backEndMap.getGrid()[c3Chest][r3Chest] = chest.getGridChar();

		backEndMap.getGrid()[cPudge][rPudge] = pudge.getGridChar();
		
		Button debug = new Button("Debug");
		debug.setOnAction(e -> {
			
			Image mine = new Image("gamepics/mine.jpg"); // mines go first
			ImageView mineView = new ImageView(mine);
			ImageView mine2View = new ImageView(mine);
			ImageView mine3View = new ImageView(mine);
			map.add(mineView, rMine, cMine);
			map.add(mine2View,r2Mine,c2Mine);
			map.add(mine3View,r3Mine,c3Mine);
			
			Image whoreImage = new Image("gamepics/lootWhore.jpg");
			ImageView whoreView = new ImageView(whoreImage);
			ImageView whoreView2 = new ImageView(whoreImage);
			ImageView whoreView3 = new ImageView(whoreImage);
			map.add(whoreView, rWhore, cWhore);
			map.add(whoreView2, r2Whore, c2Whore);
			map.add(whoreView3, r3Whore, c3Whore);
			
			Image chestImage = new Image("gamepics/chest.png");
			ImageView chestView = new ImageView(chestImage);
			ImageView chestView2 = new ImageView(chestImage);
			ImageView chestView3 = new ImageView(chestImage);
			map.add(chestView, rChest, cChest);
			map.add(chestView2, r2Chest, c2Chest);
			map.add(chestView3, r3Chest, c3Chest); 
			
			
			Image pudgeImage = new Image("gamepics/pudge.jpg"); // pudge goes last
			ImageView imageView = new ImageView(pudgeImage);
			map.add(imageView, rPudge, cPudge);
		});
		Button save = new Button("Save Game");
		save.setOnAction(e -> {
			
		});
		map.add(debug, 0, 15);
		map.add(save, 1, 15);

		//

		//
//		for(int x =0; backEndMap.getGrid().length > x; x++) { // THIS IF FOR LOOKING AT BACKEND IF NEEDED T
//			for(int y =0; backEndMap.getGrid()[x].length > y; y++) {
//				System.out.print(backEndMap.getGrid()[x][y] + " ");
//			}
//			System.out.println();
//		}
		//

		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
			case W: //up
				if(r -1 < 0) {

				}
				else {
					map.getChildren().remove(characterImage);
					pudge.removeKillPlayerTimerCount();
					r--;
					if(backEndMap.getGrid()[r][c] == pudge.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == mine1.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == whore.getGridChar()) {
						mainCharacter.removeCharges();
						chargesGainOrLoss(whore);
					}
					if(backEndMap.getGrid()[r][c] == chest.getGridChar()) {
						mainCharacter.addCharges();
						chargesGainOrLoss(chest);
					}
					if(pudge.getKillPlayerTimer() == 0) {
						endGameLost(PrimaryStage);
					}
					try { // this is to display a message if near pudge
						if(backEndMap.getGrid()[r+1][c] == pudge.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == pudge.getGridChar()) {

							popUpMessages(pudge);
						}
						if(backEndMap.getGrid()[r+1][c] == mine1.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == mine1.getGridChar()) {

							popUpMessages(mine1);
						}
						if(backEndMap.getGrid()[r+1][c] == whore.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == whore.getGridChar()) {

							popUpMessages(whore);
						}
						if(backEndMap.getGrid()[r+1][c] == chest.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == chest.getGridChar()) {

							popUpMessages(chest);
						}
					}
					
					catch (ArrayIndexOutOfBoundsException ex) {
						
					}
					map.add(characterImage, c, r);
					backEndMap.getGrid()[r][c] = mainCharacter.getGridChar();

				}
				break;

			case A: 
				if(c -1 < 0) {  // left

				} 
				else {

					map.getChildren().remove(characterImage);
					c--;
					pudge.removeKillPlayerTimerCount();

					if(backEndMap.getGrid()[r][c] == pudge.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == mine1.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == whore.getGridChar()) {
						mainCharacter.removeCharges();
						chargesGainOrLoss(whore);
					}
					if(backEndMap.getGrid()[r][c] == chest.getGridChar()) {
						mainCharacter.addCharges();
						chargesGainOrLoss(chest);
					}
					if(pudge.getKillPlayerTimer() == 0) {
						endGameLost(PrimaryStage);
					}
					try { // this is to display a message if near pudge
						if(backEndMap.getGrid()[r+1][c] == pudge.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == pudge.getGridChar()) {

							popUpMessages(pudge);
						}
						if(backEndMap.getGrid()[r+1][c] == mine1.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == mine1.getGridChar()) {

							popUpMessages(mine1);
						}
						if(backEndMap.getGrid()[r+1][c] == whore.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == whore.getGridChar()) {

							popUpMessages(whore);
						}
						if(backEndMap.getGrid()[r+1][c] == chest.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == chest.getGridChar()) {

							popUpMessages(chest);
						}
					}
					catch (ArrayIndexOutOfBoundsException ex) {
						
					}
					map.add(characterImage, c, r);
					backEndMap.getGrid()[r][c] = mainCharacter.getGridChar();

				}
				break;
			case S:  // down
				if(r + 1 >= backEndMap.getGrid().length) {

				}
				else {

					map.getChildren().remove(characterImage);
					r++;
					pudge.removeKillPlayerTimerCount();
					if(backEndMap.getGrid()[r][c] == pudge.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == mine1.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == whore.getGridChar()) {
						mainCharacter.removeCharges();
						chargesGainOrLoss(whore);
					}
					if(backEndMap.getGrid()[r][c] == chest.getGridChar()) {
						mainCharacter.addCharges();
						chargesGainOrLoss(chest);
					}
					if(pudge.getKillPlayerTimer() == 0) {
						endGameLost(PrimaryStage);
					}
					
					try { // this is to display a message if near pudge
						if(backEndMap.getGrid()[r+1][c] == pudge.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == pudge.getGridChar()) {

							popUpMessages(pudge);
						}
						if(backEndMap.getGrid()[r+1][c] == mine1.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == mine1.getGridChar()) {

							popUpMessages(mine1);
						}
						if(backEndMap.getGrid()[r+1][c] == whore.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == whore.getGridChar()) {

							popUpMessages(whore);
						}
						if(backEndMap.getGrid()[r+1][c] == chest.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == chest.getGridChar()) {

							popUpMessages(chest);
						}
					}
					catch (ArrayIndexOutOfBoundsException ex) {
						
					}
					map.add(characterImage, c, r);
					backEndMap.getGrid()[r][c] = mainCharacter.getGridChar();

				}


				break;
			case D: // right
				if(c+ 1 >= backEndMap.getGrid()[1].length) {

				}
				else {
					map.getChildren().remove(characterImage);
					c++;
					pudge.removeKillPlayerTimerCount();

					if(backEndMap.getGrid()[r][c] == pudge.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == mine1.getGridChar()) {
						endGameLost(PrimaryStage);
					}
					if(backEndMap.getGrid()[r][c] == whore.getGridChar()) {
						mainCharacter.removeCharges();
						chargesGainOrLoss(whore);
					}
					if(backEndMap.getGrid()[r][c] == chest.getGridChar()) {
						mainCharacter.addCharges();
						chargesGainOrLoss(chest);
					}
					if(pudge.getKillPlayerTimer() == 0) {
						endGameLost(PrimaryStage);
					}
					
					try { // this is to display a message if near pudge
						if(backEndMap.getGrid()[r+1][c] == pudge.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == pudge.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == pudge.getGridChar()) {

							popUpMessages(pudge);
						}
						if(backEndMap.getGrid()[r+1][c] == mine1.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == mine1.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == mine1.getGridChar()) {

							popUpMessages(mine1);
						}
						if(backEndMap.getGrid()[r+1][c] == whore.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == whore.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == whore.getGridChar()) {

							popUpMessages(whore);
						}
						if(backEndMap.getGrid()[r+1][c] == chest.getGridChar() || 
								backEndMap.getGrid()[r-1][c] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c-1] == chest.getGridChar() ||
								backEndMap.getGrid()[r][c+1] == chest.getGridChar()) {

							popUpMessages(chest);
						}
					}
					catch (ArrayIndexOutOfBoundsException ex) {
						
					}
					map.add(characterImage, c, r);
					backEndMap.getGrid()[r][c] = mainCharacter.getGridChar();

				}
				break;
				//this is to attack pudge if you have weapon charges
			case UP: 
				if(mainCharacter.getWeaponCharges() == 0) {
					mainCharacter.removeCharges();
					break;
				}
				try { // this is to display a message if near pudge
					if(backEndMap.getGrid()[r-1][c] == pudge.getGridChar()) {

						pudge.damageTaken(PrimaryStage);
						mainCharacter.removeCharges(); // just because u attack doesnt mean u lose charges, you lose charges by hurting pudge
					}
					else {
						mainCharacter.removeCharges();
					}
				}
				catch (ArrayIndexOutOfBoundsException ex) {
					
				}
				break;

			case DOWN:
				if(mainCharacter.getWeaponCharges() == 0) {
					mainCharacter.removeCharges();
					break;
				}
				try { // this is to display a message if near pudge
					if(backEndMap.getGrid()[r+1][c] == pudge.getGridChar()) {

						pudge.damageTaken(PrimaryStage);
						mainCharacter.removeCharges();
					}
					else {
						mainCharacter.removeCharges();
					}
				}
				catch (ArrayIndexOutOfBoundsException ex) {
					
				}
				break;

			case LEFT:
				if(mainCharacter.getWeaponCharges() == 0) {
					mainCharacter.removeCharges();
					break;
				}
				else {
					mainCharacter.removeCharges();
				}
				try { // this is to display a message if near pudge
					if(backEndMap.getGrid()[r][c-1] == pudge.getGridChar()) {

						pudge.damageTaken(PrimaryStage);
						mainCharacter.removeCharges();
					}
				}
				catch (ArrayIndexOutOfBoundsException ex) {
					
				}
				break;

			case RIGHT:
				if(mainCharacter.getWeaponCharges() == 0) {
					mainCharacter.removeCharges();
					break;
				}
				try { // this is to display a message if near pudge
					if(backEndMap.getGrid()[r][c+1] == pudge.getGridChar()) {

						pudge.damageTaken(PrimaryStage);
						mainCharacter.removeCharges();
					}
					else {
						mainCharacter.removeCharges();
					}
				}
				catch (ArrayIndexOutOfBoundsException ex) {
					
				}
				break;
			}

		});

		PrimaryStage.setScene(scene);

	}
	public void chargesGainOrLoss(ChargesGainOrLoss msg) {
		Stage stage = new Stage();
		Pane pane = new Pane();
		Text popUp = new Text(10,20, msg.charges());

		pane.getChildren().add(popUp);
		Scene scene = new Scene(pane,500,200);

		stage.setScene(scene);
		stage.show();
	}
	public void endGameLost(Stage PrimaryStage) {
		Pane pane = new Pane();
		Image gg = new Image("gamePics/ggLoss.jpg");
		pane.getChildren().add(new ImageView(gg));
		Scene scene = new Scene(pane, 500,350);

		PrimaryStage.setScene(scene);

	}

	public void popUpMessages(Object others) {
		Stage stage = new Stage();
		Pane pane = new Pane();
		Text popUp = new Text(10,20, others.toString());

		pane.getChildren().add(popUp);
		Scene scene = new Scene(pane,500,200);

		stage.setScene(scene);
		stage.show();
	}

	public void loadGame(Stage PrimaryStage) {
		
	}

	public void about() {
		Stage secondaryStage = new Stage();
		Text text = new Text(10,10,"How to Play:"
				+ "\nWASD is to move around the board"
				+ "\nDo you want to attack, for press the UP DOWN LEFT RIGHT ARROW KEYS"
				+ "\nThere are goblins on the map and they will make ur weapons durability weaker"
				+ "\nIf you are in the same room as Pudge, pudge will eat you and game is over"
				+ "\nRemeber you a person who grabbed a random sword you dont know how strong it is, so best way to win the game is to find all"
				+ "\nChests that make ur weapons durability better"
				+ "\nIn this game there are 3 ways to die"
				+ "\nOne is by being in the same room as the Mine"
				+ "\nand Two is by being in the same room as Pudge"
				+ "\nThird is moving your player 37 times, You will lose automatically"
				+ "\nImportant tip, hugging the edge is very dangerous because You will NOT get notifications for this Cheesing"
				+ ""
				+ ""
				+ "");

		Pane pane = new Pane();

		pane.getChildren().addAll(text);
		Scene scene = new Scene(pane,600,600);

		secondaryStage.setTitle("world");
		secondaryStage.setScene(scene);

		secondaryStage.show();
	}
	public void story() {
		Stage secondaryStage = new Stage();

		Text text = new Text(0,475,"You wake up on a meat hook, dazzed and injured"
				+ "\nAfter forcefully removing the meat hook from ur shoulder"
				+ "\nYou see ransacks of blood around and a extreme amount of corpses butchered up"
				+ "\nScared and afraid, you pick up a Broad Sword"
				+ "\nNow You must fight transverse the infinte amound of rooms and hopefully Dont run into the"
				+ "\nCreature that put you in that meat hook"
				+ "\nBeware of the Butcher is all you remember"
				+ "\nYou must hurry and kill the butcher before he ready to go for You the next FRESH MEAT!"
				+ ""
				+ " ");
		Image image = new Image("gamePics/story.png");
		Pane pane = new Pane();

		pane.getChildren().addAll(text, new ImageView(image));
		Scene scene = new Scene(pane,600,600);
		secondaryStage.setTitle("world");
		secondaryStage.setScene(scene);

		secondaryStage.show();
	}
	public static void main(String[] args) {

		Application.launch(args);
	}
}
