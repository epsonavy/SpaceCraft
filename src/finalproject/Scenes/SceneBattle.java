package finalproject.Scenes;

import finalproject.GameObjects.*;
import finalproject.Modules.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SceneBattle extends Scene {
    
    private static Long score;
    private static Integer fpsInt;
    private static Long hiScore;

    private ArrayList<Bullet> BulletAlly;
    private ArrayList<Bullet> BulletNPC;
    private ArrayList<NPC> NPC;
    private Player player;
    private boolean pause;
    private int EnemyPerFrame;
    private int grabEnemyPerFrame;
    private double growthRate;
    private double spawnModifier;
    private int fireRate;
    
    public Scene start() {
        ImageManager.initMap();
        initPlayer();
        initNPC();
        initScore();
        AudioManager.start();
        return this;
    }
    
    public void initPlayer() {
        player = new Player(250,600,0,10, false); // Random Number
        BulletAlly = new ArrayList<>();
        ImageManager.addPlayer(player);
        fireRate = player.getFireRate();
        
    }
    public void initNPC() {
        BulletNPC = new ArrayList<>();
        NPC = new ArrayList<>();
        EnemyPerFrame = 60; // Spawn Enemy per frame
        grabEnemyPerFrame = EnemyPerFrame;
        growthRate = 1; // Spawn 1 more unit every second
        spawnModifier = 0;
    }
    public void initScore() {
        score = new Long(0);
        hiScore = DataManager.grabHighScore();
        // hiScore = DataManager.grabHiScore; -> implement later
    }
    
    public Scene update() {
        checkCollisionPlayerToNPC();
        checkCollisionBulletAllyToNPC();
        checkCollisionBulletNPCToPlayer();
        spawnNPC();
        // Update everything else
        updateAll();
        handleDeath();
        return this;
    }
    
    public void spawnNPC() {
        if (grabEnemyPerFrame > 0) grabEnemyPerFrame--;
        if (spawnModifier < (60 * 60)) spawnModifier += growthRate;
        // Spawn Enemy per frame in growth rate
        
        if (grabEnemyPerFrame <= 0) {
            NPC n = new NPC(Math.random() * ImageManager.board.getWidth(), 0, 0, 10, true);
            NPC.add(n);
            ImageManager.addEnemy(n);
            // Enemy shooting rate 50%
            if (Math.random() >= 0.5) {
                Bullet b = new Bullet(n.getX() + 10, 20, 0, 10, true);
                b.setDirection(1);
                b.setMoveSpeed(3);
                BulletNPC.add(b);
                ImageManager.addDownBullet(b);
            }
            if (spawnModifier < (60 * 60))
                grabEnemyPerFrame = EnemyPerFrame - ((int)(spawnModifier/60));
        }
                
    }
    
    public void checkCollisionPlayerToNPC() {
        for (NPC n : NPC) if (collide(player, n)) player.setDeath(true);
    }
    public void checkCollisionBulletAllyToNPC() {
        for (Bullet b : BulletAlly) for (NPC n : NPC) if (collide(b, n)) score += 100; // adding score
    }
    public void checkCollisionBulletNPCToPlayer() {
        for (Bullet b : BulletNPC) if (collide(b, player)) player.setDeath(true);
    }

    public void updateAll() {
        player.update();
        checkPlayerAction();
        for (NPC n : NPC) n.update();
        for (Bullet b : BulletAlly) b.update();
        for (Bullet b : BulletNPC) b.update();
        ImageManager.updateFrameLabels(score, hiScore, fpsInt, grabFps);
    }

    public void handleDeath() {
        for (Iterator<NPC>    i = NPC.iterator();        i.hasNext();) if (i.next().getDeath()) i.remove();
        for (Iterator<Bullet> i = BulletAlly.iterator(); i.hasNext();) if (i.next().getDeath()) i.remove();
        for (Iterator<Bullet> i = BulletNPC.iterator();  i.hasNext();) if (i.next().getDeath()) i.remove();
        if (player.getDeath()) {SceneManager.Switch(new SceneGameOver());}
    }
    
    public boolean collide(GameObject a, GameObject b) {
        try {
            double xDif = (a.getX() + ImageManager.grabImage(a).getWidth(null) /2) - 
                          (b.getX() + ImageManager.grabImage(b).getWidth(null) /2);
            double yDif = (a.getY() + ImageManager.grabImage(a).getHeight(null)/2) - 
                          (b.getY() + ImageManager.grabImage(b).getHeight(null)/2);
            double distanceSquared = xDif * xDif + yDif * yDif;
            boolean collision = distanceSquared < (a.getRadius() + b.getRadius()) * (a.getRadius() + b.getRadius());

            if (collision) {
                a.setDeath(true);
                b.setDeath(true);
                AudioManager.blast();
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            /* Object is removed from list/stack thus return null during grabImage(GameObject) */
            return false;
        }
    }
    public void checkPlayerAction() {
        if (fireRate > 0) fireRate--;
        if (player.getExecuteAction()) {
            if (fireRate == 0) {
                Bullet b = new Bullet(player.getX() + 5, player.getY(), player.getZ(), 2,false);
                BulletAlly.add(b);
                ImageManager.addBullet(b);
                fireRate = player.getFireRate();
            }
        }
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

  public static long getScore() {
    return score;
  }
  public static long getHiScore() {
    return hiScore;
  }
  public ArrayList getBullet() {
    return BulletAlly;
  }
  public ArrayList getNPC() {
    return NPC;
  }
  public Player getPlayer() {
    return this.player;
  }
  public boolean getPause() {
    return this.pause;
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

 public static long setScore(long l) {
    return score = l;
  }
  public static long setHiScore(long l) {
    return hiScore = l;
  }
  public Player setPlayer(Player p) {
    return this.player = p;
  }
  public boolean setPause(boolean trueFalse) {
    return this.pause = trueFalse;
  }

}
