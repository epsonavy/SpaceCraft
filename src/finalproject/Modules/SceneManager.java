package finalproject.Modules;

import finalproject.Scenes.*;
import java.io.IOException;
import java.util.Stack;


public class SceneManager {
    
    public static Object bg;
    public static Scene scene;
    public static Stack<Scene> stack;
    
  public static void Run() throws IOException {
    new DataManager();
    stack = new Stack<>();
    scene = FirstScene();
    while (scene != null) {
        scene.run();
    }
  }
  
  public static Scene FirstScene() {
      return new SceneBattle();
  }
  
  public static boolean SceneIs(Object sceneType) {
      return (null != scene) ? scene.getClass() == sceneType.getClass() : false;
  }
  public static Scene Switch(Scene sceneType) {
      return scene = sceneType;
  }
  public static Scene Open(Scene sceneType) {
      stack.push(scene);
      return scene = sceneType;
  }
  public static Scene Return() {
      return scene = stack.pop();
  }
  public static void Clear() {
      stack.clear();
  }
  public static void Exit() {
      scene = null;
  }
}
