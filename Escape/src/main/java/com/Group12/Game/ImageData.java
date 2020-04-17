package com.Group12.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * Handles graphical display.
 * @author Yuxi Hu
 *
 */
public class ImageData {

	private BufferedImage playerImg;
	private BufferedImage enemyImg;
	private BufferedImage punishmentImg;
	private BufferedImage objectImg;
	private BufferedImage goalImg;
	private BufferedImage bonusImg;
	private BufferedImage cellImg;
	private BufferedImage boardImg;
	private BufferedImage XAxisShoot;
	private BufferedImage YAxisShoot;
	public ImageData() {
		try {
			System.out.println(System.getProperty("user.dir"));
            playerImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/player.png"));
            enemyImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/enemy.png"));
            objectImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/key.png"));
            punishmentImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/pul.png"));
            goalImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/goal.png"));
            bonusImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/bonus.png"));
            cellImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/cell.png"));
            boardImg = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/board.png"));
            XAxisShoot = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/X-Axis shoot.png"));
            YAxisShoot = ImageIO.read(new File(System.getProperty("user.dir") + "/src/main/resources/Y-Axis shoot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getPlayerImg() {
		return this.playerImg;
	}
	
	public BufferedImage getEnemyImg() {
		return this.enemyImg;
	}
	
	public BufferedImage getPunishmentImg() {
		return this.punishmentImg;
	}
	
	public BufferedImage getObjectImg() {
		return this.objectImg;
	}
	
	public BufferedImage getGoalImg() {
		return this.goalImg;
	}
	
	public BufferedImage getBonusImg() {
		return this.bonusImg;
	}
	
	public BufferedImage getCellImg() {
		return this.cellImg;
	}
	
	public BufferedImage getBoardImg() {
		return this.boardImg;
	}
	public BufferedImage getXAxisImg() {
		return this.XAxisShoot;
	}
	public BufferedImage getYAxisImg() {
		return this.YAxisShoot;
	}
}
