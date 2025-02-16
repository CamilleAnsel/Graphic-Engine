public class Triangle {
  // Fields
  private Vect3 verticeA;
  private Vect3 verticeB;
  private Vect3 verticeC;

  // Constructors
  public Triangle(){
    verticeA = new Vect3();
    verticeB = new Vect3();
    verticeC = new Vect3();
  }

  public Triangle(Vect3 verticeA, Vect3 verticeB, Vect3 verticeC){
    this.verticeA = verticeA;
    this.verticeB = verticeB;
    this.verticeC = verticeC;
  }

  public Triangle(Vect3[] vertices){
    verticeA = vertices[0];
    verticeB = vertices[1];
    verticeC = vertices[2];
  }

  // Get
  public Vect3[] getVertices() {
    return new Vect3[]{verticeA, verticeB, verticeC};
  }

  // Set
  public void setVertices(Vect3 verticeA, Vect3 verticeB, Vect3 verticeC) {
    this.verticeA = verticeA;
    this.verticeB = verticeB;
    this.verticeC = verticeC;
  }
}
