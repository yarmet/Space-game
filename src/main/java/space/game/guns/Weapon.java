package space.game.guns;

import space.game.primary.GameObject;
import space.game.primary.SpaceShip;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
   private List<GunLent> personalGuns = new ArrayList();
   private int selectedGun = 0;
   protected long rapidityOfFire = 0L;
   protected long curentTime = 0L;
   protected long previousTime = 0L;
   public SpaceShip spaceShip;

   public Weapon(SpaceShip player) {
      this.spaceShip = player;
   }

   public void shoot(int x, int y, int mouseX, int mouseY) {
      GunLent gunLent = this.personalGuns.get(this.selectedGun);
      this.curentTime = System.currentTimeMillis();
      this.rapidityOfFire = gunLent.rapidityOfFire;
      if (this.curentTime - this.previousTime >= this.rapidityOfFire && gunLent.gunCount > 0) {
         if (gunLent instanceof Laser) {
            GameObject.addObject(new LaserInSpace(x, y, mouseX, mouseY, gunLent));
         } else {
            GameObject.addObject(new GunsInSpace(x, y, mouseX, mouseY, gunLent));
         }

         this.previousTime = this.curentTime;
         gunLent.decreaseCount();
      }
   }

   public void changeCurentGun() {
      if (this.selectedGun < this.personalGuns.size() - 1) {
         ++this.selectedGun;
      } else {
         this.selectedGun = 0;
      }

   }

   public void addNewGuns(GunLent newGun) {
      boolean gunAlreadyExist = false;
      int index = 0;

      int count;
      for(count = 0; count < this.personalGuns.size(); ++count) {
         if ((this.personalGuns.get(count)).getName().equals(newGun.getName())) {
            gunAlreadyExist = true;
            index = count;
            break;
         }
      }

      if (gunAlreadyExist) {
         count = (this.personalGuns.get(index)).getGunCount();
         newGun.addMoreGuns(count);
         this.personalGuns.set(index, newGun);
      } else {
         this.personalGuns.add(newGun);
      }

   }

   public int getCurentGunCount() {
      return (this.personalGuns.get(this.selectedGun)).getGunCount();
   }

   public String getCurentGunName() {
      return (this.personalGuns.get(this.selectedGun)).getName();
   }
}
