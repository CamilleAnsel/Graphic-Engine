public public class main {
  public static void main(String[] args) {
    // Initialise scene
    EngineScene scene = new EngineScene();
    VariableStepEngineLoop engine = VariableStepEngineLoop(scene);

    engine.run();
  }
}
