import java.util.ArrayList;

/**
 * The GraphicEngine3D class is responsible for rendering the 3D scene.
 * It processes nodes that have both Transform and Mesh components
 * and prepares them for rendering. This class extends the abstract
 * class AbstractedGraphicEngine and overrides the render method.
 */
public class GraphicEngine3D extends AbstractedGraphicEngine {

    // Constructors
    /**
     * Constructor that initializes the graphic engine without any Scene.
     * The scene must be set later to project it for a screen rendering.
     */
    public GraphicEngine3D() {
      super();
    }

    /**
     * Constructor that initializes the GraphicEngine3D with a given scene.
     * @param scene The scene that this engine will render.
     */
    public GraphicEngine3D(Scene scene) {
        super(scene);  // Call the superclass constructor to set the scene.
    }

    // method

    /**
     * Renders the scene. It looks for nodes in the scene that contain both
     * a TransformComponent and a MeshComponent. These nodes are collected
     * and prepared for rendering. Currently, projection logic is not implemented.
     */
    public ArrayList<Triangle> projectScene() {
        // Define an inner class to store renderable data
        class Renderable {
            // Fields
            private TransformComponent transform;
            private MeshComponent mesh;

            // Constructor
            public Renderable() {
                transform = null;
                mesh = null;
            }

            public Renderable(TransformComponent transform, MeshComponent mesh) {
                this.transform = transform;
                this.mesh = mesh;
            }

            // Getters
            public TransformComponent getTransform() {
                return transform;
            }

            public MeshComponent getMesh() {
                return mesh;
            }

            // Setters
            public void setTransform(TransformComponent transform) {
                this.transform = transform;
            }

            public void setMesh(MeshComponent mesh) {
                this.mesh = mesh;
            }

            // Check if both components are set
            public boolean isComplete() {
                return transform != null && mesh != null;
            }
        }

        // Initialize a list to store data to render
        ArrayList<Renderable> renderables = new ArrayList<>();

        // Iterate through each node in the scene
        for (Node node : scene.getNodes()) {
            Renderable renderable = new Renderable();
            // Iterate through each component of the node
            for (Component component : node.getComponents()) {
                // Get the useful component
                if (component instanceof TransformComponent) {
                    renderable.setTransform((TransformComponent) component);
                } else if (component instanceof MeshComponent) {
                    renderable.setMesh((MeshComponent) component);
                }

                // If both components are present, add the renderable object and stop checking further components
                if (renderable.isComplete()) {
                    renderables.add(renderable);
                    break;
                }
            }
        }

        //// Projection
        float FOV = (float) (Math.PI * 2 / 3); // 120 degrees field of view
        int screenWidth = 1; // It's a default value, then we will multiply projectedCoordinates by the screenwidth wen we display
        float d = screenWidth / (2 * FOV); // virtual distance between the screen and the user

        ArrayList<Triangle> projectedTriangles = new ArrayList<>();

        for (Renderable renderable : renderables) {
            for (Triangle triangle : renderable.getMesh().getTriangles()) {
                Vect3[] vertices = triangle.getVertices();
                Vect3[] projectedVertices = new Vect3[3];

                for (int i = 0; i < 3; i++) {
                    float x = d * vertices[i].getX() / vertices[i].getZ();
                    float y = d * vertices[i].getY() / vertices[i].getZ();
                    projectedVertices[i] = new Vect3(x, y, 0.0f);
                }

                projectedTriangles.add(new Triangle(projectedVertices));
            }
        }

        return projectedTriangles;
    }
}
