package com.Group12.Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
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
            playerImg 		= ImageIO.read(getClass().getResource("/player.png"));
            enemyImg 		= ImageIO.read(getClass().getResource("/enemy.png"));
            objectImg 		= ImageIO.read(getClass().getResource("/key.png"));
            punishmentImg 	= ImageIO.read(getClass().getResource("/pul.png"));
            goalImg 		= ImageIO.read(getClass().getResource("/goal.png"));
            bonusImg 		= ImageIO.read(getClass().getResource("/bonus.png"));
            cellImg 		= ImageIO.read(getClass().getResource("/cell.png"));
            boardImg 		= ImageIO.read(getClass().getResource("/board.png"));
            XAxisShoot 		= ImageIO.read(getClass().getResource("/X-Axis shoot.png"));
            YAxisShoot 		= ImageIO.read(getClass().getResource("/Y-Axis shoot.png"));
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
