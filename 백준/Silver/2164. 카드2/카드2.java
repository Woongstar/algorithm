import java.io.*;
import java.util.*;

public class Main {

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