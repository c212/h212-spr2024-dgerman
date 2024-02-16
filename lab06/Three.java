import java.util.Arrays; 
import java.util.Scanner; 

class LabSix {
  public static void main(String[] args) {
    int[] numbers = new int[0]; // set up an array with zero elements 
    Scanner s = new Scanner(System.in); // get a scanner ready to read from keyboard 
    System.out.print("Enter: "); // prompt and then 
    String line = s.nextLine(); // read the next line 
    while (! line.equals("bye")) { // while the line is not "bye" 
      int number = Integer.parseInt(line); // parse the line into a number 
      numbers = Arrays.copyOf(numbers, numbers.length+1); // "grow" the array 
      numbers[numbers.length-1] = number; // place the new input in the new spot 
      System.out.println(Arrays.toString(numbers)); // print the array 
      System.out.print("Enter: "); // prompt and 
      line = s.nextLine(); // read new input (read entire line) 
    } // resume while, if line.equals("bye") while ends 
    System.out.println(Arrays.toString(numbers)); // print array 
    s.close(); // close the scanner since we don't need it any more 
  }
}
