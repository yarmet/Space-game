package space.game.guns;

import space.game.primary.MaterialObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

public class GunsInSpace extends MaterialObjects {
   double dx;
   double dy;

   public GunsInSpace(int x1, int y1, int x2, int y2, GunLent gunType) {
      this.image = gunType.getImage();
      this.health = gunType.getHealth();
      this.objectType = gunType.getObjectType();
      this.speed = gunType.getSpeed();
      this.x = x1;
      this.y = y1;
      double atan = Math.atan2((x2 - x1), (y2 - y1));
      this.dy = this.speed * Math.cos(atan);
      this.dx = this.speed * Math.sin(atan);
      this.bodyArea = new Rectangle((int)this.x, (int)this.y, this.image.getWidth(), this.image.getHeight());
   }

   public void update() {
      this.x += this.dx;
      this.y += this.dy;
      if (!space.game.game.Display.BATTLEFIELD.contains(this.x, this.y) || this.health <= 0) {
         this.destroy();
      }

      this.bodyArea.setBounds((int)this.x, (int)this.y, this.image.getWidth(), this.image.getHeight());
   }

   public void draw(Graphics2D g) {
      g.drawImage(this.image, (int)this.x, (int)this.y, (ImageObserver)null);
   }

   public int getX() {
      return (int)this.x;
   }

   public int getY() {
      return (int)this.y;
   }
}
