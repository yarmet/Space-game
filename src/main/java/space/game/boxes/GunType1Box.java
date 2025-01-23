package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.guns.GunType1;
import space.game.primary.GameObject;

import java.io.IOException;
import javax.imageio.ImageIO;

public class GunType1Box extends AbstractBox {
   int GunCount = 350;

   public GunType1Box(double x, double y) {
      super(x, y);

      try {
         this.animationFromFile = ImageIO.read(this.getClass().getResourceAsStream("/gunLent.png"));
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   public void interaction(GameObject object) {
      if (this.intersects(object)) {
         if (object instanceof Gamer) {
            Gamer g = (Gamer)GameObject.getObject(0);
            g.addnewGun(new GunType1(this.GunCount));
            this.destroy();
         }

      }
   }
}
