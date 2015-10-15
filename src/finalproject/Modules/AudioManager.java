package finalproject.Modules;

import finalproject.Audios.*;

public class AudioManager {
    
    public AudioManager() {}
    
    public static void start() {
        new GameStartAudio();
    }
    
    public static void gameOver() {
        new GameOverSoundEffect();
    }
    
    public static void shooting() {
        new ShootingSoundEffect();
    }
    
    public static void blast() {
        new BlastSoundEffect();
    }
    
    public static void update() {}
    
}
