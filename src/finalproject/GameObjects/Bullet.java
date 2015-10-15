package finalproject.GameObjects;

import finalproject.Modules.*;

public class Bullet extends GameObject {
  
  public Bullet(double xCoord, double yCoord, double zCoord, double r, boolean b) {
    setMoveSpeed(5); // default so far
    setRadius(r);
    setX(xCoord);
    setY(yCoord);
    setZ(zCoord);
    setHostile(b);
    setDirection(getHostile() ? 1 : -1);
    setDeath(false);
  }
  
  public void update() {
    if (!getDeath()) {
        move();
    }
  }
  public void move() {
    setY( this.getY() + 
            getDirection() * getMoveSpeed() * SceneManager.scene.delta
    );
    if (this.getY() < 0) this.setDeath(true);
    if (this.getY() > ImageManager.board.getHeight()) this.setDeath(true);
  }

}
