package space.game.stages;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;

public class Space {
   private BufferedImage spaceLayer1;
   private BufferedImage spaceLayer2;
   private double spaceX = 0.0D;

   public Space() {
      try {
         this.spaceLayer1 = ImageIO.read(this.getClass().getResourceAsStream("/space.jpg"));
         this.spaceLayer2 = this.spaceLayer1;
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void update() {
      --this.spaceX;
      if (this.spaceX < -1280.0D) {
         this.spaceX = 0.0D;
      }

   }

   public void draw(Graphics2D g) {
      g.setColor(Color.DARK_GRAY);
      g.drawImage(this.spaceLayer1, (int)this.spaceX, space.game.game.Display.BATTLEFIELD.y, (ImageObserver)null);
      g.drawImage(this.spaceLayer2, (int)this.spaceX + 1280, space.game.game.Display.BATTLEFIELD.y, (ImageObserver)null);
      g.fillRect(0, 0, space.game.game.Display.BATTLEFIELD.width, space.game.game.Display.BATTLEFIELD.y);
   }
}
