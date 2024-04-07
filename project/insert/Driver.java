public class Driver {
    public static void main(String[] args) {
        Node a = new Node(2, new Node(1, Node.RED), new Node(3, Node.RED));
        a.accept(new Reporter()); System.out.println("---------------");
        Node b = new Node(2, new Node(1, Node.RED), new Node(3, null, new Node(5, Node.RED), Node.RED), Node.RED);
        b.accept(new Reporter()); System.out.println("---------------");
    }
}
/*******(sample run:

dgerman@silo:/l/www/classes/h212/spr2024/project$ java Driver
  _2_
 /   \
[1] [3]
---------------
  _[2]_
 /     \
[1]   [3]_
          \
         [5]
---------------
dgerman@silo:/l/www/classes/h212/spr2024/project$

 *********************/
