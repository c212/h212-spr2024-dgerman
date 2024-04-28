import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

public class RedBlackTree
{
   public void accept(Visitor v) {
     v.visitNode(root);
   }

   Node root; // Package access, for testing

   static final int BLACK = 1;
   static final int RED = 0;
   private static final int NEGATIVE_RED = -1;
   private static final int DOUBLE_BLACK = 2;

   public RedBlackTree()
   {
      root = null;
   }

   public void add(Comparable obj)
   {
      Node newNode = new Node();
      newNode.data = obj;
      newNode.left = null;
      newNode.right = null;
      if (root == null) { root = newNode; }
      else { root.addNode(newNode); }
      System.out.println("--- Here's the result of add(ing) " + obj + " ...");
      this.accept(new Reporter());
      System.out.println("--- calling fixAfterAdd from inside add ...");
      fixAfterAdd(newNode);
      // this.accept(new Reporter());
      // System.out.println("... above, the result of fixAfterAdd. ---------");
   }

   public boolean find(Comparable obj)
   {
      Node current = root;
      while (current != null)
      {
         int d = current.data.compareTo(obj);
         if (d == 0) { return true; }
         else if (d > 0) { current = current.left; }
         else { current = current.right; }
      }
      return false;
   }

   public void remove(Comparable obj)
   {
      Node toBeRemoved = root;
      boolean found = false;
      while (!found && toBeRemoved != null)
      {
         int d = toBeRemoved.data.compareTo(obj);
         if (d == 0) { found = true; }
         else
         {
            if (d > 0) { toBeRemoved = toBeRemoved.left; }
            else { toBeRemoved = toBeRemoved.right; }
         }
      }

      if (!found) { return; }

      if (toBeRemoved.left == null || toBeRemoved.right == null)
      {
         Node newChild;
         if (toBeRemoved.left == null) { newChild = toBeRemoved.right; }
         else { newChild = toBeRemoved.left; }

System.out.print("1. We have determined we will remove: " + toBeRemoved.data); (new Scanner(System.in)).nextLine();
         fixBeforeRemove(toBeRemoved);
this.accept(new Reporter());
System.out.print("1. Above the result of fixBeforeRemove ..."); (new Scanner(System.in)).nextLine();
         replaceWith(toBeRemoved, newChild);
this.accept(new Reporter());
System.out.print("1. Above, the result of replaceWith ..."); (new Scanner(System.in)).nextLine();
         return;
      }

      Node smallest = toBeRemoved.right;
      while (smallest.left != null)
      {
         smallest = smallest.left;
      }

      toBeRemoved.data = smallest.data;
System.out.print("2. We have determined we will remove: " + toBeRemoved.data); (new Scanner(System.in)).nextLine();
      fixBeforeRemove(smallest);
this.accept(new Reporter());
System.out.print("2. Above the result of fixBeforeRemove ..."); (new Scanner(System.in)).nextLine();
      replaceWith(smallest, smallest.right);
this.accept(new Reporter());
System.out.print("2. Above, the result of replaceWith ..."); (new Scanner(System.in)).nextLine();
   }

   public String toString()
   {
      return toString(root);
   }

   private static String toString(Node parent)
   {
      if (parent == null) { return ""; }
      return toString(parent.left) + parent.data + " " + toString(parent.right);
   }

   private void replaceWith(Node toBeReplaced, Node replacement)
   {
      if (toBeReplaced.parent == null)
      {
         replacement.parent = null;
         root = replacement;
      }
      else if (toBeReplaced == toBeReplaced.parent.left)
      {
         toBeReplaced.parent.setLeftChild(replacement);
      }
      else
      {
         toBeReplaced.parent.setRightChild(replacement);
      }
   }

   private void fixAfterAdd(Node newNode)
   {
      if (newNode.parent == null)
      {
         this.accept(new Reporter());
         newNode.color = BLACK;
      }
      else
      {
         newNode.color = RED;
         if (newNode.parent.color == RED) {
           System.out.println("We need to fix double red now...");
           fixDoubleRed(newNode);
           this.accept(new Reporter());
           System.out.print("Above, after fixing the double red violation."); (new Scanner(System.in)).nextLine(); 
         }
      }
   }

   private void fixBeforeRemove(Node toBeRemoved)
   {
      if (toBeRemoved.color == RED) { return; }

      if (toBeRemoved.left != null || toBeRemoved.right != null) // It is not a leaf
      {
         // Color the child black
         if (toBeRemoved.left == null) { toBeRemoved.right.color = BLACK; }
         else { toBeRemoved.left.color = BLACK; }
      }
      else {
this.accept(new Reporter());
System.out.print("Before bubbleup (above)."); (new Scanner(System.in)).nextLine();
         bubbleUp(toBeRemoved.parent);
      }
   }

