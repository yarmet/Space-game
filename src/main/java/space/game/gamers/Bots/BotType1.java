package space.game.gamers.Bots;


import space.game.animation.ExplosionAnimations.ExplosionType2;
import space.game.main.Display;
import space.game.gamers.Player.Gamer;
import space.game.guns.BotGun;
import space.game.primary.GameObject;
import space.game.primary.SpaceShip;
import space.game.util.ImagesLoader;

import java.awt.*;

public class BotType1 extends SpaceShip {
    public BotType1(int x, int y) {
        this.x = x;
        this.y = y;
        this.image = ImagesLoader.BOT_TYPE1.getImage();
        this.objectType = 1;
        this.speed = 4.0D;
        this.health = 100;
        this.addnewGun(new BotGun(100));
        this.bodyArea = new Rectangle(x, y, this.image.getWidth(), this.image.getHeight());
    }

    public void update() {
        this.move();
        this.bodyArea.setLocation((int) this.x, (int) this.y);
        if (GameObject.getObject(0) instanceof Gamer) {
            Gamer gamer = (Gamer) GameObject.getObject(0);
            if (Display.BATTLEFIELD.contains(this.x, this.y)) {
                this.weapon.shoot((int) this.x, (int) this.y, gamer.getX(), gamer.getY());
            }
        }

    }

    public void destroy() {
        this.destroyed = true;
        GameObject.addObject(new ExplosionType2((int) this.x, (int) this.y));
    }
}
