import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ1697 {

    static int target, n, answer;
    static int[] visited=new int[100001];
    static void BFS(){
    Queue<Integer> Q = new LinkedList<>();
    Q.offer(n);
    while(!Q.isEmpty()){
        int n = Q.poll();
        if(n==target) break;
        if(n>0&&visited[n-1]==0){
            Q.offer(n-1);
            visited[n-1] =visited[n]+1;
        }
        if(n<100000&&visited[n+1]==0){
            Q.offer(n+1);
            visited[n+1] = visited[n]+1;
        }
        if(n*2<=100000&&visited[2*n]==0){
            Q.offer(n*2);
            visited[2*n] = visited[n]+1;
        }
    }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         target = Integer.parseInt(st.nextToken());
         if(n==target){
             System.out.println(0);
             System.exit(0);
         }
        BFS();
        System.out.println(visited[target]);
    }
}