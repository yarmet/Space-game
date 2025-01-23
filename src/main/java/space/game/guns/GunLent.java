package space.game.guns;


import space.game.primary.GameObject;

public abstract class GunLent extends GameObject {
   protected String name = "default";
   protected int gunCount = 0;
   protected long rapidityOfFire = 0L;

   public GunLent(int gunCount) {
      this.gunCount = gunCount;
   }

   public String getName() {
      return this.name;
   }

   public void addMoreGuns(int newGunCount) {
      if (newGunCount > 0) {
         this.gunCount += newGunCount;
      }

   }

   public int getSpeed() {
      return (int)this.speed;
   }

   public void decreaseCount() {
      --this.gunCount;
   }

   public int getGunCount() {
      return this.gunCount;
   }
}
