package space.game.gamers.Bots;

import space.game.animation.ExplosionAnimations.ExplosionType4;
import space.game.gamers.Player.Gamer;
import space.game.guns.BotGun;
import space.game.primary.GameObject;
import space.game.primary.SpaceShip;
import space.game.game.Display;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BotType3 extends SpaceShip {
    public BotType3(int x, int y) {
        this.x = x;
        this.y = y;
        this.speed = 4.0D;
        this.health = 40;
        this.objectType = 1;

        try {
            this.image = ImageIO.read(this.getClass().getResourceAsStream("/bots/BotType3.png"));
        } catch (IOException var4) {
            var4.printStackTrace();
        }

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
        GameObject.addObject(new ExplosionType4((int) this.x, (int) this.y));
    }
}
