package finalproject.Modules;

import java.awt.event.KeyEvent;
import java.util.BitSet;

public class InputManager {

    private static boolean fire;
    private static int x;
    private static int y;
    private static BitSet key;

    
    public InputManager() {
        key = new BitSet(256);
    }
    
    public static void keyTyped(KeyEvent e) {
        /* Do Nothing */
    }
    public static void keyPressed(KeyEvent e) {
        key.set(e.getKeyCode());
        if (key.get(KeyEvent.VK_SPACE)) {
            AudioManager.shooting();
            setFire(true);
        }
        if (key.get(KeyEvent.VK_LEFT)) {
            setX(-1);
        }
        if (key.get(KeyEvent.VK_RIGHT)) {
            setX(1);
        }
        if (key.get(KeyEvent.VK_UP)) {
            setY(-1);
        }
        if (key.get(KeyEvent.VK_DOWN)) {
            setY(1);
        }
    }
    public static void keyReleased(KeyEvent e) {
        key.clear(e.getKeyCode());
        if (!key.get(KeyEvent.VK_SPACE)) {
            setFire(false);
        }
        if (!key.get(KeyEvent.VK_LEFT)) {
            setX(0);
        }
        if (!key.get(KeyEvent.VK_RIGHT)) {
            setX(0);
        }
        if (!key.get(KeyEvent.VK_UP)) {
            setY(0);
        }
        if (!key.get(KeyEvent.VK_DOWN)) {
            setY(0);
        }
    }
    
    public static void update() {}

    
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
    public static int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }
    public static boolean getFire() {
        return fire;
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
    public static int setX(int i) {
        return x = i;
    }

    public static int setY(int i) {
        return y = i;
    }
    public static boolean setFire(boolean trueFalse) {
        return fire = trueFalse;
    }

}