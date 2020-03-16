package com.Group12.Game;
import java.util.ArrayList;
import java.io.*;
import java.util.Random;
import java.util.Scanner; 

/**
 * Handles the game's logic.
 * @author Nicholas, Daniel, Wilson, Yuxi
 *
 */
public class GameMain {
	
	// Attributes
	
	private static GameMain gameMain;
	
	private Enemy[] enemies;
	private Collectible[] collectibles;
	private MainCharacter mainChar;
	private Board board;
	
	private int objectivesRemaining;
	private StateType gameState;
	private int score;
	private TickTimer tick;
	
	// Methods
	
	private GameMain() {
		enemies = new Enemy[];
		collectibles = new Collectible[];
		mainChar = new MainCharacter;
		board = new Board;
		
		objectivesRemaining = 4;
		//gameState = Menu;		//TODO: once the enumeration is finalized
		score = 0;
		tick = new TickTimer;
	}
	
	/**
	 * This method returns the single instance of GameMain
	 * if it exists, otherwise it creates a new instance.
	 * @return GameMain	This returns the instance of GameMain.
	 */
	public static GameMain getInstance() {
		if(gameMain == null) {
			gameMain = new GameMain();
		}
		return gameMain;
	}
	
	public void startGame() {
		makeBoard("map1");		//TODO: don't hardcode + decide on proper file location
	}
	
	public void update() {
		
	}
	
	private void updatePlayer() {
		
	}
	
	private void updateEnemies() {
		
	}
	
	private void updateDisplay() {
		
	}
	
	
	//In moveenemy, I ask enemy to search MC's position 
	//and judege whether it is allowed to move, This function isValidMove(x,y) I write in Board class (avoid wall or boundary)
	//and then move towards MC
	//The problem here is I have to get position of MC so I think we should public mainCharacter.
	
	private void moveEnemy(Enemy e) {
		 while(true) {
			 int dirc; //dirc = 0 is up, 1 is down,  2 is left, 3 is right
			 if(mainChar.getYPos - e.getY > 0 && Math.abs(mainChar.getYPos - e.getY) >= Math.abs(mainChar.getXPos - e.getX) && board.isValidMove(int x, int y+1)) {
				 dirc=0
			 }
			 else if(mainChar.getYPos - e.getY < 0 && Math.abs(mainChar.getYPos - e.getY) >= Math.abs(mainChar.getXPos - e.getX) && board.isValidMove(int x, int y-1)) {
				 dirc=1
			 }
			 else if(mainChar.getXPos - e.getX < 0 && Math.abs(mainChar.getXPos - e.getX) >= Math.abs(mainChar.getYPos - e.getY) && board.isValidMove(int x-1, int y)) {
				 dirc=2
			 }
			 else if(mainChar.getXPos - e.getX > 0 && Math.abs(mainChar.getXPos - e.getX) >= Math.abs(mainChar.getYPos - e.getY) && board.isValidMove(int x+1, int y)) {
				 dirc=3
			 }
			 else
			 {
				 Random rand = new Random();
				 dirc = rand.nextInt(4);
			 }
			 int newX, newY;
			 System.out.println(dirc);
			 switch (dirc) {
				 case 0:
				 // up
				 newX = x;
				 newY = y+1;
				 break;
			 case 1:
				 // down
				 newX = x;
				 newY = y-1;
				 break;
			 case 2:
				 // left
				 newX = x-1;
				 newY = y;
				 break;
			 case 3:
				 // right
				 newX = x+1;
				 newY = y;
				 break;
			 default:
				 //Should set enemy is a reasonable location.
				 newX = -1;
				 newY = -1;
			}
		 
		 
		 if (board.isValidMove(newX, newY)) {
			x = newX;
			y = newY;
		
		return;
		 		}
		 	}

	}
	
	//when Enemy e collision with MC.
	private void collision(Enemy e)
	{
		if(e.x == mainChar.x && e.y == mainChar.y) {
			mainChar.setHealth(100);
		}
	}
	
	
	/**
	 * This method reads from a file and uses it to initialize
	 * board, enemies, collectibles, and mainChar.
	 * @param x This is the name of the file that makeBoard reads from.
	 */
	private void makeBoard(String x) {
		// file format: xDim yDim
		// remaining yDim lines of xDim characters: board layout & entity placement
		File file = new File(x);
		Scanner sc = new Scanner(file);
		int xSize, ySize;
		xSize = sc.nextInt();
		ySize = sc.nextInt();
		this.board.setXSize(xSize);		//TODO: tell Daniel board either must be dynamic or accept dims in constructor
		this.board.setYSize(ySize);
		sc.nextLine();
		
		/* characters in file:
		 * 	. = Open
		 * 	# = Barrier				TODO: tell Daniel celltype is Barrier in the UML Diagram
		 * all other characters also on Open tiles
		 * 	@ = MainCharacter
		 * 	G = Goal
		 * 	E = Enemy
		 * 	P = Punishment
		 * 	O = ObjectiveReward
		 * 	W = WeaponCollectible
		 */
		
		for (int i = 0; i < ySize; i++) {
			String line = sc.nextLine();	//TODO: determine if file must end with newline character (currently does not)
			for (int j = 0; j < xSize; j++) {
				char c = line.charAt(j);
				switch (c) {
				case '#':
					this.board.setCellType(j, i, cellType.BARRIER);
					break;
				case '@':
					this.mainChar.setX(j);	//TODO: wasn't this supposed to be setPos() from the diagram?
					this.mainChar.setY(i);
					break;
				case 'G':	//TODO: turns out knowing where the goal is is important for game logic; will add somehow - return value or private attr?
					break;
				case 'E':	//TODO: array length is fixed on creation, so enemies/collectibles need drastic rework (i recommend java.util.ArrayList, or Vector for multithread safety)
					Enemy temp = new Enemy(j,i);
					this.enemies.add(temp);
					break;
				case 'P':
					Punishment temp = new Punishment(j,i);
					this.collectibles.add(temp);
					break;
				case 'O':
					ObjectiveReward temp = new ObjectiveReward(j,i);
					this.collectibles.add(temp);
					break;
				case 'W':
					WeaponCollectible temp = new WeaponCollectible(j,i);
					this.collectibles.add(temp);
					break;
				case '.':	default:
					//board.setCellType(j, i, cellType.OPEN);	// at time of writing, cells initialized as OPEN
					break;
				}
			}
		}
		
		sc.close();
	}
	*/

}
