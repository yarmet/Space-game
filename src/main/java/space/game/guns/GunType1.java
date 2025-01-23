package space.game.guns;

import space.game.util.ImagesLoader;

public class GunType1 extends GunLent {
    public GunType1(int count) {
        super(count);
        this.name = "Gun 1";
        this.objectType = 0;
        this.rapidityOfFire = 16L;
        this.health = 10;
        this.speed = 22.0D;
        this.image = ImagesLoader.GUN_TYPE1.getImage();
    }

    public void update() {
    }
}
