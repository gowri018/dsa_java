import java.util.Scanner;

class QNode{
    int data;
    QNode next;

    QNode(int data){
        this.data=data;
    }
}

public class Queue {
    public static QNode front= null;
    public static QNode rear= null;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        System.out.println("1.enqueue 2.dequeue 3.peek 4.size 5.display");

        while(true){
            int ch=sc.nextInt();

            if(ch==-1)
                break;

            switch(ch){
                case 1:
                    int a=sc.nextInt();
                    enqueue(a);
                    break;
                case 2:
                    dequeue();
                    break;
                case 3:
                    System.out.println("Peek: "+peek());
                    break;
                case 4:
                    System.out.println("Size: "+size());
                    break;
                case 5:
                    display();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }

    public static void enqueue(int val){
        QNode newnode=new QNode(val);
        if(front==null){
            front=newnode;
            rear=newnode;
        }
        else{
            rear.next=newnode;
            rear=newnode;
        }

    }

    public static void dequeue(){
        if(front==null){
            System.out.println("The queue is empty");
            return;
        }
        else if(front.next==null){
            front=null;
            rear=null;
        }
        else{
            front=front.next;
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
        QNode temp=front;
        int count=0;
        while(temp.next!=null){
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

        QNode temp=front;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

}
     