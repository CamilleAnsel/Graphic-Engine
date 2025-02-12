public class Scene {
  // Field
  private Node[] nodes; // the objects we have in the scene
  
  // Build
  public static void Scene() {
    this.node = new Node[]();    
  }

  // Get
  public Node[] getNodes() {
    return nodes;
  }

  // Methods
  // add a Node
  public void addNode(Node node) {
    this.nodes.add(node);
  }

  // Update the scene in function of the elapsed time since the last update
  public void update(long elapsedTime) {
    for(Node node : nodes){
      node.update(elapsedTime);
    }
  }
}
