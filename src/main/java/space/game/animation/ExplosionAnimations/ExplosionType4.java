package space.game.animation.ExplosionAnimations;


import space.game.animation.AbstractAnimation;
import space.game.util.ImagesLoader;

import java.io.IOException;
import javax.imageio.ImageIO;

public class ExplosionType4 extends AbstractAnimation {
    public ExplosionType4(int x, int y) {
        super(x, y);
        this.animationFromFile = ImagesLoader.EXPLOSION_TYPE4.getImage();
        this.WIDTH = 96;
        this.HEIGHT = 96;
        this.MAX_X = 4;
        this.MAX_Y = 2;
    }
}
