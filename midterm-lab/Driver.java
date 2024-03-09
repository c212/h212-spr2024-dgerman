import java.util.Scanner;

public class Driver {
  public static void main(String[] args) {
    Visitor v = new Reporter();
    Scanner lilly = new Scanner(System.in);       
    System.out.print("root> ");
    String line = lilly.nextLine();
    Node node = new Node(Integer.parseInt(line));    // start with 50 for Logan's example
    node.accept(v);                                  // print
    System.out.println("-------------------------"); // separator
    node.insert(30);                                 // then set up Logan's example 
    node.insert(80);
    node.insert(10);
    node.insert(20);
    node.insert(40);
    node.insert(70);
    node.insert(60);
    node.insert(90);
    node.insert(45);
    node.insert(35);
    node.insert(33);
    System.out.print("type> "); // insert 0 then delete 50 
    line = lilly.nextLine(); // now in the interactive session 
    while (! line.equalsIgnoreCase("bye")) { // add 0 and then 
      Scanner alex = new Scanner(line); // ask for a delete 50
      String command = alex.next(); 
      int number = alex.nextInt(); 
      if (command.equals("insert")) {
        node.insert(number);
        node.accept(v);
        System.out.println("-------------------------");
      } else if (command.equals("find")) {
        boolean answer = node.find(number);
        System.out.println( answer ); 
      } else if (command.equals("delete")) {
        node = node.delete(number); // functional! (that's what fixed Logan's "error")
        node.accept(v); // this was pointed out in real time by Christian Mo in class.
        System.out.println("-------------------------");
      } else {
        System.out.println( command + " is not implemented yet... maybe later.");
      }
      System.out.print("type> ");
      line = lilly.nextLine();
    }
  }
}
