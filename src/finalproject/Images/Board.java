package finalproject.Images;

import finalproject.GameObjects.GameObject;
import finalproject.Modules.InputManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel {
    
    
    private Map<GameObject, Image> imageEntry;
    
    public Board() {
        
        imageEntry = new HashMap<>();
        
        setSize(500, 680);
        setMaximumSize(new Dimension(500, 680));
        setMinimumSize(new Dimension(500, 680));
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Dispatcher());
    }
    public class Dispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                InputManager.keyPressed(e);
            } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                InputManager.keyReleased(e);
            } else if (e.getID() == KeyEvent.KEY_TYPED) {
                InputManager.keyTyped(e);
            }
            return false;
        }
    }
    
    public Board add(GameObject obj, String path) {
        imageEntry.put(obj, new ImageIcon(path).getImage());
        return this;
    }
    public Image grabImage(GameObject obj) {
        return imageEntry.get(obj);
    }
    public void update() {
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;

        // Handle Death
        for (Iterator<Map.Entry<GameObject, Image>> entry = imageEntry.entrySet().iterator(); entry.hasNext();)
            if (entry.next().getKey().getDeath()) entry.remove();
        // Boom head shot
        for (Map.Entry<GameObject, Image> entry : imageEntry.entrySet())
            g2d.drawImage(entry.getValue(), 
                    (int)entry.getKey().getX(), 
                    (int)entry.getKey().getY(), 
                    this);
      
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
    
    
    
}
