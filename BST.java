public class BST {
    
    protected Node root;

    // Initialize an empty tree
    public BST(){
        this.root = null;
    }

    // Add values
    public void addValue(String key, String value){
        root = addValue(root, key, value);
    }
    // Use recursion to add
    private Node addValue(Node node, String key, String value){
        // Base case
        if (node == null) {
            return new Node(key, value);
        }
        int comparison = key.compareTo(node.key);
        // Compare
        if (comparison < 0) {
            node.left = addValue(node.left, key, value); // less than
        } else if (comparison > 0) {
            node.right = addValue(node.right, key, value); // greater than
        } else {
            node.value = value; // equal
        }
        return node;
    }

    public void preOrderTraversal(Node current){
        // Base case
        if (current == null) {
            return;
        }
        // Print, then go left and then right
        System.out.print(current.key + ": " + current.value + "\t");
        preOrderTraversal(current.left);
        preOrderTraversal(current.right);
        
    }

    public void inOrderTraversal(Node current){
        // Base case
        if (current == null) {
            return;
        }
        // Find the leftmost and print in order
        inOrderTraversal(current.left);
        System.out.print(current.key + ": " + current.value + "\t"); 
        inOrderTraversal(current.right);
    }

    public void postOrderTraversal(Node current){
        // Base case
        if (current == null) {
            return;
        }
        // Visit left and right nodes, then print
        postOrderTraversal(current.left);
        postOrderTraversal(current.right);
        System.out.print(current.key + ": " + current.value + "\t");
    }

    // Search for a value
    public String search(String key){
        return search(root, key);
    }
    // Use recursion to search
    private String search(Node current, String key){
        // Base case when key is not found
        if (current == null) {
            return "not found";
        }
        // Compare
        int compare = key.compareTo(current.key);
        if (compare < 0){
            return search(current.left, key);
        }
        if (compare > 0) {
            return search(current.right, key);
        }
        return current.value;
    } 
}
