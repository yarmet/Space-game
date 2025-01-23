package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.guns.Laser;
import space.game.primary.GameObject;

import java.io.IOException;
import javax.imageio.ImageIO;

public class LaserBox extends AbstractBox {
   int laserGunCount = 50;

   public LaserBox(double x, double y) {
      super(x, y);

      try {
         this.animationFromFile = ImageIO.read(this.getClass().getResourceAsStream("/laserLent.png"));
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   public void interaction(GameObject object) {
      if (this.intersects(object)) {
         if (object instanceof Gamer) {
            Gamer g = (Gamer)GameObject.getObject(0);
            g.addnewGun(new Laser(this.laserGunCount));
            this.destroy();
         }

      }
   }
}
