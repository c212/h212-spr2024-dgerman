public class Driver {
    public static void main(String[] args) {
        int[] values = new int[] { 4, 2, 3, 1, 5, 6 };
        Node a = null;
        for (int i : values) {
          System.out.println("Adding: " + i);
          if (a == null)
            a = new Node(i);
          else
            a.insert(i);
          a.accept(new Reporter()); System.out.println("---------------");
        }
    }
}
/*******(sample run:

dgerman@silo:/l/www/classes/h212/spr2024/project$ java Driver
Adding: 4
4
---------------
Adding: 2
  _4
 /
[2]
---------------
Adding: 3
  ____4
 /
[2]_
    \
   [3]
---------------
Adding: 1
     ____4
    /
  _[2]_
 /     \
[1]   [3]
---------------
Adding: 5
     ____4_
    /      \
  _[2]_   [5]
 /     \
[1]   [3]
---------------
Adding: 6
     ____4_
    /      \
  _[2]_   [5]_
 /     \      \
[1]   [3]    [6]
---------------
dgerman@silo:/l/www/classes/h212/spr2024/project$

 *********************/
