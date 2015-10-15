package finalproject.Modules;

import static finalproject.Main.Main.frame;
import java.awt.Dimension;
import javax.swing.JFrame;

public class FrameManager {
    
    private static final int frameWidth = 630;
    private static final int frameHeight = 740;
    
    public FrameManager() {
        InitFrame();
    }
    
    public static void InitFrame() {
        frame = new JFrame();
        frame.setTitle("Space Killer V1.0");
	frame.setPreferredSize(new Dimension(frameWidth, frameHeight));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400, 20);
	frame.pack();
	frame.setVisible(true);
        frame.setResizable(false);
    }
    
    public static void update() {}
    public static JFrame getFrame() { 
        return frame;
    }
}
