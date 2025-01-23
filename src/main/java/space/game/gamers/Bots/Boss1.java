package space.game.gamers.Bots;

import space.game.animation.ExplosionAnimations.ExplosionType2;
import space.game.game.Display;
import space.game.gamers.Player.Gamer;
import space.game.guns.BotGun;
import space.game.primary.GameObject;
import space.game.primary.SpaceShip;
import space.game.util.ImagesLoader;

import java.awt.*;

public class Boss1 extends SpaceShip {
    public Boss1(int x, int y) {
        this.x = x;
        this.y = y;
        this.objectType = 1;
        this.image = ImagesLoader.BOSS.getImage();
        this.speed = 2.0D;
        this.health = 4000;
        this.weapon.addNewGuns(new BotGun(10000));
        this.bodyArea = new Rectangle(x, y, this.image.getWidth(), this.image.getHeight());
    }

    public void update() {
        if (this.x >= (double) (Display.BATTLEFIELD.width / 2)) {
            this.move();
        }

        if (GameObject.getObject(0) instanceof Gamer) {
            Gamer gamer = (Gamer) GameObject.getObject(0);
            if (Display.BATTLEFIELD.contains(this.x, this.y)) {
                this.weapon.shoot((int) this.x + this.image.getWidth() / 2, (int) this.y + this.image.getHeight() / 2, gamer.getX(), gamer.getY());
            }
        }

        this.bodyArea.setLocation((int) this.x, (int) this.y);
    }

    public void destroy() {
        this.destroyed = true;
        GameObject.addObject(new ExplosionType2((int) this.x, (int) this.y));
    }
}
