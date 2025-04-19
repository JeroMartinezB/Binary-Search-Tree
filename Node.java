public class Node {
    
    protected String key;
    protected String value;
    protected Node left, right;
    
    public Node(String key, String value){
        this.key = key;
        this.value = value;
        this.left = this.right = null;
    }

    
}
