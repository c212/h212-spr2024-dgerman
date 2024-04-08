public class Driver {
    public static void main(String[] args) {
        System.out.println("Inserting " + 1 + " into the empty tree...");
        Node n = Node.insertInto(null, 1);
        n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 2);
        n = Node.insertInto(n, 2);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 3);
        n = Node.insertInto(n, 3);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 4);
        n = Node.insertInto(n, 4);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 5);
        n = Node.insertInto(n, 5);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 6);
        n = Node.insertInto(n, 6);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 7);
        n = Node.insertInto(n, 7);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 8);
        n = Node.insertInto(n, 8);
        // n.accept(new Reporter());
        System.out.println("-------------");

    }
}

/****(sample run)***:

dgerman@silo:/l/www/classes/h212/spr2024/project$ javac Driver.java
dgerman@silo:/l/www/classes/h212/spr2024/project$ java Driver
Inserting 1 into the empty tree...
1
-------------
Adding 2
1_
  \
 [2]
-------------
Adding 3
1_
  \
 [2]_
     \
    [3]
Fixing it...
 2
/ \
1 3
-------------
Adding 4
 2
/ \
1 3_
    \
   [4]
-------------
Adding 5
 2
/ \
1 3_
    \
   [4]_
       \
      [5]
Fixing it...
 2__
/   \
1  [4]
  /   \
  3   5
-------------
Adding 6
 2__
/   \
1  [4]
  /   \
  3   5_
        \
       [6]
-------------
Adding 7
 2__
/   \
1  [4]
  /   \
  3   5
        \
       [6]_
           \
          [7]
Fixing it...
 2__
/   \
1  [4]__
  /     \
  3    [6]
      /   \
      5   7
Fixing it...
  _4_
 /   \
 2   6
/ \ / \
1 3 5 7
-------------
Adding 8
  _4_
 /   \
 2   6
/ \ / \
1 3 5 7_
        \
       [8]
-------------
dgerman@silo:/l/www/classes/h212/spr2024/project$


 ****(end of sample run)***/
