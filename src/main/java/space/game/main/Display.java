package space.game.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Display extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener {
    space.game.main.GameManager gm;
    space.game.main.LogicThread logicThread;
    private Thread thread;
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
        this.g = (Graphics2D) this.image.getGraphics();
        running = true;
        this.gm = new GameManager();
        this.logicThread = new LogicThread(this.gm);
    }

    public void run() {
        this.init();
        this.addMouseMotionListener(this);

        while (running) {
            long startTime = System.currentTimeMillis();
            this.draw();
            this.drawToScreen();
            long endTime = System.currentTimeMillis() - startTime;
            if (endTime < (long) this.FPS) {
                try {
                    Thread.sleep((long) this.FPS - endTime);
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
        g2.drawImage(this.image, 0, 0, 1280, 745, null);
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
