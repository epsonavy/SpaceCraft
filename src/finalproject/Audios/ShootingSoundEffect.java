package finalproject.Audios;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author epso
 */
public class ShootingSoundEffect implements Runnable {
    Thread thrd;
    
    public ShootingSoundEffect() {
        thrd = new Thread(this);
        thrd.start();
    }
    public void run() {
    int repeat = 1;
    try {
      AudioFormat af = new AudioFormat(8000f, // sampleRate
          8, // sampleSizeInBits
          1, // channels
          true, // signed
          false); // bigEndian
      SourceDataLine sdl;
      sdl = AudioSystem.getSourceDataLine(af);
      sdl.open(af);
      sdl.start();

      byte[] buf = new byte[1];
      int step;

      for (int j = 0; j < repeat; j++) {
        step = 10;
        for (int i = 0; i < 2000; i++) {
          buf[0] = ((i % step > 0) ? 32 : (byte) 0);

          if (i % 250 == 0)
            step += 2;
          sdl.write(buf, 0, 1);
        }
        Thread.sleep(200);
      }
      sdl.drain();
      sdl.stop();
      sdl.close();
    } catch (InterruptedException | LineUnavailableException e) {
      e.printStackTrace();
    }
  }
}
