package space.game.boxes;

import space.game.primary.GameObject;
import space.game.primary.MaterialObjects;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class AbstractBox extends MaterialObjects {
   BufferedImage animationFromFile;
   private long curentTime = 0L;
   private long previousTime = 0L;
   private long FPS_24 = 42L;
   int PositionX = 0;
   int IMAGEWIDTH = 60;

   public AbstractBox(double x, double y) {
      this.x = x;
      this.y = y;
      this.objectType = 2;
      this.bodyArea = new Rectangle((int)x, (int)y, this.IMAGEWIDTH, this.IMAGEWIDTH);
   }

   public abstract void interaction(GameObject var1);

   public void update() {
      this.curentTime = System.currentTimeMillis();
      if (this.curentTime - this.previousTime >= this.FPS_24) {
         this.previousTime = this.curentTime;
         this.image = this.animationFromFile.getSubimage(this.PositionX * this.IMAGEWIDTH, 0, this.IMAGEWIDTH, this.IMAGEWIDTH);
         ++this.PositionX;
         if (this.PositionX > 17) {
            this.PositionX = 0;
         }

         this.x -= 2.0D;
         this.bodyArea.setLocation((int)this.x, (int)this.y);
      }
   }
}
