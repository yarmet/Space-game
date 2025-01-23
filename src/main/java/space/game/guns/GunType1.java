package space.game.guns;

import java.io.IOException;
import javax.imageio.ImageIO;

public class GunType1 extends GunLent {
   public GunType1(int count) {
      super(count);
      this.name = "Gun 1";
      this.objectType = 0;
      this.rapidityOfFire = 16L;
      this.health = 10;
      this.speed = 22.0D;

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/guns/GunType1.png"));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void update() {
   }
}
