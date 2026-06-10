import java.util.Scanner;

class Node{
    int data;
    //char ch;
    Node next;

   // Node(int data, char ch){
   Node(int data){
        this.data=data;
        //this.ch=ch;
    }
}

public class SLL{

    public static Node head = null;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        insert_pos(1,200);
        while(true){
            int a=sc.nextInt();
            if(a!=-1){
                insert_end(a);
            }
            else
                break;
        }
        insert_begin(100);
        insert_pos(7,150);
        insert_end(200);
        display();        
    }

    public static void insert_begin(int n){
        Node newnode=new Node(n);

        if(head==null)
            head=newnode;
        else{
            newnode.next=head;
            head=newnode;
        }
    }

    public static void insert_end(int n){
        Node newnode= new Node(n);

        if(head==null)
            head=newnode;
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }

    public static void insert_pos(int pos, int n){
        Node newnode=new Node(n);

        if(head==null){
            if(pos==1)
                head=newnode;
            else{
                System.out.println("Position not available");
            }
        }
        else{
            if(pos==1){
                head=newnode;
            }
            else{
                Node temp=head;
                int i=0;
                for(i=0;i<pos-2;i++){
                    if(temp.next==null){
                        break;
                    }
                    temp=temp.next;
                }
                if(i<pos-2){
                    System.out.println("Position not available");
                }
                else{
                    newnode.next=temp.next;
                    temp.next=newnode;
                }
            }
        }
    }

    public static void delete_first(){
        if(head==null){
            System.out.println("Empty list. Deletion is not possible");
        }
        else{
            head=head.next;
        }
    }

    public static void delete_last(){
        if(head==null){
            System.out.println("Empty list. Deletion is not possible");
        }
        else if(head.next==null){
            head=null;
        }
        else{
            Node temp=head;
            while((temp.next).next!=null){
                temp=temp.next;
            }
            temp.next=null;
        }
    }

    public static void delete_pos(int pos){
        if(head==null){
            System.out.println("Empty list. Deletion is not possible");
        }
        else{
            int i=0;
            Node temp=head;

            if(pos==1){
                head=head.next;
            }
            else{
                for(i=0;i<pos-2;i++){
                    if(temp.next==null){
                        break;
                    }
                    temp=temp.next;
                }

                if(i<pos-2){
                    System.out.println("No adequate amount of elements");
                }
                else{
                    temp.next=temp.next.next;
                }
                }
        }
    }

    public static void display(){
        if(head==null) //empty list
            System.out.println("Empty list");
        else{
            Node temp=head;

            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
        }
           
    }
}