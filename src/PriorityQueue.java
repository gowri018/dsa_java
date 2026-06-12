import java.util.Scanner;

class minheap{
    int[] heap;
    int size;
    int capacity;

    minheap(int capacity){
        this.capacity=capacity;
        heap=new int[capacity];
        size=0;
    }

    public int parent(int child){
        return (child-1)/2;
    }

    public int left(int parent){
        return parent*2+1;
    }

    public int right(int parent){
        return parent*2+2;
    }

    public void swap(int i, int j){
        int temp=heap[i];
        heap[j]=heap[i];
        heap[i]=temp;
    }

    public void insert(int val){
        if(size==capacity)
            System.out.println("The heap is at it's maximum capacity");
        else{
            heap[size]=val;
            int index=size;
           
            //heapifyup
            while(index>0 && heap[index]<heap[parent(index)]){
                swap(index,parent(index));
                index=parent(index);
            }
            size++;
        }
    }

    public int extract(){
        if(size<=0){
            System.out.println("Heap is empty");
        }
        if(size==1)
            return heap[--size];
        int res=heap[0];
        

    }

    
}
public class PriorityQueue {
    public static void main(String args[]){
        minheap h=new minheap(8);

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<8;i++){
            int a=sc.nextInt();
            h.insert(a);
        }

        for(int i=0;i<8;i++){
            System.out.print(h.heap[i]+" ");
        }
    }

}
