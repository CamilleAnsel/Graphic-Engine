public class Main {
  public static void main(String[] args) {
    
    //// Initialise scene
    Scene scene = new Scene();

    //// add a cube in the scene
    Node cube = new Node(); // instanciate a node
    cube.setName("Cube");
    TransformComponent transform = new TransformComponent(new Vect3(0,0,1), new Vect3()); // give it a position
    cube.addComponent(transform);
    // Define the 8 vertices of the cube
    Vect3 v0 = new Vect3(-0.5f, -0.5f, -0.5f);
    Vect3 v1 = new Vect3(0.5f, -0.5f, -0.5f);
    Vect3 v2 = new Vect3(0.5f, 0.5f, -0.5f);
    Vect3 v3 = new Vect3(-0.5f, 0.5f, -0.5f);
    Vect3 v4 = new Vect3(-0.5f, -0.5f, 0.5f);
    Vect3 v5 = new Vect3(0.5f, -0.5f, 0.5f);
    Vect3 v6 = new Vect3(0.5f, 0.5f, 0.5f);
    Vect3 v7 = new Vect3(-0.5f, 0.5f, 0.5f);
    Vect3[] cubeVertices = new Vect3[]{ // Define the 12 triangles (2 per face)
        v0, v1, v2,  v0, v2, v3,  // Front face
        v4, v5, v6,  v4, v6, v7,  // Back face
        v0, v4, v7,  v0, v7, v3,  // Left face
        v1, v5, v6,  v1, v6, v2,  // Right face
        v3, v2, v6,  v3, v6, v7,  // Top face
        v0, v1, v5,  v0, v5, v4   // Bottom face
    };
    cube.addComponent(new MeshComponent(cubeVertices)); // Create the mesh component using the vertex array
    scene.addNode(cube);

    //// Instanciate and run the engine
    DisplayWindow display = new DisplayWindow(500, 500, "First Window");
    GraphicEngine3D graphicEngine = new GraphicEngine3D();
    VariableStepEngineLoop engine = new VariableStepEngineLoop(scene, graphicEngine, display);
    engine.run();
  }
}
