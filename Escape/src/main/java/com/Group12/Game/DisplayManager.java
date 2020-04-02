package com.Group12.Game;


import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.Group12.Game.GameMain.GameState;

import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


/**
 * Handles graphical display.
 * @author Daniel, Wilson
 *
 */
@SuppressWarnings("serial")
public class DisplayManager extends JPanel{
	
	// Attributes
	JFrame gameWindow;
	
	//Game Items
	private int sizeX;
	private int sizeY;
	private int cellSize;
	private int score;
	
	private int goalX;
	private int goalY;
	private float timePercentage;
	private Board board;
	private MainCharacter mainChar;
	private ArrayList<Enemy> enemies;
	private ArrayList<Punishment> punishments;
	private ArrayList<BonusReward> bonusRewards;
	private ArrayList<ObjectiveReward> objectiveRewards;
	
	private ImageData imgData;
	
	
	//Enum to hold current state. Used when updating display
	GameMain.GameState currentState;
	
	// are these constructors private or public or what?
	DisplayManager(){
	
		this(500, 500);
	}
	
	DisplayManager(int sizeX, int sizeY) {
		gameWindow = new JFrame("Escape");
		
		gameWindow.setResizable(false);
		this.setPreferredSize(new Dimension(sizeX + sizeX/3, sizeY));
		gameWindow.add(this);
		gameWindow.pack();
		gameWindow.setVisible(true);
	    gameWindow.setLocationRelativeTo(null);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		
		imgData = new ImageData();
		this.currentState = GameState.MENU;
		this.repaint();
	}

	public void addKeyListener(KeyListener kl) {
		gameWindow.addKeyListener(kl);
	}
	
	private void dispGame(Graphics2D g2d) {
		dispBoard(g2d);
		dispBonusRewards(g2d);
		dispPunishments(g2d);
		dispObjectiveRewards(g2d);
		dispEnemies(g2d);
		dispMainChar(g2d);
		dispHUD(g2d);
	} 
	
	private void dispHUD(Graphics2D g2d) {
		g2d.setColor(new Color(0.3f, 0.3f, 0.3f, 1.0f));
		g2d.fillRect(sizeX, 0, sizeX/3, sizeY);
		g2d.setColor(new Color(0.8f, 0.2f, 0.2f, 1.0f));
		g2d.fillRect(sizeX + sizeX/20, sizeY/3, sizeX/3 - sizeX/10, sizeY/20);
		g2d.setColor(new Color(0.2f, 0.8f, 0.2f, 1.0f));
		g2d.fillRect(sizeX + sizeX/20, sizeY/3, (int)((sizeX/3 - sizeX/10) * timePercentage), sizeY/20);
		
		g2d.setColor(Color.white);
		Font fnt0 = new Font("arial", Font.BOLD, 20);
		g2d.setFont(fnt0);
		g2d.drawString("Score:  " + Integer.toString(score) ,sizeX + sizeX/20, sizeY/8);
	}
	
	private void dispBoard(Graphics2D g2d) {
		int boardX = this.board.getXSize();
		int boardY = this.board.getYSize();
		this.cellSize = this.board.getCellSize();
		
		for(int y = 0; y < boardY; y++) {
			for(int x = 0; x < boardX; x++) {
				if(this.board.getCellType(x, y) == cellType.OPEN) {
					g2d.setColor(new Color(0.6f, 0.6f, 0.6f, 1.0f));
				}else {
					g2d.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
				}
				g2d.fillRect(x*cellSize, y*cellSize, cellSize, cellSize);
			}
		}
	}
	
	private void dispBonusRewards(Graphics2D g2d) {
		BufferedImage bonusImg = imgData.getBonusImg(); 
		for(int i = 0; i < bonusRewards.size(); i ++) {
			g2d.drawImage(bonusImg, bonusRewards.get(i).getXPos()*cellSize, bonusRewards.get(i).getYPos() * cellSize, cellSize, cellSize,null);
		}
	}
	
	private void dispPunishments(Graphics2D g2d) {
		g2d.setColor(new Color(1.0f, 0.5f, 0.0f, 1.0f));
		BufferedImage img = imgData.getPunishmentImg();
		for(int i = 0; i < punishments.size(); i ++) {
			g2d.drawImage(img, punishments.get(i).getXPos()*cellSize, punishments.get(i).getYPos() * cellSize, cellSize, cellSize, null);
		}
	}
	
	private void dispObjectiveRewards(Graphics2D g2d) {
		BufferedImage objImg = imgData.getObjectImg(); 
		for(int i = 0; i < objectiveRewards.size(); i ++) {
			g2d.drawImage(objImg, objectiveRewards.get(i).getXPos()*cellSize, objectiveRewards.get(i).getYPos() * cellSize, cellSize, cellSize, null);
		}
		BufferedImage goalImg = imgData.getGoalImg(); 
		g2d.drawImage(goalImg, goalX * cellSize, goalY * cellSize, cellSize, cellSize,null);
	}
	
	private void dispEnemies(Graphics2D g2d) {
		BufferedImage enemyImage = imgData.getEnemyImg(); 
		for(int i = 0; i < enemies.size(); i ++) {
			g2d.drawImage(enemyImage, enemies.get(i).getXPos()*cellSize, enemies.get(i).getYPos() * cellSize, cellSize, cellSize, null);
		}
	}
	
