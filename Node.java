public abstract class Node {
  // Fields
  private static int counter = 0 ;

  private String name;
  private Component[] components;

  // Build
  public static void Node() {
    counter++;
    name = (string)counter;
    components = new Component[];
  }

  public static void Node(String name, Component[] components) {
    this.name = name;
    this.components = components;
  }

  // Get
  public String getName() {return name;}
  public Component[] getComponents() {return components;}

  // Set
  public void setName(String name) {this.name = name;}
  public void addComponent(Component component) {components.add(component);}
  

  // Methods
  public void update(long elapsed_time) {
    for(Component component : components){
      component.update(elapsed_time);
    }
  }
}
