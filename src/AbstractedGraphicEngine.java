import java.util.ArrayList;

/**
 * Abstract class representing a graphic engine.
 * This class defines basic functionality for rendering scenes,
 * with an abstract method to be implemented by subclasses.
 */
public abstract class AbstractedGraphicEngine {

  // Field
  protected Scene scene;  // The scene to render

  // Constructors

  /**
   * Constructor that initializes the graphic engine without any Scene.
   * The scene must be set later to project it for a screen rendering.
   */
  public AbstractedGraphicEngine() {
    this.scene = null;
  }

  /**
   * Constructor that initializes the graphic engine with a given scene.
   * @param scene The scene that this engine will render.
   */
  public AbstractedGraphicEngine(Scene scene) {
    this.scene = scene;  // Set the scene for this engine
  }

  // Get
  /**
   * Get the current scene being rendered.
   * @return The scene that this engine is currently rendering.
   */
  public Scene getScene() {
    return scene;
  }

  // Set
  /**
   * Set the scene to be used by the engine.
   * @param scene The scene to set.
   */
  public void setScene(Scene scene) {
    this.scene = scene;
  }

  // Methods

  /**
   * This method is called to render the scene. It is meant to be overridden
   * by subclasses, which will implement specific rendering logic.
   */
  public abstract ArrayList<Triangle> projectScene();
}
