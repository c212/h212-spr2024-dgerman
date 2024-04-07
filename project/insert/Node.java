public class Node {
  int key;
  int color; // 0 is Red, 1 is Black and so on.
  static final int RED = 0, BLACK = 1;
  Node left, right;
  public Node(int key, int color) {
    this(key, null, null, color);
  }
  public Node(int key) {
    this(key, null, null, BLACK);
  }
  public Node(int key, Node left, Node right, int color) {
      this.key = key;
      this.left = left;
      this.right = right;
      this.color = color;
  }
  public Node(int key, Node left, Node right) {
    this(key, left, right, BLACK);
  }
  public void accept(Visitor v) {
      v.visitNode(this);
  }
  public void insert(int key) {
    // assume the key is not in there (externally check with find first)
    if (key < this.key)
      if (this.left != null)
        this.left.insert(key);
      else this.left = new Node(key, Node.RED);
    else
      if (this.right != null)
        this.right.insert(key);
      else this.right = new Node(key, Node.RED);
  }
  public boolean find(int key) {
    if (key == this.key) return true;
    else if (key < this.key && this.left != null) return this.left.find(key);
    else if (key > this.key && this.right != null) return this.right.find(key);
    else return false;
  }
}
