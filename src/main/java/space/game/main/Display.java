package space.game.game;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import javax.swing.JPanel;

public class Display extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
   space.game.main.GameManager gm;
   space.game.main.LogicThread logicThread;
   private Thread thread;
   public static final int X = 1280;
   public static final int Y = 745;
   public static Rectangle BATTLEFIELD = new Rectangle(0, 25, 1280, 745);
   private Graphics2D g;
   private BufferedImage image;
   private static boolean running;
   private int FPS = 60;

   public Display() {
      this.setPreferredSize(new Dimension(1280, 745));
      this.setCursor(Cursor.getPredefinedCursor(1));
      this.setFocusable(true);
      this.requestFocus();
   }

   public void addNotify() {
      this.FPS = 1000 / this.FPS;
      super.addNotify();
      if (this.thread == null) {
         this.thread = new Thread(this);
         this.addKeyListener(this);
         this.addMouseListener(this);
         this.thread.start();
      }

   }

   private void init() {
      this.image = new BufferedImage(1280, 745, 1);
      this.g = (Graphics2D)this.image.getGraphics();
      running = true;
      this.gm = new space.game.main.GameManager();
      this.logicThread = new space.game.main.LogicThread(this.gm);
   }

   public void run() {
      this.init();
      this.addMouseMotionListener(this);

      while(running) {
         long startTime = System.currentTimeMillis();
         this.draw();
         this.drawToScreen();
         long endTime = System.currentTimeMillis() - startTime;
         if (endTime < (long)this.FPS) {
            try {
               Thread.sleep((long)this.FPS - endTime);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }
      }

   }

   private void draw() {
      this.gm.draw(this.g);
   }

   private void drawToScreen() {
      Graphics g2 = this.getGraphics();
      g2.drawImage(this.image, 0, 0, 1280, 745, (ImageObserver)null);
      g2.dispose();
   }

   public void keyPressed(KeyEvent e) {
      this.gm.keyPressed(e.getKeyCode());
   }

   public void keyReleased(KeyEvent e) {
      this.gm.keyReleased(e.getKeyCode());
   }

   public void keyTyped(KeyEvent e) {
   }

   public void mousePressed(MouseEvent e) {
      this.gm.mousePressed(e);
   }

   public void mouseReleased(MouseEvent e) {
      this.gm.mouseReleased(e);
   }

   public void mouseClicked(MouseEvent e) {
   }

   public void mouseEntered(MouseEvent e) {
   }

   public void mouseExited(MouseEvent e) {
   }

   public void mouseDragged(MouseEvent e) {
      this.gm.mouseDragged(e);
   }

   public void mouseMoved(MouseEvent e) {
      this.gm.mouseMoved(e);
   }
}