   private void bubbleUp(Node parent)
   {
      if (parent == null) { return; }
      parent.color++;
      parent.left.color--;
      parent.right.color--;

this.accept(new Reporter());
System.out.print("Bubble up has started..."); (new Scanner(System.in)).nextLine();

      if (bubbleUpFix(parent.left)) {
this.accept(new Reporter());
System.out.print("After bubbling up fix parent left (above)."); (new Scanner(System.in)).nextLine();
         return; }
      if (bubbleUpFix(parent.right)) {
this.accept(new Reporter());
System.out.print("After bubbling up fix parent right (above)."); (new Scanner(System.in)).nextLine();
         return; }

      if (parent.color == DOUBLE_BLACK)
      {
         if (parent.parent == null) {

           parent.color = BLACK; }
         else {

           bubbleUp(parent.parent); }
      }
   }

   private boolean bubbleUpFix(Node child)
   {
      if (child.color == NEGATIVE_RED) {
System.out.print("We fix negative red:"); (new Scanner(System.in)).nextLine();
         fixNegativeRed(child);
this.accept(new Reporter());
System.out.print("1. After fixing negative red (above)."); (new Scanner(System.in)).nextLine();
         return true; }
      else if (child.color == RED)
      {
         if (child.left != null && child.left.color == RED)
         {
System.out.print("We fix double red on the left child of :" + child.data); (new Scanner(System.in)).nextLine();
            fixDoubleRed(child.left);
this.accept(new Reporter());
System.out.print("2. After fixing double red on the left child (above)."); (new Scanner(System.in)).nextLine();
            return true;
         }
         if (child.right != null && child.right.color == RED)
         {
System.out.print("We fix double red on the right child of :" + child.data); (new Scanner(System.in)).nextLine();
            fixDoubleRed(child.right);
this.accept(new Reporter());
System.out.print("3. After fixing double red on the right child (above)."); (new Scanner(System.in)).nextLine();
            return true;
         }
      }
      return false;
   }

   private void fixDoubleRed(Node child)
   {
      Node parent = child.parent;
      Node grandParent = parent.parent;
      if (grandParent == null) { parent.color = BLACK; return; }
      Node n1, n2, n3, t1, t2, t3, t4;
      if (parent == grandParent.left)
      {
         n3 = grandParent; t4 = grandParent.right;
         if (child == parent.left)
         {
            n1 = child; n2 = parent;
            t1 = child.left; t2 = child.right; t3 = parent.right;
         }
         else
         {
            n1 = parent; n2 = child;
            t1 = parent.left; t2 = child.left; t3 = child.right;
         }
      }
      else
      {
         n1 = grandParent; t1 = grandParent.left;
         if (child == parent.left)
         {
            n2 = child; n3 = parent;
            t2 = child.left; t3 = child.right; t4 = parent.right;
         }
         else
         {
            n2 = parent; n3 = child;
            t2 = parent.left; t3 = child.left; t4 = child.right;
         }
      }

      replaceWith(grandParent, n2);
      n1.setLeftChild(t1);
      n1.setRightChild(t2);
      n2.setLeftChild(n1);
      n2.setRightChild(n3);
      n3.setLeftChild(t3);
      n3.setRightChild(t4);
      n2.color = grandParent.color - 1;
      n1.color = BLACK;
      n3.color = BLACK;

      if (n2 == root)
      {
         root.color = BLACK;
      }
      else if (n2.color == RED && n2.parent.color == RED)
      {

           System.out.println("We need to fix double red now...");
           this.accept(new Reporter());
           fixDoubleRed(n2);
           this.accept(new Reporter());
           System.out.print("Above, after fixing the double red violation."); (new Scanner(System.in)).nextLine(); 

           // fixDoubleRed(n2);
      }


   }

   private void fixNegativeRed(Node negRed)
   {

this.accept(new Reporter());
System.out.print("This is what we need to fix (above)"); (new Scanner(System.in)).nextLine(); 

      Node parent = negRed.parent;
      Node child;
      if (parent.left == negRed)
      {
         Node n1 = negRed.left;
         Node n2 = negRed;
         Node n3 = negRed.right;
         Node n4 = parent;
         Node t1 = n3.left;
         Node t2 = n3.right;
         Node t3 = n4.right;
         n1.color = RED;
         n2.color = BLACK;
         n4.color = BLACK;

         replaceWith(n4, n3);
         n3.setLeftChild(n2);
         n3.setRightChild(n4);
         n2.setLeftChild(n1);
         n2.setRightChild(t1);
         n4.setLeftChild(t2);
         n4.setRightChild(t3);

         child = n1;
      }
      else // Mirror image
      {
         Node n4 = negRed.right;
         Node n3 = negRed;
         Node n2 = negRed.left;
         Node n1 = parent;
         Node t3 = n2.right;
         Node t2 = n2.left;
         Node t1 = n1.left;
         n4.color = RED;
         n3.color = BLACK;
         n1.color = BLACK;

         replaceWith(n1, n2);
         n2.setRightChild(n3);
         n2.setLeftChild(n1);
         n3.setRightChild(n4);
         n3.setLeftChild(t3);
         n1.setRightChild(t2);
         n1.setLeftChild(t1);

         child = n4;
      }

this.accept(new Reporter());
System.out.print("Just fixed negative red (above)."); (new Scanner(System.in)).nextLine();

      if (child.left != null && child.left.color == RED)
      {
         fixDoubleRed(child.left);
      }
      else if (child.right != null && child.right.color == RED)
      {
         fixDoubleRed(child.right);
      }
   }
}
