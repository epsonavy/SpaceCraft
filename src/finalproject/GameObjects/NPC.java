package finalproject.GameObjects;

import finalproject.Modules.ImageManager;
import finalproject.Modules.SceneManager;

public class NPC extends GameObject {
  
  public NPC(double xCoord, double yCoord, double zCoord, double r, boolean b) {
    setMoveSpeed(2); // default so far
    setRadius(r);
    setX(xCoord);
    setY(yCoord);
    setZ(zCoord);
    setHostile(b);
    setDirection(1);
    setDeath(false);
  }
  
  public void update() {
    if (!getDeath()) {
        move();
    }
  }
  public void resetCollideHostile() {
    // do nothing
  }
  public void move() {
    if (this.getX() > ImageManager.board.getWidth() - ImageManager.grabImage(this).getWidth(null))
        setX(ImageManager.board.getWidth() - ImageManager.grabImage(this).getWidth(null));
    setY( this.getY() + 
            getDirection() * getMoveSpeed() * SceneManager.scene.delta
    );
    if (this.getY() > ImageManager.board.getHeight()) this.setDeath(true);
  }
    
}
