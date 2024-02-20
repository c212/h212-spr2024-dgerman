public class Node {
  int key; 
  Node left, right; 
  public Node(int key) {
    this.key = key; 
    this.left = null; 
    this.right = null; 
  }
  public Node(int key, Node left, Node right) {
      this.key = key; 
      this.left = left; 
      this.right = right; 
  }
  public void accept(Visitor v) {
      v.visitNode(this);
  }
}

