package space.game.primary;

public abstract class MaterialObjects extends GameObject {
   public void interaction(GameObject object) {
      if (this.intersects(object) && this.getObjectType() != 2 && object.getObjectType() != 2) {
         if (this.getObjectType() != object.getObjectType()) {
            int hp1 = this.health;
            int hp2 = object.getHealth();
            this.decreaseHealth(hp2);
            object.decreaseHealth(hp1);
         }

      }
   }
}
