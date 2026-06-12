import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Pattern01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        Queue<String> pat = new LinkedList<>();

        pat.add("1");
        
        while (count <= n) {
            count++;
            String org = pat.poll();
            System.out.println(org);
            pat.add( org + "0");
            pat.add(org + "1");
        }
    }   

}
