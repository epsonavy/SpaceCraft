package finalproject.Modules;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class DataManager {
    
    public DataManager() throws IOException {
        new AudioManager();
        new FrameManager();
        new ImageManager();
        new InputManager();
    }
    public static void update() {
        InputManager.update();
    }
    public static Long grabHighScore() {
        File file = new File("score.mgl");
        try {
            if (file.exists())
                if (new Scanner(file).hasNextLong()) // Unnecessary, but just in case
                    return (Long) new Scanner(file).nextLong();
            return 0L;
        } catch (FileNotFoundException e) {
            return 0L;
        }
            
    }
    public static void setHighScore(Long highScore) {
        try {
            String content = highScore.toString();
            File file = new File("score.mgl");
            
            if (!file.exists()) {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(content);
            }
        
        } catch (IOException e) {}
    }
}
