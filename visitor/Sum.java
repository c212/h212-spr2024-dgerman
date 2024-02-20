public class Sum implements Visitor {
    public void visitNode(Node node) {
        System.out.println("I am here to calculate the sum of all numbers in the three.");
        System.out.println("The sum is: " + this.sum(node));
    }
    public int sum(Node node) {
        if (node == null) {
            return 0;
        } else {
            return node.key + this.sum(node.left) + this.sum(node.right);
        }
        
    }
}
