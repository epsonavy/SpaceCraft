package finalproject.GameObjects;
public class GameObject {

  private boolean death;
  private boolean hostile;
  private double direction;
  private double moveSpeed;
  private double radius;
  private double x;
  private double y;
  private double z;

  public GameObject() {
  }
  
  public void update() {
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

  public boolean getDeath() {
    return this.death;
  }
  public boolean getHostile() {
    return this.hostile;
  }
  public double getDirection() {
    return this.direction;
  }
  public double getMoveSpeed() {
    return this.moveSpeed;
  }
  public double getRadius() {
    return this.radius;
  }
  public double getX() {
    return this.x;
  }
  public double getY() {
    return this.y;
  }
  public double getZ() {
    return this.z;
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

  public boolean setDeath(boolean trueFalse) {
    return this.death = trueFalse;
  }
  public boolean setHostile(boolean trueFalse) {
    return this.hostile = trueFalse;
  }
  public double setDirection(double d) {
    return this.direction = d;
  }
  public double setMoveSpeed(double d) {
    return this.moveSpeed = d;
  }
  public double setRadius(double d) {
    return this.radius = d;
  }
  public double setX(double d) {
    return this.x = d;
  }
  public double setY(double d) {
    return this.y = d;
  }
  public double setZ(double d) {
    return this.z = d;
  }
    
}
