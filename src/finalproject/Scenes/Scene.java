package finalproject.Scenes;

import finalproject.Modules.*;

public class Scene {
    
    public final int maxFps = 60;
    public final long optimalTime = 1000000000 / maxFps; // nano
    public double delta;                                 // Time difference in ms error ~= 5%
    public long prevFps;
    public long prevTime;
    public long currTime;
    public long length;
    public int fps;
    public int grabFps;
    public boolean newSecond;
    
    public void run() {
        
        prevFps = 0;
        fps = 0;
        prevTime = System.nanoTime(); // grab current time in nano second
        this.preStart().start().postStart();

        while (this.sceneOnPlay()) {
            
            currTime = System.nanoTime();
            length = currTime - prevTime;
            prevTime = currTime;
            delta = length / ((double)optimalTime);
            prevFps += length;
            fps++;
            if (prevFps >= 1000000000) {
                newSecond = true;
                grabFps = fps;
                System.out.println("(fps: "+fps+")");
                prevFps = 0;
                fps = 0;
            } else {
                newSecond = false;
            }
            // ImageManager + AudioManager update
            DataManager.update();
            this.update();
            ImageManager.update();
            
            try {
                if ((prevTime-System.nanoTime() + optimalTime)/1000000 > 0)
                    Thread.sleep( (prevTime-System.nanoTime() + optimalTime)/1000000 );
            } catch (InterruptedException exp) {
                System.out.println(exp);
            };
        }
        this.preEnd().end().postEnd();
    }

    public Scene preStart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + this);
        return this;
    }

    public Scene start() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ this);
        return this;
    }

    public Scene postStart() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ this);
        return this;
    }

    public boolean sceneOnPlay() {
        return SceneManager.SceneIs(this);
    }

    public Scene update() {
        return this;
    }

    public Scene preEnd() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ this);
        return this;
    }

    public Scene end() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ this);
        return this;
    }

    public Scene postEnd() {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName()+ this);
        return this;
    }
}
