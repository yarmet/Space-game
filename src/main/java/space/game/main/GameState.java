package space.game.game;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class GameState {
   protected space.game.main.GameManager gm;

   public abstract void init();

   public abstract void update();

   public abstract void draw(Graphics2D var1);

   public abstract void keyPressed(int var1);

   public abstract void keyReleased(int var1);

   public abstract void mousePressed(MouseEvent var1);

   public abstract void mouseReleased(MouseEvent var1);

   public abstract void mouseDragged(MouseEvent var1);

   public abstract void mouseMoved(MouseEvent var1);
}
