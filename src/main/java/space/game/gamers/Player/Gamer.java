package space.game.gamers.Player;

import space.game.animation.ExplosionAnimations.ExplosionType1;
import space.game.animation.GamerAnimation;
import space.game.guns.GunType2;
import space.game.primary.GameObject;
import space.game.primary.SpaceShip;
import space.game.main.Display;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Gamer extends SpaceShip {
    private int mouseX = 1100;
    private int mouseY = 300;
    private boolean left = false;
    private boolean up = false;
    private boolean right = false;
    private boolean down = false;
    protected boolean shoot = false;
    private GamerAnimation animation = new GamerAnimation(this);

    public int getMouseX() {
        return this.mouseX;
    }

    public int getMouseY() {
        return this.mouseY;
    }

    public Gamer() {
        this.weapon.addNewGuns(new GunType2(100));
        this.objectType = 0;
        this.x = 100.0D;
        this.y = 100.0D;
        this.health = 100;
        this.speed = 16.0D;
        this.bodyArea = new Rectangle((int) this.x, (int) this.y, this.image.getWidth(), this.image.getHeight());
    }

    public void update() {
        this.changePosition();
        this.checkMove();
        this.animation.update();
        this.bodyArea.setBounds((int) this.x, (int) this.y, this.image.getWidth(), this.image.getHeight());
        if (this.shoot) {
            this.weapon.shoot((int) this.x + this.animation.getGunStartPoint().x, (int) this.y + this.animation.getGunStartPoint().y, this.mouseX - 5, this.mouseY - 5);
        }

    }

    public void destroy() {
        this.destroyed = true;
        GameObject.addObject(new ExplosionType1((int) this.x, (int) this.y));
    }

    private void checkMove() {
        if (this.x > (Display.BATTLEFIELD.width - this.image.getWidth())) {
            this.x = (Display.BATTLEFIELD.width - this.image.getWidth());
        }

        if (this.x < Display.BATTLEFIELD.x) {
            this.x = Display.BATTLEFIELD.x;
        }

        if (this.y > (Display.BATTLEFIELD.height - this.image.getHeight())) {
            this.y = (Display.BATTLEFIELD.height - this.image.getHeight());
        }

        if (this.y < Display.BATTLEFIELD.y) {
            this.y = Display.BATTLEFIELD.y;
        }

    }

    public void keyPressed(int k) {
        if (k == 27) {
            System.exit(0);
        }

        if (k == 40 || k == 83) {
            this.down = true;
        }

        if (k == 38 || k == 87) {
            this.up = true;
        }

        if (k == 37 || k == 65) {
            this.left = true;
        }

        if (k == 39 || k == 68) {
            this.right = true;
        }

        if (k == 32) {
            this.weapon.changeCurentGun();
        }

    }

    public void keyReleased(int k) {
        if (k == 40 || k == 83) {
            this.down = false;
        }

        if (k == 38 || k == 87) {
            this.up = false;
        }

        if (k == 37 || k == 65) {
            this.left = false;
        }

        if (k == 39 || k == 68) {
            this.right = false;
        }

    }

    public void mousePressed(MouseEvent e) {
        this.shoot = true;
    }

    public void mouseReleased(MouseEvent e) {
        this.shoot = false;
    }

    public void getMousePoint(MouseEvent e) {
        this.mouseX = e.getX();
        this.mouseY = e.getY();
    }

    public void mouseDragged(MouseEvent e) {
        this.getMousePoint(e);
    }

    public void mouseMoved(MouseEvent e) {
        this.getMousePoint(e);
    }

    private void changePosition() {
        if (this.left) {
            this.x -= this.speed;
        }

        if (this.up) {
            this.y -= this.speed;
        }

        if (this.right) {
            this.x += this.speed;
        }

        if (this.down) {
            this.y += this.speed;
        }

    }
}
