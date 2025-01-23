package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.guns.GunType2;
import space.game.primary.GameObject;

import java.io.IOException;
import javax.imageio.ImageIO;

public class GunType2Box extends AbstractBox {
   private long curentTime = 0L;
   private long previousTime = 0L;
   private long FPS_24 = 42L;
   int PositionX = 0;
   int PositionY = 0;
   int IMAGEWIDTH = 60;
   int GunCount = 50;

   public GunType2Box(double x, double y) {
      super(x, y);

      try {
         this.animationFromFile = ImageIO.read(this.getClass().getResourceAsStream("/gunLent2.png"));
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   public void update() {
      this.curentTime = System.currentTimeMillis();
      if (this.curentTime - this.previousTime >= this.FPS_24) {
         this.previousTime = this.curentTime;
         this.image = this.animationFromFile.getSubimage(this.PositionX * this.IMAGEWIDTH, this.PositionY * this.IMAGEWIDTH, this.IMAGEWIDTH, this.IMAGEWIDTH);
         ++this.PositionX;
         if (this.PositionX > 17) {
            this.PositionX = 0;
            ++this.PositionY;
         }

         if (this.PositionY > 1) {
            this.PositionY = 0;
            this.PositionX = 0;
         }

         this.x -= 2.0D;
         this.bodyArea.setLocation((int)this.x, (int)this.y);
      }
   }

   public void interaction(GameObject object) {
      if (this.intersects(object)) {
         if (object instanceof Gamer) {
            Gamer g = (Gamer)GameObject.getObject(0);
            g.addnewGun(new GunType2(this.GunCount));
            this.destroy();
         }

      }
   }
}
