import java.util.Scanner;

class StackNode{
    int data;
    StackNode next;

    StackNode(int data){
        this.data=data;
    }
}

public class Stack {
    public static StackNode top=null;

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("1.push() 2.pop() 3.peek() 4.display() 5.size() 6. display() 7.exit():-1");

        int choice;

        while(true){
            choice=sc.nextInt();
            if(choice==-1){
                break;
            }    

            switch(choice){
                case 1:
                    int a=sc.nextInt();
                    push(a);
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    System.out.println("Peek:"+peek());
                    break;
                case 4:
                    System.out.println("The stack is empty: "+isEmpty());
                    break;
                case 5:
                    System.out.println("The size of the stack is: "+size());
                    break;
                case 6:
                    display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void push(int data){
        StackNode newnode=new StackNode(data);

        if(top==null){
            top=newnode;
        }

        else{
            newnode.next=top;
            top=newnode;
        }
    }

    public static void pop(){
        if(top==null){
            System.out.println("Underflow");
        }
        else{
            top=top.next;
        }
    }

    public static int peek(){
        if(top==null)
            return -1;
        else
            return top.data;
    }

    public static boolean isEmpty(){
        if(top==null)
            return true;
        return false;
    }

    public static int size(){
        int length=0;
        if(top==null)
            return 0;
        else{
            StackNode temp=top;
            while(temp!=null){
                length++;
                temp=temp.next;
            }
        }
        return length;
    }

    public static void display(){
        if(top==null){
            System.out.println("The stack is empty");
        }
        else{
            StackNode temp=top;
            while(temp!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
        
    }

}
