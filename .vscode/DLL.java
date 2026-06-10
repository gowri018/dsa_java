import java.util.Scanner;

class DNode{
    int data;
    DNode prev;
    DNode next;

    DNode(int data){
        this.data=data;
    }
}

public class DLL {
    public static DNode head=null;
    public static void main(String argss[]){
        Scanner sc=new Scanner(System.in);

        while(true){
            int a=sc.nextInt();
            if(a==-1){
                break;
            }
            insert_end(a);
        }
        insert_pos(3,25);
        display();
        delete_end();
        display();
        delete_pos(3);
        display();
    }

    public static void insert_begin(int data){
        DNode newnode= new DNode(data);

        if(head==null)
            head=newnode;
        else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }

    public static void insert_end(int data){
        DNode newnode= new DNode(data);
        if(head==null)
            head=newnode;
        else{
            DNode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.prev=temp;
        }
    }

    public static void insert_pos(int pos, int data){
        DNode newnode=new DNode(data);
        if(head==null){
            if(pos==1){
                head=newnode;
            }
            else{
                System.out.println("Insuffucuent no. of elements");
            }
        }

        else{
            DNode temp=head;
            int i;
            for(i=0;i<pos-2;i++){
                temp=temp.next;
            }
            if(i<pos-2){
                System.out.println("Insuffucuent no. of elements");
            }
            else{
                newnode.prev=temp.next.prev;
                newnode.next=temp.next;
                temp.next=newnode;
                temp.next.prev=newnode;
            }
        }
    }

    public static void delete_end(){
        if(head==null){
            System.out.println("Empty list!");
        }
        else{
            DNode temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.prev.next=null;
        }
    }

    public static void delete_pos(int pos){
        if(head==null){

        }
        else{
            DNode temp=head;

            int i;
            for(i=0;i<pos-1;i++){
                if(temp.next!=null){
                    temp=temp.next;
                }
            }
            if(i<pos-1){
                System.out.println("Insufficient no. of elements");
            }
            else{
                temp.prev.next=temp.next;
                temp.next.prev=temp.prev;
            }
        }
    }

    public static void display(){
        if(head==null){
            System.out.println("The list is empty");
        }
        else{
            System.out.print("Forward display: ");
            DNode temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
            System.out.print("Backward display: ");
            DNode tail=temp;
            while(tail!=null){
                System.out.print(tail.data+" ");
                tail=tail.prev;
            }
            

        }
    }
}
