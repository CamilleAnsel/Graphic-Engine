import java.util.ArrayList;

/**
 * Represents a scene containing a collection of nodes in a 3D environment.
 * The scene is responsible for managing and updating the nodes.
 */
public class Scene {

  // Field
  private ArrayList<Node> nodes; // The objects (nodes) in the scene

  // Constructors
  /**
   * Constructs a new Scene with an empty list of nodes.
   */
  public Scene() {
    this.nodes = new ArrayList<>();
  }

  // Get
  /**
   * Returns the list of nodes in the scene.
   *
   * @return a list of nodes present in the scene
   */
  public ArrayList<Node> getNodes() { return nodes; }

  // Methods
  /**
   * Adds a new node to the scene.
   *
   * @param node the node to be added to the scene
   */
  public void addNode(Node node) {
    nodes.add(node);
  }

  /**
   * Updates the scene by updating each node in the scene.
   * The update is done in accordance with the elapsed time since the last update.
   *
   * @param elapsedTime the time elapsed since the last update, in milliseconds
   */
  public void update(long elapsedTime) {
    for (Node node : nodes) {
      node.update(elapsedTime);
    }
  }
}
