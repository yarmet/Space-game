package space.game.gamers.Bots;

import space.game.animation.ExplosionAnimations.ExplosionType3;
import space.game.gamers.Player.Gamer;
import space.game.guns.BotGun;
import space.game.primary.GameObject;
import space.game.primary.SpaceShip;

import java.awt.Rectangle;
import java.io.IOException;
import javax.imageio.ImageIO;

public class BotType2 extends SpaceShip {
   public BotType2(int x, int y) {
      this.x = x;
      this.y = y;

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/bots/BotType2.png"));
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      this.speed = 4.0D;
      this.objectType = 1;
      this.health = 110;
      this.addnewGun(new BotGun(100));
      this.bodyArea = new Rectangle(x, y, this.image.getWidth(), this.image.getHeight());
   }

   public void update() {
      this.move();
      this.bodyArea.setLocation((int)this.x, (int)this.y);
      if (GameObject.getObject(0) instanceof Gamer) {
         Gamer gamer = (Gamer)GameObject.getObject(0);
         if (space.game.game.Display.BATTLEFIELD.contains(this.x, this.y)) {
            this.weapon.shoot((int)this.x, (int)this.y, gamer.getX(), gamer.getY());
         }
      }

   }

   public void destroy() {
      this.destroyed = true;
      GameObject.addObject(new ExplosionType3((int)this.x, (int)this.y));
   }
}
