/**
 * A class representing a 3D vector (Vect3) with basic operations.
 * The vector consists of three components: x, y, and z, which represent
 * the 3-dimensional coordinates in space.
 */
public class Vect3 {

  /** The x-coordinate of the vector */
  private float x;
  /** The y-coordinate of the vector */
  private float y;
  /** The z-coordinate of the vector */
  private float z;

  // Constructors

  /**
   * Default constructor that initializes the vector to (0, 0, 0).
   */
  public Vect3() {
    this.x = 0;
    this.y = 0;
    this.z = 0;
  }

  /**
   * Constructor that initializes the vector with specific x, y, and z values.
   * @param x the x-coordinate of the vector
   * @param y the y-coordinate of the vector
   * @param z the z-coordinate of the vector
   */
  public Vect3(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Constructor that initializes the vector using an array of size 3.
   * The array must contain exactly three values (x, y, z).
   * @param array3 an array of size 3 representing the 3D vector
   * @throws IllegalArgumentException if the array does not have exactly 3 elements
   */
  public Vect3(float[] array3) {
    if (array3.length != 3) {
      throw new IllegalArgumentException("Array size must be 3 for a 3D vector.");
    }
    this.x = array3[0];
    this.y = array3[1];
    this.z = array3[2];
  }

  // Getters

  /**
   * Returns the components of the vector as an array.
   * @return an array containing the x, y, and z components of the vector
   */
  public float[] get() {
    return new float[]{x, y, z};
  }

  /**
   * Returns the x-coordinate of the vector.
   * @return the x-coordinate
   */
  public float getX() {
    return x;
  }

  /**
   * Returns the y-coordinate of the vector.
   * @return the y-coordinate
   */
  public float getY() {
    return y;
  }

  /**
   * Returns the z-coordinate of the vector.
   * @return the z-coordinate
   */
  public float getZ() {
    return z;
  }

  // Setters

  /**
   * Sets the components of the vector from an array of size 3.
   * The array must contain exactly three values (x, y, z).
   * @param array3 an array of size 3 representing the new 3D vector
   * @throws IllegalArgumentException if the array does not have exactly 3 elements
   */
  public void set(float[] array3) {
    if (array3.length != 3) {
      throw new IllegalArgumentException("Array size must be 3 for a 3D vector.");
    }
    this.x = array3[0];
    this.y = array3[1];
    this.z = array3[2];
  }

  /**
   * Sets the x-coordinate of the vector.
   * @param x the new x-coordinate
   */
  public void setX(float x) {
    this.x = x;
  }

  /**
   * Sets the y-coordinate of the vector.
   * @param y the new y-coordinate
   */
  public void setY(float y) {
    this.y = y;
  }

  /**
   * Sets the z-coordinate of the vector.
   * @param z the new z-coordinate
   */
  public void setZ(float z) {
    this.z = z;
  }

  //// Methods
  // Procedures

  /**
   * Returns a string representation of the vector in the format "Vect3 (x, y, z)".
   * @return a string representation of the vector
   */
  @Override
  public String toString() {
    return "Vect3 (" + x + " , " + y + " , " + z + ")";
  }

  /**
   * Adds another vector to the current vector. The components of the given vector
   * will be added to the corresponding components of the current vector.
   * @param vect3 the vector to be added to the current vector
   */
  public void add(Vect3 vect3) {
    this.x += vect3.x;
    this.y += vect3.y;
    this.z += vect3.z;
  }

  // Functions

  /**
  * Performs element-wise multiplication of two Vect3 vectors.
   *
   * @param v1 the first vector
   * @param v2 the second vector
   * @return a new Vect3 resulting from the component-wise multiplication of v1 and v2
   */
   public static Vect3 elementWiseMultiplication(Vect3 v1, Vect3 v2) {
       float newX = v1.x * v2.x;
       float newY = v1.y * v2.y;
       float newZ = v1.z * v2.z;
       return new Vect3(newX, newY, newZ);
   }

  /**
   * Performs element-wise multiplication (component-wise multiplication)
   * of a Vect3 vector and a scalar (float).
   *
   * @param v the Vect3 vector
   * @param scalar the scalar value
   * @return a new Vect3 resulting from the element-wise multiplication of v and scalar
   */
   public static Vect3 elementWiseMultiplication(Vect3 v, float scalar) {
       float newX = v.getX() * scalar;
       float newY = v.getY() * scalar;
       float newZ = v.getZ() * scalar;
       return new Vect3(newX, newY, newZ);
   }

  /**
   * Calculates and returns the dot product (scalar product) of two Vect3 vectors.
   * The dot product is defined as: a.x * b.x + a.y * b.y + a.z * b.z.
   * @param v1 the first vector
   * @param v2 the second vector
   * @return the dot product of the two vectors
   */
  public static float dotProduct(Vect3 v1, Vect3 v2) {
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
  }
}
