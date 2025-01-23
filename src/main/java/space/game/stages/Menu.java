package space.game.stages;

import space.game.main.GameState;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Menu extends GameState {
   private Font menuFont;
   private BufferedImage image;
   private String[] menu = new String[]{"начать", "управление", "выйти"};
   private int selectedMenu = 0;

   public Menu(space.game.main.GameManager gm) {
      this.gm = gm;
      this.menuFont = new Font("Century Gothic", 0, 48);

      try {
         this.image = ImageIO.read(this.getClass().getResourceAsStream("/spaceMenu.jpg"));
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public void init() {
   }

   public void update() {
   }

   public void draw(Graphics2D g) {
      g.drawImage(this.image, 0, 15, null);
      g.setFont(this.menuFont);

      for(int i = 0; i < this.menu.length; ++i) {
         if (i == this.selectedMenu) {
            g.setColor(Color.RED);
         } else {
            g.setColor(Color.BLUE);
         }

         g.drawString(this.menu[i], 550, 300 + 55 * i);
      }

   }

   void select() {
      if (this.selectedMenu == 0) {
         this.gm.setState(1);
      }

      if (this.selectedMenu == 1) {
         this.gm.setState(2);
      }

      if (this.selectedMenu == 2) {
         System.exit(0);
      }

   }

   public void keyPressed(int k) {
      if (k == 27) {
         System.exit(0);
      }

      if (k == 10) {
         this.select();
      }

      if (k == 38 || k == 87) {
         --this.selectedMenu;
         if (this.selectedMenu == -1) {
            this.selectedMenu = this.menu.length - 1;
         }
      }

      if (k == 40 || k == 83) {
         ++this.selectedMenu;
         if (this.selectedMenu == this.menu.length) {
            this.selectedMenu = 0;
         }
      }

   }

   public void keyReleased(int k) {
   }

   public void mousePressed(MouseEvent e) {
   }

   public void mouseReleased(MouseEvent e) {
   }

   public void mouseDragged(MouseEvent e) {
   }

   public void mouseMoved(MouseEvent e) {
   }
}
