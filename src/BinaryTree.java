import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node right;
    Node left;

    Node(int data) {
        this.data = data;
    }
}

public class BinaryTree {

    public static Node root = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            if(a==-1)
                break;
            insert(a);
        }
    }

    public static Node createNode(int val) {
        Node newnode = new Node(val);
        return newnode;
    }

    public static void insert(int val) {

        if (root == null) {
            createNode(val);
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.left == null) {
                cur.left = createNode(val);
                return;
            } else
                que.offer(cur.left);

            if (cur.right == null) {
                cur.right = createNode(val);
                return;
            } else
                que.offer(cur.right);

        }

    }
    
    public static void inorder(Node node) {
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }
    
    public static void preorder(Node node) {
        System.out.println(node.data + " ");
        inorder(node.left);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        inorder(node.left);
        inorder(node.right);
        System.out.println(node.data + " ");
    }

    public static void level_order(Node node) {
        if(root==null)
            return;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            Node curr = que.poll();
            System.out.println(curr.data + " ");
            
            if(curr.left!=null)
                que.offer(curr.left);
            if(curr.right!=null)
                que.offer(curr.right);
        }
    }

}
