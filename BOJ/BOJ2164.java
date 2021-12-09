import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> Q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            Q.add(i);
        }
        while(Q.size()!=1){
            Q.poll();
            Q.offer(Q.poll());
        }
        System.out.println(Q.poll());
    }
}