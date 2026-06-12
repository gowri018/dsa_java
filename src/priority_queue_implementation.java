import java.util.Scanner;

class minheap
{
    int[] heap;
    int size;
    int capacity;
    minheap(int capacity)
    {
        this.capacity = capacity;
        heap = new int[capacity];
        size =0;
    }
    public int parent(int ind){
        return (ind - 1)/2;
    }
    public int left(int ind)
    {
        return ind*2+1;
    }
    public int right(int ind)
    {
        return ind*2+2;
    }

    public void swap(int ind1,int ind2)
    {
        int temp = heap[ind1];
        heap[ind1] = heap[ind2];
        heap[ind2] = temp;
    }

    public void insert(int val)
    {
        if(size==capacity)
        {
            System.out.println("heap is full");
            return;
        }

        heap[size] = val;
        int index = size;
        // heapifyup

        while(index > 0 && heap[index] < heap[parent(index)])
        {
           swap(index,parent(index));
           index = parent(index);
        }

        size++;
    }
    public int extract()
    {
       if(size<=0)
       {
           System.out.println("empty");
           return -1;
       }
       if(size==1)
       {
           return heap[--size];
       }

       int res = heap[0];
       heap[0] = heap[size-1];
       size--;
        heapifydown(0);
        return res ;
    }
    public void heapifydown(int index)
    {
        int small = index;
        int left = left(index);
        int right = right(index);

        if(left < size && heap[left] < heap[small])
            small = left;
        if(right < size && heap[right] < heap[small])
            small = right;

        if(small!=index)
        {
            swap(small,index);
            heapifydown(small);
        }
    }

    public void display()
    {
        int itr;
        for(itr=0;itr<size;itr+=1)
            System.out.print(heap[itr]+" ");
    }

}
public class priority_queue_implementation {
    static void main() {
        minheap h = new minheap(8);
        Scanner input = new Scanner(System.in);
        int ele;
        for(int itr=0;itr<h.capacity;itr+=1)
        {
            ele = input.nextInt();
            h.insert(ele);
        }

        h.display();

        System.out.println(h.extract());

       h.display();


    }
}
