package space.game.guns;

import space.game.util.ImagesLoader;

public class Laser extends GunLent {
    public Laser(int gunCount) {
        super(gunCount);
        this.name = "Laser";
        this.rapidityOfFire = 160L;
        this.health = 45;
        this.objectType = 0;
        this.image = ImagesLoader.LASER.getImage();
    }

    public void update() {
    }
}
