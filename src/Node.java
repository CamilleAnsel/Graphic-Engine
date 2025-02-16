import java.util.ArrayList;

public class Node {
  // Fields
  private static int counter = 0 ;

  private String name;
  private ArrayList<Component> components;

  // Build
  public Node() {
    counter++;
    name = Integer.toString(counter);
    components = new ArrayList<>();
  }

  public Node(String name, Component[] components) {
    this.name = name;
    this.components = new ArrayList<>();
  }

  // Get
  public String getName() {return name;}
  public ArrayList<Component> getComponents() {return components;}

  // Set
  public void setName(String name) {this.name = name;}
  public void addComponent(Component component) {components.add(component);}

  // Methods
  public void update(long elapsedTime) {
    for(Component component : components){
      component.update(elapsedTime);
    }
  }
}
