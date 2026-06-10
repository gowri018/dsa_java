import java.util.Scanner;

class CNode{
    int data;
    CNode prev;
    CNode next;

    CNode(int data){
        this.data=data;
    }
}
public class CDLL {
    public static CNode head=null;

    public static void mian(String args[]){
        Scanner sc=new Scanner(System.in);

        while(true){
            int a=sc.nextInt();
            if(a==-1){
                break;
            }
            insert_end(a);
        }
        display();

    }

    public static void insert_end(int val){
        CNode newnode=new CNode(val);

        if(head==null){
            head=newnode;
            head.prev=head;
            head.next=head;
        }
        else{
            CNode temp=head;
            while(temp.next!=head){
                temp=temp.next;
            }
            newnode.next=head;
            newnode.prev=temp;
            temp.next=newnode;
            head.prev=newnode;
        }
    }

    public static void display(){
        if(head==null){
            return;
        }
        else{
            CNode temp=head;
            do{
                System.out.print(temp.data+" ");
                temp=temp.next;
            }while(temp!=head);
        }
    }

}
