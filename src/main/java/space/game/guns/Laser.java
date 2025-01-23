package space.game.guns;

import java.io.IOException;
import javax.imageio.ImageIO;

public class Laser extends GunLent {
   public Laser(int gunCount) {
      super(gunCount);
      this.name = "Laser";
      this.rapidityOfFire = 160L;
      this.health = 45;
      this.objectType = 0;

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/guns/laser/whiteLaser.png"));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void update() {
   }
}
