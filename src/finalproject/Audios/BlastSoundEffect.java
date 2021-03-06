package finalproject.Audios;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author epso
 */
public class BlastSoundEffect implements Runnable {
    Thread thrd;
    
    public BlastSoundEffect() {
        thrd = new Thread(this);
        thrd.start();
    }
    public void run() {
    try {
              // Open an audio input stream.
              File url = new File("src/finalproject/Audios/blast.wav");
              AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
              // Get a sound clip resource.
              Clip clip = AudioSystem.getClip();
              // Open audio clip and load samples from the audio input stream.
              clip.open(audioIn);
              clip.start();
           } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
              e.printStackTrace();
           }
  }
}
