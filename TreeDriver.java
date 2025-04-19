import java.io.*;
import java.util.*;

public class TreeDriver {
    public static void main(String[]args){

        // Create the tree
        BST tree = new BST();
        Scanner stdIn = new Scanner(System.in);
        String fileName;

        // Read from the file
        try {
            System.out.println("Enter the name of the file: ");
            fileName = stdIn.nextLine();
            Scanner scanner = new Scanner(new File("Domains/" + fileName));

            // Add to the tree as key-value pairs
            while (scanner.hasNext()) {
                String key = scanner.next();
                if (scanner.hasNext()) {
                    String value = scanner.next();
                    tree.addValue(key, value);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found!");
            stdIn.close();
            return;
        }

        // Print the traversals
        System.out.println("PRE-ORDER TRAVERSAL: ");
        tree.preOrderTraversal(tree.root);
        System.out.println("\n");

        System.out.println("IN-ORDER TRAVERSAL: ");
        tree.inOrderTraversal(tree.root);
        System.out.println("\n");

        System.out.println("POST-ORDER TRAVERSAL: ");
        tree.postOrderTraversal(tree.root);
        System.out.println("\n");

        // Search for domains and IP addresses
        while (true) {

            System.out.println("Please input a domain (q to quit): ");
            String userInput = stdIn.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                break;
            }

            // Get the IP Address, method returns "not found" if no match is found
            String IPAddress = tree.search(userInput); 

            if (!IPAddress.equals("not found")) {
                System.out.println(userInput + " was found!   The IP address is: " + IPAddress);
            } else {
                System.out.println(userInput + " was NOT found, try again!");
            }
        }
        stdIn.close();
    }
}
