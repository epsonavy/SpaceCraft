package finalproject.Scenes;

import finalproject.Modules.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SceneGameOver extends Scene {
    public Scene start() {
        AudioManager.gameOver();
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null, "Game Over! Continue...(No/Yes)?","GAME OVER",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            FrameManager.getFrame().dispose();
            try {
                SceneManager.Run();
            } catch (IOException ex) {
                Logger.getLogger(SceneGameOver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(dialogResult == JOptionPane.NO_OPTION) System.exit(0);
        return this;
    }
}
