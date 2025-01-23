package space.game.guns;

import java.io.IOException;
import javax.imageio.ImageIO;

public class GunType2 extends GunLent {
   public GunType2(int count) {
      super(count);
      this.name = "Gun 2";
      this.rapidityOfFire = 200L;
      this.health = 100;
      this.speed = 30.0D;
      this.objectType = 0;

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/guns/GunType2.png"));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void update() {
   }
}
