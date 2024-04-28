import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

      RedBlackTree t = new RedBlackTree();
      t.add("D");
      t.accept(new Reporter());
      System.out.print("---------------after putting D in empty tree------------------------"); (new Scanner(System.in)).nextLine();
      t.add("B");
      t.accept(new Reporter());
      System.out.print("---------------after we add B---------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("A");
      t.accept(new Reporter());
      System.out.print("---------------after we add A---------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("C");
      t.accept(new Reporter());
      System.out.print("---------------after we insert C------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("F");
      t.accept(new Reporter());
      System.out.print("---------------after we insert F------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("E");
      t.accept(new Reporter());
      System.out.print("---------------after inserting E------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("I");
      t.accept(new Reporter());
      System.out.print("---------------after inserting I------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("G");
      t.accept(new Reporter());
      System.out.print("---------------after inserting G------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("H");
      t.accept(new Reporter());
      System.out.print("---------------after inserting H------------------------------------"); (new Scanner(System.in)).nextLine();
      t.add("J");
      t.accept(new Reporter());
      System.out.print("---------------after adding J---------------------------------------"); (new Scanner(System.in)).nextLine();
      t.remove("A"); // Removing leaf
      t.accept(new Reporter());
      System.out.println("---------------after removing A (a leaf? Yes.)---------------------------");
      t.remove("B"); // Removing element with one child
      t.accept(new Reporter());
      System.out.println("---------------after removing B (element with one child? No.)-----------");
      t.remove("F"); // Removing element with two children
      t.accept(new Reporter());
      System.out.println("---------------after removing F (element with two children?)--------");
      t.remove("D"); // Removing root (Root?!)
      t.accept(new Reporter());
      System.out.println("---------------after removing D (is D a root?. No... (Horstmann error))----------------------");
      t.remove("E"); // Removing root
      t.accept(new Reporter());
      System.out.println("---------------after removing E (root again. No, not again, root but for the first time.)------------------------");
      t.remove("C"); // Removing root
      t.accept(new Reporter());
      System.out.println("---------------after removing C (hoping to generate some negative red)------------------------");
/*
        System.out.println("Inserting " + 8 + " into the empty tree...");
        Node n = Node.insertInto(null, 8);
        n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 1);
        n = Node.insertInto(n, 1);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 9);
        n = Node.insertInto(n, 9);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 7);
        n = Node.insertInto(n, 7);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 2);
        n = Node.insertInto(n, 2);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 6);
        n = Node.insertInto(n, 6);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 3);
        n = Node.insertInto(n, 3);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 5);
        n = Node.insertInto(n, 5);
        // n.accept(new Reporter());
        System.out.println("-------------");
        System.out.println("Adding " + 4);
        n = Node.insertInto(n, 4);
        // n.accept(new Reporter());
        System.out.println("-------------");
 */

    }
}
