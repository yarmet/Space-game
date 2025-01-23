package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.primary.GameObject;

import java.io.IOException;
import javax.imageio.ImageIO;

public class HealthBox extends AbstractBox {
   public HealthBox(double x, double y) {
      super(x, y);
      this.health = 50;

      try {
         this.animationFromFile = ImageIO.read(this.getClass().getResourceAsStream("/healthLent.png"));
      } catch (IOException var6) {
         var6.printStackTrace();
      }

   }

   public void interaction(GameObject object) {
      if (this.intersects(object)) {
         if (object instanceof Gamer) {
            GameObject.getObject(0).upHealth(this.health);
            this.destroy();
         }

      }
   }
}
