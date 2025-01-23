package space.game.main;

public class LogicThread implements Runnable {
   GameManager manager;
   private int RUNSPEED = 60;

   public LogicThread(GameManager manager) {
      this.manager = manager;
      this.RUNSPEED = 1000 / this.RUNSPEED;
      (new Thread(this)).start();
   }

   public void run() {
      while(true) {
         long start = System.currentTimeMillis();
         this.update();
         long end = System.currentTimeMillis() - start;
         if (end < (long)this.RUNSPEED) {
            try {
               Thread.sleep((long)this.RUNSPEED - end);
            } catch (Exception var6) {
               var6.printStackTrace();
            }
         }
      }
   }

   public void update() {
      this.manager.update();
   }
}
