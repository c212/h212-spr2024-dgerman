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
  public static Node insertInto(Node node, int key) {
    if (node == null) return new Node(key, BLACK);
    else {
      node.insert(key);
      node.accept(new Reporter());
      while (doubleRed(node)) {
        node = fixIt(node);
        node.color = BLACK;
        (new java.util.Scanner(System.in)).nextLine();
        node.accept(new Reporter());
      }
      return node;
    }
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
  public static boolean doubleRed(Node node) {
    if (node.color == RED && (node.left != null && node.left.color == RED || node.right != null && node.right.color == RED)) return true;
    else return node.left != null && doubleRed(node.left) || node.right != null && doubleRed(node.right);
  }
  public static Node fixIt(Node n) {
    System.out.print("Fixing it... ");
    if (n.color == BLACK && n.left != null && n.left.color == RED && n.left.right != null && n.left.right.color == RED) {
      // System.out.println("I detected it...");
      // System.exit(0);
      Node n1 = n.left, n2 = n.left.right, n3 = n, t1 = n1.left, t2 = n2.left, t3 = n2.right, t4 = n3.right;
      n1.color = BLACK;
      n1.right = t2;
      n3.left = t3;
      n2.left = n1;
      n2.right = n3;
      return n2;
    } else {
      return n;
    }
  }
  public boolean find(int key) {
    if (key == this.key) return true;
    else if (key < this.key && this.left != null) return this.left.find(key);
    else if (key > this.key && this.right != null) return this.right.find(key);
    else return false;
  }
}
