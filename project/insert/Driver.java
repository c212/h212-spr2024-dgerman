public class Driver {
    public static void main(String[] args) {
        System.out.println("Inserting " + 3 + " into the empty tree...");
        Node n = Node.insertInto(null, 3);
        n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 1);
        n = Node.insertInto(n, 1);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 2);
        n = Node.insertInto(n, 2);
        // n.accept(new Reporter());
        System.out.println("-------------");
    }
}

/****(sample run)***:

dgerman@silo:/l/www/classes/h212/spr2024/project$ javac Driver.java
dgerman@silo:/l/www/classes/h212/spr2024/project$ java Driver
Inserting 3 into the empty tree...
3
-------------
Adding 1
  _3
 /
[1]
-------------
Adding 2
  ____3
 /
[1]_
    \
   [2]
Fixing it...
 2
/ \
1 3
-------------
dgerman@silo:/l/www/classes/h212/spr2024/project$ 

 ****(end of sample run)***/
