import java.io.*;
import java.util.*;

public class Main{

     static boolean[] visited;
     static int n;
     static int max = 0;
     static int point = 0;
     static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
     public static void main(String []args) throws Exception{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;
        n = Integer.parseInt(br.readLine());
        
       
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Node>());
        }
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
           while(true){
               int a = Integer.parseInt(st.nextToken());
               if(a==-1) break;
               int b = Integer.parseInt(st.nextToken());
               arr.get(num).add(new Node(a,b));
           }
        }
        
        visited = new boolean[n+1];
        DFS(1,0);
        visited = new boolean[n+1];
        DFS(point,0);
        
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
    static void DFS(int index, int dist){
        if(dist>max){
            max = dist;
            point = index;
        }
        visited[index] = true;
        for(Node x : arr.get(index)){
            if(!visited[x.target]){
                DFS(x.target,dist+x.cost);
                visited[x.target] = true;
            }
        }
    }
}
    class Node{
        int target, cost;
        public Node(int target, int cost){
            this.target = target;
            this.cost = cost;
        }
    }