	private void dispMainChar(Graphics2D g2d) {
		g2d.drawImage(imgData.getPlayerImg(), mainChar.getXPos()*cellSize, mainChar.getYPos() * cellSize, cellSize, cellSize, null);
	}
	
	//Graphics to Display the Menu Screen
	private void dispMenu(Graphics menu) {
		menu.setColor(Color.black);
		menu.fillRect(0, 0, sizeX + sizeX/3, sizeY);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		menu.setFont(fnt0);
		menu.setColor(Color.red);
		menu.drawString("ESCAPE",100,100);
		Font fnt1 = new Font("arial", Font.BOLD,45);
		menu.setFont(fnt1);
		menu.setColor(Color.blue);
		menu.drawString("Play",100,200);
		menu.drawString("Settings",100,300);
		menu.drawString("Help",100,400);
		menu.setColor(Color.white);
		menu.drawString("(press ENTER to play)",100,600);

	}
	//Graphics to Display the Lose Screen
	private void dispLose(Graphics lose) {
		lose.setColor(Color.black);
		lose.fillRect(0,0,sizeX + sizeX/3,sizeY);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		lose.setFont(fnt0);
		lose.setColor(Color.red);
		lose.drawString("YOU LOSE",100,200);
		
	}
	//Graphics to Display the Win Screen
	private void dispWin(Graphics win) {
		win.setColor(Color.white);
		win.fillRect(0,0,sizeX + sizeX/3,sizeY);
		Font fnt0 = new Font("arial", Font.BOLD, 100);
		win.setFont(fnt0);
		win.setColor(Color.red);
		win.drawString("YOU WIN",100,200);
		
	}

	/**
	 * Changes the current state of game. Called by GameMain.
	 * @param currentState the State to be changed to
	 */
	public void stateChange(GameMain.GameState currentState) {
		this.currentState = currentState;
	}
	
	
	/**
	 * Displays a Board onto the game window.
	 * @param board the board to be displayed
	 */
	public void display(Board board, MainCharacter mainChar, ArrayList<Enemy> enemies, 
						ArrayList<ObjectiveReward> objectiveRewards, ArrayList<Punishment> punishments,
						ArrayList<BonusReward> bonusRewards, int goalX, int goalY, float timePercentage, int score) {
		
		this.cellSize = board.getCellSize();
		
		this.board = board;
		this.bonusRewards = bonusRewards;
		this.punishments = punishments;
		this.objectiveRewards = objectiveRewards;
		this.enemies = enemies;
		this.mainChar = mainChar;
		this.goalX = goalX; this.goalY = goalY;
		this.timePercentage = timePercentage;
		this.score = score;
		
		gameWindow.add(this);
		repaint();
	}
	
	// TODO: add more methods for displaying other objects
	
	/**
	 * does something idk
	 */

	@Override
	public void paint(Graphics g) {
		Graphics menu = (Graphics2D) g;
		Graphics2D g2d = (Graphics2D) g;
		Graphics win = (Graphics2D) g;
		Graphics2D lose = (Graphics2D) g;
		if(currentState ==  GameMain.GameState.GAME) {
			dispGame(g2d);
		}
		else if(currentState == GameMain.GameState.MENU) {
			dispMenu(menu);
		}
		else if(currentState == GameMain.GameState.WIN) {
			dispWin(win);
		}
		else if(currentState == GameMain.GameState.LOSE) {
			dispLose(lose);
		}
        //call more disp funcs here
	}
	
	public static void main(String[] args) {
		
		Board b = new Board();
		MainCharacter mc = new MainCharacter(4, 3);
		ArrayList<Enemy> es = new ArrayList<Enemy>();
		ArrayList<ObjectiveReward> or = new ArrayList<ObjectiveReward>();
		ArrayList<Punishment> pn = new ArrayList<Punishment>();
		ArrayList<BonusReward> br = new ArrayList<BonusReward>();
		
		es.add(new Enemy(3, 12));
		es.add(new Enemy(17, 15));
		es.add(new Enemy(11, 14));

		or.add(new ObjectiveReward(20, 5, 50));
		or.add(new ObjectiveReward(3, 15, 50));
		
		pn.add(new Punishment(9, 8, 100));
		pn.add(new Punishment(12, 17, 100));
		
		br.add(new BonusReward(22, 17, 15, 50));
		br.add(new BonusReward(14, 1, 15, 50));
		
		/*for(int i = 0; i < b.getXSize(); i++) {
			b.setCellType(i, i%5, cellType.BARRIER);
		}*/
		
		//Sample board
		for(int x = 0; x < b.getXSize(); x ++) {
			b.setCellType(x, 0, cellType.BARRIER);
			b.setCellType(x, b.getYSize()-1, cellType.BARRIER);
			b.setCellType(x, (int)b.getYSize()/2, cellType.BARRIER);
		}
		for(int y = 0; y < b.getYSize(); y ++) {
			b.setCellType(0, y, cellType.BARRIER);
			b.setCellType(b.getXSize()-1, y, cellType.BARRIER);
		}
		b.setCellType(b.getXSize()/2, b.getYSize()/2, cellType.OPEN);
		b.setCellType(24, 11, cellType.OPEN);
		
		
		DisplayManager d = new DisplayManager(b.getXSize() * b.getCellSize(), b.getYSize() * b.getCellSize());
		d.stateChange(GameMain.GameState.GAME);
    	d.display(b, mc, es, or, pn, br, 24, 11, 0.76f, 5000);

	}
}
