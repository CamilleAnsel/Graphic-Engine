/**
 * The MeshComponent class represents a 3D mesh composed of triangles.
 */
public class MeshComponent extends Component {
    // Field

    /**
     * Represents the mesh with an Array of Triangle objects.
     */
    private Triangle[] mesh;

    // Constructors

    /**
     * Default constructor that initializes an empty mesh.
     */
    public MeshComponent() {
        super("mesh");
        mesh = new Triangle[0];
    }

    /**
     * Constructor that initializes the mesh with a given array of triangles.
     * @param mesh An array of Triangle objects defining the mesh.
     */
    public MeshComponent(Triangle[] mesh) {
        super("mesh");
        this.mesh = mesh;
    }

    /**
     * Constructor that takes an array of Vect3, assuming they form triangles sequentially.
     * Each group of three consecutive Vect3 objects defines a triangle.
     * @param vertices An array of Vect3 representing the points of the triangles.
     * @throws IllegalArgumentException If the number of vertices is not a multiple of 3.
     */
    public MeshComponent(Vect3[] vertices) {
        super("mesh");
        if (vertices.length % 3 != 0) {
            throw new IllegalArgumentException("Number of vertices must be a multiple of 3.");
        }
        this.mesh = new Triangle[vertices.length / 3];
        for (int i = 0; i < vertices.length; i += 3) {
            mesh[i / 3] = new Triangle(vertices[i], vertices[i + 1], vertices[i + 2]);
        }
    }

    // Getters

    /**
     * Retrieves the array of triangles forming the mesh.
     * @return An array of Triangle objects.
     */
    public Triangle[] getTriangles() {
        return mesh;
    }

    // Setters

    /**
     * Sets the mesh with a new array of triangles.
     * @param mesh An array of Triangle objects to replace the current mesh.
     */
    public void setMesh(Triangle[] mesh) {
        this.mesh = mesh;
    }

    // No update method needed for now
}
