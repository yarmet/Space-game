package space.game.primary;


import space.game.guns.GunLent;
import space.game.guns.Weapon;

public abstract class SpaceShip extends MaterialObjects {
   protected Weapon weapon = new Weapon(this);

   public String getCurentGunType() {
      return this.weapon.getCurentGunName();
   }

   public int getCurentGunCount() {
      return this.weapon.getCurentGunCount();
   }

   public void addnewGun(GunLent newGun) {
      this.weapon.addNewGuns(newGun);
   }

   public void move() {
      this.x -= this.speed;
      if (this.x < -50.0D) {
         this.destroyed = true;
      }

   }
}
