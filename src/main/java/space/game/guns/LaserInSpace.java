package space.game.guns;

import space.game.primary.GameObject;
import space.game.primary.MaterialObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Iterator;

public class LaserInSpace extends GameObject {
   double dx;
   double dy;

   public LaserInSpace(int x1, int y1, int x2, int y2, GunLent gunType) {
      this.speed = 3.0D;
      this.image = gunType.getImage();
      this.health = gunType.getHealth();
      this.objectType = gunType.getObjectType();
      this.x = x1;
      this.y = y1;
      double atan = Math.atan2((x2 - x1), (y2 - y1));
      this.dy = this.speed * Math.cos(atan);
      this.dx = this.speed * Math.sin(atan);
      this.bodyArea = new Rectangle((int)this.x, (int)this.y, this.image.getWidth(), this.image.getHeight());
   }

   public void update() {
   }

   public void draw(Graphics2D g) {
      do {
         this.x += this.dx;
         this.y += this.dy;
         this.bodyArea.setBounds((int)this.x, (int)this.y, this.image.getWidth(), this.image.getHeight());
         Iterator var2 = GameObject.getAllObjects().iterator();

         while(var2.hasNext()) {
            GameObject object = (GameObject)var2.next();
            if (object instanceof MaterialObjects && object.intersects(this) && object.getObjectType() == 1 && object.getHealth() > 0) {
               int hp1 = object.getHealth();
               int hp2 = this.health;
               object.decreaseHealth(hp2);
               this.decreaseHealth(hp1);
               if (this.health <= 0) {
                  break;
               }
            }
         }

         g.drawImage(this.image, (int)this.x, (int)this.y, null);
      } while(space.game.game.Display.BATTLEFIELD.contains(this.x, this.y) && this.health > 0);

      this.destroy();
   }
}
