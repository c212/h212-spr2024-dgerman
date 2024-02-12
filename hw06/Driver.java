public class Driver {
    public static void main(String[] args) {
        Node a = new Node(1, new Node(2, null, 
                                         new Node(3)), 
                             new Node(4, new Node(5, new Node(14, new Node(15, new Node(16, new Node(23), null), 
                                                                               new Node(17)), 
                                                                  null), 
                                                     null), 
                                         null));
        a.left.left = new Node(6, new Node(10, new Node(12, null, null), new Node(11, null,  null)), null); 
        a.right.right = new Node(7, null, null); 
     
        a.left.right.left = new Node(8, null, null); 
        Node temp = new Node(9, null, null); 
        a.left.right.right = temp; 
     
        temp.right = new Node(10); 
     
        System.out.println( a ); 
        
        Visitor v = new Reporter(); 
        
        a.accept(v);
        
        Visitor sum = new Sum(); 
        
        a.accept(sum);
    }
}%         
