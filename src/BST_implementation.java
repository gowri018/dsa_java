import java.util.Scanner;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
    }
}

public class BST_implementation {
    public static Node root = null;
    static void main() {

        Scanner input =new Scanner(System.in);
        int ele;
        while(true)
        {
            ele = input.nextInt();
            if(ele==-1)
                break;
            root = insertion(root,ele);
        }
        inorder(root);
        delete_key(root, 60);
        inorder(root);
    }
    public static Node create_node(int val)
    {
        Node newnode = new Node(val);
        return newnode;
    }

    public static Node insertion(Node node ,int val)
    {
        if(node==null)
        {
            return create_node(val);
        }
        if(node.data > val)
            node.left = insertion(node.left,val);
        if(node.data < val)
            node.right = insertion(node.right,val);

        return node;
    }
    public static void inorder(Node node)
    {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public static Node delete_key(Node node, int key) {
        if (root == null)
            return null;

        if (key < node.data)
            node.left = delete_key(node.left, key);
        else if (key > node.data)
            node.right = delete_key(node.right, key);
        else if (node.left == null && node.right == null) //case 1: node w/ no children
            return null;
        else if (node.left != null && node.right == null) //case 2: node w/one child
            return node.left;
        else if (node.left == null)
            return node.right;
        else { //case 3: node w/ 2 children
            Node successor = nextNode(node.right);
            node.data = successor.data;
            delete_key(node.right, successor.data);
        }
        return node;

    }

    public static Node nextNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    


}
