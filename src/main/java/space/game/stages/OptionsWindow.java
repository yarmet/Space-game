package space.game.stages;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.imageio.ImageIO;

public class OptionsWindow extends space.game.game.GameState {
   private Font font;
   private BufferedImage image;
   private String[] infoText = new String[]{"Работают:  стрелки, WASD, Enter и ESC", "в самой игре добавлена мышка и space", "для переключения текущего вида боезапасов,", "нажми ESC для перехода обратно в меню"};

   public OptionsWindow(space.game.main.GameManager gm) {
      this.gm = gm;
      this.font = new Font("Century Gothic", 0, 30);

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
      g.drawImage(this.image, 0, 15, (ImageObserver)null);
      g.setFont(this.font);
      g.setColor(Color.RED);

      for(int i = 0; i < this.infoText.length; ++i) {
         g.drawString(this.infoText[i], 200, 100 + i * 35);
      }

   }

   public void keyPressed(int k) {
      if (k == 27) {
         this.gm.setState(0);
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
