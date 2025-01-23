package space.game.animation.ExplosionAnimations;


import space.game.animation.AbstractAnimation;
import space.game.util.ImagesLoader;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ExplosionType2 extends AbstractAnimation {
   public ExplosionType2(int x, int y) {
      super(x, y);
      this.animationFromFile = ImagesLoader.EXPLOSION_TYPE2.getImage();
      this.WIDTH = 96;
      this.HEIGHT = 96;
      this.MAX_X = 4;
      this.MAX_Y = 3;
   }
}
