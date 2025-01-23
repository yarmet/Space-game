package space.game.boxes;

import space.game.gamers.Player.Gamer;
import space.game.primary.GameObject;
import space.game.util.ImagesLoader;

public class HealthBox extends AbstractBox {
    public HealthBox(double x, double y) {
        super(x, y);
        this.health = 50;
        this.animationFromFile = ImagesLoader.HEALTH_LENT.getImage();
    }

    public void interaction(GameObject object) {
        if (this.intersects(object)) {
            if (object instanceof Gamer) {
                GameObject.getObject(0).upHealth(this.health);
                this.destroy();
            }

        }
    }
}
