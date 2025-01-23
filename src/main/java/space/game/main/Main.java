package space.game.main;

import javax.swing.JFrame;

public class Main extends JFrame {
   void start() {
      JFrame window = new JFrame("Space");
      window.setContentPane(new space.game.game.Display());
      window.setDefaultCloseOperation(3);
      window.setResizable(false);
      window.pack();
      window.setVisible(true);
   }

   public static void main(String[] args) {
      (new Main()).start();
   }
}
