package space.game.primary;

import space.game.gamers.Player.Gamer;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class GameObject {
   private static List<GameObject> objectList = new CopyOnWriteArrayList();
   protected Rectangle bodyArea;
   protected BufferedImage image;
   protected double x;
   protected double y;
   protected double speed = 1.0D;
   protected int objectType = 0;
   protected boolean destroyed = false;
   protected int health = 0;

   public void decreaseHealth(int value) {
      if (value > 0) {
         this.health -= value;
      }

      if (this.health <= 0) {
         this.health = 0;
         this.destroy();
      }

   }

   public void upHealth(int health) {
      if (health > 0) {
         this.health += health;
      }

      if (this.health > 100) {
         this.health = 100;
      }

   }

   public int getHealth() {
      return this.health;
   }

   public BufferedImage getImage() {
      return this.image;
   }

   public void setImage(BufferedImage image) {
      this.image = image;
   }

   public boolean intersects(GameObject object) {
      return this.getBodyArea().intersects(object.getBodyArea());
   }

   public static void addObject(GameObject newObject) {
      objectList.add(newObject);
   }

   public static void removeObject(int index) {
      objectList.remove(index);
   }

   public static List<GameObject> getAllObjects() {
      return objectList;
   }

   public static GameObject getObject(int index) {
      return (GameObject)objectList.get(index);
   }

   public Rectangle getBodyArea() {
      return this.bodyArea;
   }

   public void destroy() {
      this.destroyed = true;
   }

   public boolean isDestroyed() {
      return this.destroyed;
   }

   public int getY() {
      return (int)this.y;
   }

   public void interaction(GameObject object) {
   }

   public int getX() {
      return (int)this.x;
   }

   public abstract void update();

   public int getObjectType() {
      return this.objectType;
   }

   public int getSpeed() {
      return (int)this.speed;
   }

   public void draw(Graphics2D g) {
      g.drawImage(this.image, (int)this.x, (int)this.y, (ImageObserver)null);
   }

   static {
      objectList.add(new Gamer());
   }
}
