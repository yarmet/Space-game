package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.guns.Laser;
import space.game.primary.GameObject;
import space.game.util.ImagesLoader;

public class LaserBox extends AbstractBox {
    int laserGunCount = 50;

    public LaserBox(double x, double y) {
        super(x, y);
        this.animationFromFile = ImagesLoader.LASER_LENT.getImage();
    }

    public void interaction(GameObject object) {
        if (this.intersects(object)) {
            if (object instanceof Gamer) {
                Gamer g = (Gamer) GameObject.getObject(0);
                g.addnewGun(new Laser(this.laserGunCount));
                this.destroy();
            }

        }
    }
}
