package space.game.main;

import space.game.stages.Menu;
import space.game.stages.OptionsWindow;
import space.game.stages.Stage1;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameManager {
   ArrayList<space.game.game.GameState> gameState = new ArrayList();
   public static final int MENU = 0;
   public static final int STAGE1 = 1;
   public static final int CONTROLINFO = 2;
   private int currentStage = 0;

   public GameManager() {
      this.gameState.add(new Menu(this));
      this.gameState.add(new Stage1(this));
      this.gameState.add(new OptionsWindow(this));
   }

   public void setState(int state) {
      this.currentStage = state;
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).init();
   }

   public synchronized void update() {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).update();
   }

   public synchronized void draw(Graphics2D g) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).draw(g);
   }

   public void keyPressed(int code) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).keyPressed(code);
   }

   public void keyReleased(int code) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).keyReleased(code);
   }

   public void mousePressed(MouseEvent e) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).mousePressed(e);
   }

   public void mouseReleased(MouseEvent e) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).mouseReleased(e);
   }

   public void mouseDragged(MouseEvent e) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).mouseDragged(e);
   }

   public void mouseMoved(MouseEvent e) {
      ((space.game.game.GameState)this.gameState.get(this.currentStage)).mouseMoved(e);
   }
}
