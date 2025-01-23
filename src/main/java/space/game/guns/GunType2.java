package space.game.guns;

import space.game.util.ImagesLoader;

public class GunType2 extends GunLent {
    public GunType2(int count) {
        super(count);
        this.name = "Gun 2";
        this.rapidityOfFire = 200L;
        this.health = 100;
        this.speed = 30.0D;
        this.objectType = 0;
        this.image = ImagesLoader.GUN_TYPE2.getImage();
    }

    public void update() {
    }
}
