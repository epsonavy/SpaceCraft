package finalproject.Modules;

import finalproject.GameObjects.GameObject;
import finalproject.Images.Board;
import java.awt.Image;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ImageManager {
    
    public static Board board;
    
    public static JButton Exit;
    public static JLabel scoreLabel, scoreNum, hiScoreLabel, hiScoreNum, fpsLabel, fpsNum;
    public static GroupLayout layout;
    
    public ImageManager() {}
    
        public static void initMap() {
            paintFrame();
    }
    
    private static void paintFrame() {
        
        ImageManager.board = new Board();

        fpsLabel = new JLabel("FPS:");
        fpsNum = new JLabel("0");
        scoreLabel = new JLabel("Score:");
        scoreNum = new JLabel("0");
        hiScoreLabel = new JLabel("Hi-Score:");
        hiScoreNum = new JLabel(DataManager.grabHighScore().toString());

        Exit = new JButton();
        Exit.setText("Exit");
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitClicked(evt);
            }
        });

        layout = new GroupLayout(FrameManager.getFrame().getContentPane());
        layout.setAutoCreateGaps(true);
        //layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(ImageManager.board)   
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(fpsLabel) 
                .addComponent(fpsNum)        
                .addComponent(scoreLabel) 
                .addComponent(scoreNum)
                .addComponent(Exit)
                .addComponent(hiScoreLabel)
                .addComponent(hiScoreNum)
                )
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(ImageManager.board)
                .addGroup(layout.createSequentialGroup()
                .addComponent(fpsLabel) 
                .addComponent(fpsNum)
                .addComponent(scoreLabel)
                .addComponent(scoreNum)
                .addComponent(Exit)
                .addGap(300, 400, 500)
                .addComponent(hiScoreLabel)
                .addComponent(hiScoreNum)
                ))
        );
        FrameManager.getFrame().getContentPane().setLayout(layout);

        FrameManager.getFrame().pack();
    }
    
    private static void exitClicked(java.awt.event.MouseEvent evt) {                                      
        FrameManager.getFrame().dispose();
        System.exit(0);
    }
    
    public static void updateFrameLabels(Long score, Long hiScore, Integer fpsInt, int grabFps) {
        scoreNum.setText(score.toString());
        if (hiScore < score) {
            hiScore = score;
            DataManager.setHighScore(hiScore);
            hiScoreNum.setText(hiScore.toString());
        }
        fpsInt = grabFps;
        fpsNum.setText(fpsInt.toString());
    }
    
    public static void update() {
        board.update();
    }
    
    public static void addPlayer(GameObject obj) {
        board.add(obj, "src/finalproject/Images/craftsmall.png");
    }
    public static void addExplosion(GameObject obj) {
        board.add(obj, "src/finalproject/Images/explosion.png");
    }
    public static void addEnemy(GameObject obj) {
        board.add(obj, "src/finalproject/Images/enemy.png");
    }
    public static void addBullet(GameObject obj) {
        board.add(obj, "src/finalproject/Images/missile.png");
    }
    public static void addDownBullet(GameObject obj) {
        board.add(obj, "src/finalproject/Images/downmissile.png");
    }
    public static Image grabImage(GameObject obj) {
        return board.grabImage(obj);
    }

    
}
