package space.game.main;

import space.game.gamers.Player.Gamer;
import space.game.primary.GameObject;
import space.game.primary.MaterialObjects;
import space.game.primary.SpaceShip;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Iterator;

public class ObjectManager {
   private int PLAYER = 0;
   int pos = 0;
   Font font = new Font("TimesRoman", 0, 17);
   Font font2 = new Font("TimesRoman", 0, 100);

   public void update() {
      this.testColision();
      this.pos = 0;

      while(this.pos < GameObject.getAllObjects().size()) {
         GameObject object = GameObject.getObject(this.pos);
         if (object.isDestroyed()) {
            GameObject.removeObject(this.pos);
         } else {
            object.update();
            ++this.pos;
         }
      }

   }

   public Gamer getPlayer() {
      return (Gamer)GameObject.getObject(this.PLAYER);
   }

   public void draw(Graphics2D g) {
      Iterator var2 = GameObject.getAllObjects().iterator();

      while(var2.hasNext()) {
         GameObject obj = (GameObject)var2.next();
         obj.draw(g);
      }

      if (GameObject.getObject(this.PLAYER) instanceof Gamer) {
         SpaceShip firstSpaceship = (SpaceShip)GameObject.getObject(this.PLAYER);
         g.setFont(this.font);
         g.setColor(Color.green);
         g.drawString("Objects " + GameObject.getAllObjects().size(), 1100, 20);
         g.drawString("HEALTH " + firstSpaceship.getHealth(), 20, 20);
         g.drawString("Gun type : " + firstSpaceship.getCurentGunType(), 300, 20);
         g.drawString("count : " + firstSpaceship.getCurentGunCount(), 450, 20);
      } else {
         g.setColor(Color.red);
         g.setFont(this.font2);
         g.drawString("Game Over", 420, 360);
      }

   }

   private void testColision() {
      Iterator var1 = GameObject.getAllObjects().iterator();

      while(true) {
         GameObject object1;
         do {
            if (!var1.hasNext()) {
               return;
            }

            object1 = (GameObject)var1.next();
         } while(!(object1 instanceof MaterialObjects));

         Iterator var3 = GameObject.getAllObjects().iterator();

         while(var3.hasNext()) {
            GameObject object2 = (GameObject)var3.next();
            if (object2 instanceof MaterialObjects) {
               object1.interaction(object2);
            }
         }
      }
   }
}
