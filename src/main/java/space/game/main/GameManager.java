package space.game.main;

import space.game.stages.Menu;
import space.game.stages.OptionsWindow;
import space.game.stages.Stage1;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameManager {
   ArrayList<space.game.game.GameState> gameState = new ArrayList();
   private int currentStage = 0;

   public GameManager() {
      this.gameState.add(new Menu(this));
      this.gameState.add(new Stage1(this));
      this.gameState.add(new OptionsWindow(this));
   }

   public void setState(int state) {
      this.currentStage = state;
      (this.gameState.get(this.currentStage)).init();
   }

   public synchronized void update() {
      this.gameState.get(this.currentStage).update();
   }

   public synchronized void draw(Graphics2D g) {
      this.gameState.get(this.currentStage).draw(g);
   }

   public void keyPressed(int code) {
     this.gameState.get(this.currentStage).keyPressed(code);
   }

   public void keyReleased(int code) {
      this.gameState.get(this.currentStage).keyReleased(code);
   }

   public void mousePressed(MouseEvent e) {
      this.gameState.get(this.currentStage).mousePressed(e);
   }

   public void mouseReleased(MouseEvent e) {
     this.gameState.get(this.currentStage).mouseReleased(e);
   }

   public void mouseDragged(MouseEvent e) {
      this.gameState.get(this.currentStage).mouseDragged(e);
   }

   public void mouseMoved(MouseEvent e) {
      this.gameState.get(this.currentStage).mouseMoved(e);
   }
}
