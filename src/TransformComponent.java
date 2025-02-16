public class TransformComponent extends Component{
  // Field
  private Vect3 position;
  private Vect3 velocity;

  // Build
  public TransformComponent(){
    super("transform");
    this.position = new Vect3();
    this.velocity = new Vect3();
  }

  public TransformComponent(Vect3 position, Vect3 velocity){
    super("transform");
    this.position = position;
    this.velocity = velocity;
  }

  // Get
  public Vect3 getPosition() { return position; }
  public Vect3 getVelocity() { return velocity; }

  // Set
  public void setPosition(Vect3 position){ this.position = position; }
  public void setVelocity(Vect3 velocity){ this.velocity = velocity; }

  // Update
  @Override
  public void update(long elapsedTime) {
    Vect3 movement = Vect3.elementWiseMultiplication(velocity, (float)elapsedTime/1000); // The movement since the last update
    position.add(movement);
  }
}
