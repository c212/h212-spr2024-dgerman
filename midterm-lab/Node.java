public class Node {
  int key;
  Node left, right;
  public Node(int key) {
    this(key, null, null);
  }
  public Node(int key, Node left, Node right) {
      this.key = key;
      this.left = left;
      this.right = right;
  }
  public void accept(Visitor v) {
      v.visitNode(this);
  }

  public void insert(int num) {
    if (this.find(num)) return;
    else if (num < this.key) {
      if (this.left != null) {
        this.left.insert(num);
      } else {
        this.left = new Node(num);
      }
    } else {
      if (this.right != null) {
        this.right.insert(num);
      } else {
        this.right = new Node(num);
      }
    }

  }

  public boolean find(int anything) {
    if (anything == this.key)
      return true;
    else if (anything > this.key)
      if (this.right != null)
        return this.right.find(anything);
      else
        return false;
    else if (this.left != null)
      return this.left.find(anything);
    else
      return false;
  }

  public Node delete(int num) {
    if (num == this.key) {
      if (this.right == null) return this.left;
      if (this.left == null)  return this.right;
      Node a = this.left;
      while (a.right != null)
        a = a.right;
      a.right = this.right;
      return this.left;
    } else {
      if (num < this.key) {
        if (this.left != null)
          this.left = this.left.delete(num);
      } else {
        if (this.right != null)
          this.right = this.right.delete(num);
      }
      return this;
    }
  }
}