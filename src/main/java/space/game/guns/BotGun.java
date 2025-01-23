package space.game.guns;

import java.io.IOException;
import javax.imageio.ImageIO;

public class BotGun extends GunLent {
   public BotGun(int gunCount) {
      super(gunCount);
      this.name = "Bot Gun 2";
      this.rapidityOfFire = 250L;
      this.health = 10;
      this.speed = 10.0D;
      this.objectType = 1;

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/guns/GunType2.png"));
      } catch (IOException var3) {
         var3.printStackTrace();
      }

   }

   public void update() {
   }
}
