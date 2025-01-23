package space.game.animation;


import space.game.gamers.Player.Gamer;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GamerAnimation {
   private Point point;
   Gamer gamer;
   protected BufferedImage rightUpIMG;
   protected BufferedImage rightIMG;
   protected BufferedImage rightDownIMG;
   protected BufferedImage leftDownIMG;
   protected BufferedImage leftIMG;
   protected BufferedImage leftUpIMG;
   protected BufferedImage previousIMG;
   protected BufferedImage imageFromFile;
   int dx = 0;
   int dy = 0;

   public GamerAnimation(Gamer gamer) {
      this.gamer = gamer;

      try {
         this.point = new Point();
         this.imageFromFile = ImageIO.read(this.getClass().getResourceAsStream("/player/player.png"));
         this.rightUpIMG = this.imageFromFile.getSubimage(389, 4, 91, 51);
         this.rightIMG = this.imageFromFile.getSubimage(103, 11, 98, 35);
         this.rightDownIMG = this.imageFromFile.getSubimage(481, 1, 88, 58);
         this.leftDownIMG = this.imageFromFile.getSubimage(297, 1, 88, 58);
         this.leftIMG = this.imageFromFile.getSubimage(2, 11, 98, 35);
         this.leftUpIMG = this.imageFromFile.getSubimage(205, 4, 91, 51);
         gamer.setImage(this.rightIMG);
         this.previousIMG = this.leftIMG;
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public Point getGunStartPoint() {
      if (this.gamer.getImage().equals(this.rightIMG)) {
         this.point.setLocation(97, 19);
      }

      if (this.gamer.getImage().equals(this.rightUpIMG)) {
         this.point.setLocation(94, -15);
      }

      if (this.gamer.getImage().equals(this.rightDownIMG)) {
         this.point.setLocation(90, 55);
      }

      if (this.gamer.getImage().equals(this.leftIMG)) {
         this.point.setLocation(-5, 15);
      }

      if (this.gamer.getImage().equals(this.leftDownIMG)) {
         this.point.setLocation(-10, 50);
      }

      if (this.gamer.getImage().equals(this.leftUpIMG)) {
         this.point.setLocation(-10, -15);
      }

      return this.point;
   }

   public void update() {
      this.dx = Math.abs(this.gamer.getMouseX() - this.gamer.getX());
      this.dy = Math.abs(this.gamer.getMouseY() - this.gamer.getY());
      if (this.gamer.getX() < this.gamer.getMouseX()) {
         if (this.dy > this.dx) {
            if (this.gamer.getMouseY() < this.gamer.getY()) {
               this.gamer.setImage(this.rightUpIMG);
            } else {
               this.gamer.setImage(this.rightDownIMG);
            }
         } else {
            this.gamer.setImage(this.rightIMG);
         }
      } else if (this.dy > this.dx) {
         if (this.gamer.getMouseY() < this.gamer.getY()) {
            this.gamer.setImage(this.leftUpIMG);
         } else {
            this.gamer.setImage(this.leftDownIMG);
         }
      } else {
         this.gamer.setImage(this.leftIMG);
      }

   }
}
