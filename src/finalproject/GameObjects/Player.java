package finalproject.GameObjects;

import finalproject.Modules.*;

public class Player extends GameObject{
    
  private boolean executeAction;
  private int life;
  private int fireRate;
  
  public Player(double xCoord, double yCoord, double zCoord, double r, boolean b) {
    setLife(1);
    setRadius(r);
    setX(xCoord);
    setY(yCoord);
    setZ(zCoord);
    setMoveSpeed(5);
    setHostile(b);
    setFireRate(60 / 5); // 5 bullet / second (60 frames)
  }
  public void update() {
    if (!death()) {
      move();
      checkAction();
    }
  }
  public void move() {
    // InputManager API
    
    setX( this.getX() + 
            InputManager.getX() * getMoveSpeed() * SceneManager.scene.delta
    );
    setY( this.getY() + 
            InputManager.getY() * getMoveSpeed() * SceneManager.scene.delta
    );
    /* Apply Map Border */
    if (getX() < 0) setX(0);
    if (getX() > ImageManager.board.getWidth() - ImageManager.grabImage(this).getWidth(null)) 
        setX(ImageManager.board.getWidth() - ImageManager.grabImage(this).getWidth(null));
    if (getY() < 0) setY(0);
    if (getY() > ImageManager.board.getHeight() - ImageManager.grabImage(this).getHeight(null)) 
        setY(ImageManager.board.getHeight() - ImageManager.grabImage(this).getHeight(null));
  }
  public void checkAction() {
    setExecuteAction(InputManager.getFire());
  }
  public boolean death() {
    return getLife() <= 0;
  }
    
  /*                                                                  
        GGGGGGGGGGGGGEEEEEEEEEEEEEEEEEEEEEETTTTTTTTTTTTTTTTTTTTTTT
     GGG::::::::::::GE::::::::::::::::::::ET:::::::::::::::::::::T
   GG:::::::::::::::GE::::::::::::::::::::ET:::::::::::::::::::::T
  G:::::GGGGGGGG::::GEE::::::EEEEEEEEE::::ET:::::TT:::::::TT:::::T
 G:::::G       GGGGGG  E:::::E       EEEEEETTTTTT  T:::::T  TTTTTT
G:::::G                E:::::E                     T:::::T        
G:::::G                E::::::EEEEEEEEEE           T:::::T        
G:::::G    GGGGGGGGGG  E:::::::::::::::E           T:::::T        
G:::::G    G::::::::G  E:::::::::::::::E           T:::::T        
G:::::G    GGGGG::::G  E::::::EEEEEEEEEE           T:::::T        
G:::::G        G::::G  E:::::E                     T:::::T        
 G:::::G       G::::G  E:::::E       EEEEEE        T:::::T        
  G:::::GGGGGGGG::::GEE::::::EEEEEEEE:::::E      TT:::::::TT      
   GG:::::::::::::::GE::::::::::::::::::::E      T:::::::::T      
     GGG::::::GGG:::GE::::::::::::::::::::E      T:::::::::T      
        GGGGGG   GGGGEEEEEEEEEEEEEEEEEEEEEE      TTTTTTTTTTT      
	*/   
    
  public boolean getExecuteAction() {
    return this.executeAction;
  }
  public int getLife() {
    return this.life;
  }
  public int getFireRate() {
    return this.fireRate;
  }

/*                                                                
   SSSSSSSSSSSSSSS EEEEEEEEEEEEEEEEEEEEEETTTTTTTTTTTTTTTTTTTTTTT
 SS:::::::::::::::SE::::::::::::::::::::ET:::::::::::::::::::::T
S:::::SSSSSS::::::SE::::::::::::::::::::ET:::::::::::::::::::::T
S:::::S     SSSSSSSEE::::::EEEEEEEEE::::ET:::::TT:::::::TT:::::T
S:::::S              E:::::E       EEEEEETTTTTT  T:::::T  TTTTTT
S:::::S              E:::::E                     T:::::T        
 S::::SSSS           E::::::EEEEEEEEEE           T:::::T        
  SS::::::SSSSS      E:::::::::::::::E           T:::::T        
    SSS::::::::SS    E:::::::::::::::E           T:::::T        
       SSSSSS::::S   E::::::EEEEEEEEEE           T:::::T        
            S:::::S  E:::::E                     T:::::T        
            S:::::S  E:::::E       EEEEEE        T:::::T        
SSSSSSS     S:::::SEE::::::EEEEEEEE:::::E      TT:::::::TT      
S::::::SSSSSS:::::SE::::::::::::::::::::E      T:::::::::T      
S:::::::::::::::SS E::::::::::::::::::::E      T:::::::::T      
 SSSSSSSSSSSSSSS   EEEEEEEEEEEEEEEEEEEEEE      TTTTTTTTTTT      
*/
  public boolean setExecuteAction(boolean trueFalse) {
    return this.executeAction = trueFalse;
  }
  public int setLife(int i) {
    return this.life = i;
    }
  public int setFireRate(int i) {
    return this.fireRate = i;
  }

}
