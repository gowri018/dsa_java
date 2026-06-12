import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
    }
}

public class Binary_tree_implementation {
    public static Node root = null;
    static void main() {
        Scanner input =new Scanner(System.in);
        int ele;
        while(true)
        {
            ele = input.nextInt();
            if(ele==-1)
                break;
            insertion(ele);
        }
       /* System.out.println("inorder");
        inorder(root);
        System.out.println();
        System.out.println("prerder");
        preorder(root);
        System.out.println();
        System.out.println("postorder");
        postorder(root);
        System.out.println();
        System.out.println("level order");
        level_order();*/
        level_order();
        System.out.println();
        deletion(10);
        level_order();


    }
    public static Node create_node(int val)
    {
        Node newnode = new Node(val);
        return newnode;
    }
    public static void insertion(int val)
    {
        if(root==null)
        {
            root = create_node(val);
            return;
        }
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            Node cur = que.poll();
            if(cur.left == null)
            {
                cur.left = create_node(val);
                return;
            }
            else que.offer(cur.left);

            if(cur.right==null)
            {
                cur.right = create_node(val);
                return;
            }
            else que.offer(cur.right);

        }
    }
    public static void inorder(Node node)
    {
        if(node!=null)
        {
            inorder(node.left);
            System.out.print(node.data+" ");
            inorder(node.right);
        }
    }
    public static void preorder(Node node)
    {
        if(node!=null)
        {
            System.out.print(node.data+" ");
            inorder(node.left);
            inorder(node.right);
        }
    }
    public static void postorder(Node node)
    {
        if(node!=null)
        {
            inorder(node.left);
            inorder(node.right);
            System.out.print(node.data+" ");
        }
    }
    public static void level_order()
    {
        if(root==null)
            return;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            Node cur  = que.poll();
            System.out.print(cur.data+" ");

            if(cur.left!=null)
                que.offer(cur.left);
            if(cur.right!=null)
                que.offer(cur.right);
        }

    }
    public static void deletion(int key)
    {
        if(root==null)
        {
            System.out.println("treee is empty");
            return;
        }
        if(root.left==null & root.right==null)
        {
            if(root.data == key){
                root = null;
                return;
            }

        }
        Node target = null;
        Node last = null;

        Queue<Node> que  = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty())
        {
            last = que.poll();

            if(last.data==key)
            {
                target = last;
            }
            if(last.left!=null)
                que.offer(last.left);
            if(last.right!=null)
                que.offer(last.right);
        }

        if(target!=null)
        {
            target.data = last.data;
            delete_last_node(last);
        }
    }
    public static void delete_last_node(Node dnode)
    {
         Queue<Node> que = new LinkedList<>();
         que.offer(root);

         while(!que.isEmpty())
         {
             Node cur = que.poll();

             if(cur.left==dnode)
             {
                 cur.left = null;
                 return;
             }
             else que.offer(cur.left);
             if(cur.right==dnode)
             {
                 cur.right = null;
                 return;
             }
             else que.offer(cur.right);
         }
    }

}
