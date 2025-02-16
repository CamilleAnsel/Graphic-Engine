public class Component {
  // Field
  private String name;

  // Build
  public Component(String name) {
    this.name = name;
  }

  // Get
  public String getName() {
    return name;
  }

  // Method;
  public void update(long elapsedTime) {
    // Nothing to update
  }
}
