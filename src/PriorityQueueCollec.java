// import java.util.ArrayDeque;
// import java.util.Deque;
import java.util.PriorityQueue;

public class PriorityQueueCollec {
    public static void main(String[] args) {
        // Deque<Integer> queue = new ArrayDeque<>();
        //PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); //uses maxheap
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); //uses minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (Integer a, Integer b) -> b-a    //descending order
        ); 

        pq.offer(18);
        pq.offer(7);
        pq.offer(72);
        pq.offer(45);
        

        while (!pq.isEmpty()) {
            System.out.print(pq.poll()+" ");
        }
        
    }
}
