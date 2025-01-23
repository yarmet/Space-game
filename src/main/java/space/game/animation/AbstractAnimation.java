package space.game.animation;


import space.game.primary.GameObject;

import java.awt.image.BufferedImage;

public class AbstractAnimation extends GameObject {
   protected BufferedImage animationFromFile;
   protected int positionX = 0;
   protected int positionY = 0;
   protected int WIDTH = 0;
   protected int HEIGHT = 0;
   protected int MAX_X = 0;
   protected int MAX_Y = 0;
   private long curentTime = 0L;
   private long previousTime = 0L;
   private long FPS_24 = 42L;

   public AbstractAnimation(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public void update() {
      this.curentTime = System.currentTimeMillis();
      if (this.curentTime - this.previousTime >= this.FPS_24) {
         this.previousTime = this.curentTime;
         this.image = this.animationFromFile.getSubimage(this.positionX++ * this.WIDTH, this.positionY * this.HEIGHT, this.WIDTH, this.HEIGHT);
         if (this.positionX > this.MAX_X) {
            this.positionX = 0;
            ++this.positionY;
         }

         if (this.positionY > this.MAX_Y) {
            this.destroy();
         }

      }
   }
}
