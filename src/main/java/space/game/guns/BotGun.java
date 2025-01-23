package space.game.guns;

import space.game.util.ImagesLoader;

public class BotGun extends GunLent {
    public BotGun(int gunCount) {
        super(gunCount);
        this.name = "Bot Gun 2";
        this.rapidityOfFire = 250L;
        this.health = 10;
        this.speed = 10.0D;
        this.objectType = 1;
        this.image = ImagesLoader.BOT_GUN.getImage();
    }


    public void update() {
    }

}
