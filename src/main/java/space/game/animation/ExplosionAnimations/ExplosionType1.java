package space.game.animation.ExplosionAnimations;


import space.game.animation.AbstractAnimation;
import space.game.util.ImagesLoader;

public class ExplosionType1 extends AbstractAnimation {
    public ExplosionType1(int x, int y) {
        super(x, y);
        this.animationFromFile = ImagesLoader.EXPLOSION_TYPE1.getImage();
        this.WIDTH = 96;
        this.HEIGHT = 96;
        this.MAX_X = 4;
        this.MAX_Y = 3;
    }
}
