import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Binary_generate_queue {
    static void main() {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();

        Queue<String> que = new LinkedList<>();

        que.add("1");

        for(int itr=1;itr<=num;itr+=1)
        {
            String cur = que.poll();
            System.out.println(cur+" ");

            que.add(cur +"0");
            que.add(cur +"1");
        }

    }
}
