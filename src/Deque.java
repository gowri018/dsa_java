import java.util.Scanner;

class DQNode{
    int data;
    DQNode next;

    DQNode(int data){
        this.data=data;
    }  
}
public class Deque {
    public static DQNode front=null, rear=null;

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("1.enqueue_rear 2.enqueue_front 3.dequeue_front 4.dequeue_rear 5.peek 6.size 7.display");

        while(true){
            int ch=sc.nextInt();

            if(ch==-1)
                break;

            switch(ch){
                case 1:
                    int a=sc.nextInt();
                    enqueue_rear(a);
                    break;
                case 2:
                    a=sc.nextInt();
                    enqueue_front(a);
                    break;
                case 3:
                    dequeue_front();
                    break;
                case 4:
                    dequeue_rear();
                    break;

                case 5:
                    System.out.println("Peek: "+peek());
                    break;
                case 6:
                    System.out.println("Size: "+size());
                    break;
                case 7:
                    display();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static void enqueue_rear(int val){  //insert_end
        DQNode newnode=new DQNode(val);

        if(front==null){
            front=newnode;
            rear=newnode;
        }
        else{
            rear.next=newnode;
            rear=newnode;
        }
    }

    public static void enqueue_front(int val){ //insert_begin
        DQNode newnode=new DQNode(val);

        if(front==null){
            front=newnode;
            rear=newnode;
        }
        else{
            newnode.next=front;
            front =newnode;
        }
    }

    public static void dequeue_front(){
        if(front==null)
            System.out.println("The queue is empty");

        else if(front==rear){  //only one ele is present
            front=null;
            rear=null;
        }
        else{
            front=front.next;

        }
    }

    public static void dequeue_rear(){
        if(front==null)
            System.out.println("The queue is empty");

        else if(front==rear){  //only one ele is present
            front=null;
            rear=null;
        }
        else{
            DQNode temp=front;
            while(temp.next!=rear){
                temp=temp.next;
            }
            temp.next=null;
        }
    }

    public static int peek(){
        if(front==null){
            System.out.println("The queue is empty");
            return -1;
        }
        else{
            return front.data;
        }
    }

    public static int size(){
        if(front==null){
            return 0;
        }
        DQNode temp=front;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;            
        }
        return count++;
    }

    public static void display(){
        if(front==null){
            System.out.println("The queue is empty");
            return;
        }

        DQNode temp=front;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
