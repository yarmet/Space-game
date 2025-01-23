package space.game.animation.ExplosionAnimations;


import space.game.animation.AbstractAnimation;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ExplosionType4 extends AbstractAnimation {
   public ExplosionType4(int x, int y) {
      super(x, y);

      try {
         this.animationFromFile = ImageIO.read(this.getClass().getResourceAsStream("/bum4.png"));
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      this.WIDTH = 96;
      this.HEIGHT = 96;
      this.MAX_X = 4;
      this.MAX_Y = 2;
   }
}
