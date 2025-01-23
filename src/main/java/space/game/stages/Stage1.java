package space.game.stages;

import space.game.boxes.GunType1Box;
import space.game.boxes.GunType2Box;
import space.game.boxes.HealthBox;
import space.game.boxes.LaserBox;
import space.game.gamers.Bots.Boss1;
import space.game.gamers.Bots.BotType1;
import space.game.gamers.Bots.BotType2;
import space.game.gamers.Bots.BotType3;
import space.game.primary.GameObject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Stage1 extends space.game.game.GameState implements Runnable {
   private Space space;
   space.game.game.ObjectManager objectManager = new space.game.game.ObjectManager();
   Random random = new Random();
   Font font = new Font("TimesRoman", 0, 100);
   Boss1 boss1 = new Boss1(1300, 300);

   public Stage1(space.game.main.GameManager gm) {
      this.gm = gm;
      this.space = new Space();
   }

   public void init() {
      (new Thread(this)).start();
   }

   public void update() {
      this.space.update();
      this.objectManager.update();
   }

   public void draw(Graphics2D g) {
      this.space.draw(g);
      this.objectManager.draw(g);
      if (this.boss1.isDestroyed()) {
         g.setFont(this.font);
         g.setColor(Color.green);
         g.drawString("Stage clear", 420, 360);
      }

   }

   public void keyPressed(int k) {
      this.objectManager.getPlayer().keyPressed(k);
   }

   public void keyReleased(int k) {
      this.objectManager.getPlayer().keyReleased(k);
   }

   public void mousePressed(MouseEvent e) {
      this.objectManager.getPlayer().mousePressed(e);
   }

   public void mouseReleased(MouseEvent e) {
      this.objectManager.getPlayer().mouseReleased(e);
   }

   public void mouseDragged(MouseEvent e) {
      this.objectManager.getPlayer().mouseDragged(e);
   }

   public void mouseMoved(MouseEvent e) {
      this.objectManager.getPlayer().mouseMoved(e);
   }

   public void addRandomBot() {
      int t = this.random.nextInt(3);
      if (t == 0) {
         GameObject.addObject(new BotType1(1300, 50 + this.random.nextInt(600)));
      }

      if (t == 1) {
         GameObject.addObject(new BotType2(1300, 50 + this.random.nextInt(600)));
      }

      if (t == 2) {
         GameObject.addObject(new BotType3(1300, 50 + this.random.nextInt(600)));
      }

   }

   public void addRandomEquipment() {
      int t = this.random.nextInt(4);
      if (t == 0) {
         GameObject.addObject(new HealthBox(1300.0D, (double)(50 + this.random.nextInt(600))));
      }

      if (t == 1) {
         GameObject.addObject(new GunType1Box(1300.0D, (double)(50 + this.random.nextInt(600))));
      }

      if (t == 2) {
         GameObject.addObject(new GunType2Box(1300.0D, (double)(50 + this.random.nextInt(600))));
      }

      if (t == 3) {
         GameObject.addObject(new LaserBox(1300.0D, (double)(50 + this.random.nextInt(600))));
      }

   }

   public void run() {
      for(int i = 0; i < 100; ++i) {
         try {
            Thread.sleep(1100L);
         } catch (InterruptedException var3) {
            var3.printStackTrace();
         }

         int type = this.random.nextInt(40);
         if (type > 34) {
            this.addRandomEquipment();
         } else {
            this.addRandomBot();
         }
      }

      GameObject.addObject(this.boss1);
   }
}
