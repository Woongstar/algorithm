import java.io.*;
import java.util.*;

public class Main{
    
     public static void main(String []args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         int n = Integer.parseInt(st.nextToken());
         int m = Integer.parseInt(st.nextToken());
         
         Queue<Integer> Q = new LinkedList<>();
         for(int i=1; i<=n;i++){
             Q.offer(i);
         }
         StringBuilder answer = new StringBuilder();
         answer.append("<");
         while(Q.size()>1){
             for(int i=0;i<m-1;i++){
                 Q.offer(Q.poll());
             }
             answer.append(Q.poll()+", ");
         }
        answer.append(Q.poll()+">");
        System.out.println(answer);
     }
}