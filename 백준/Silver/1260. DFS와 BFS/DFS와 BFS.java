import java.io.*;
import java.util.*;



public class Main{
    
    static boolean[][] map;
    static boolean[] visited;
    static int node, line, start;
     public static void main(String []args) throws Exception{
         BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());
         
         node = Integer.parseInt(st.nextToken());
         line = Integer.parseInt(st.nextToken());
         start = Integer.parseInt(st.nextToken());
         
         map = new boolean[node+1][node+1];
         visited = new boolean[node+1];
         
         while(line-->0){
             st = new StringTokenizer(br.readLine());
             int go = Integer.parseInt(st.nextToken());
             int end = Integer.parseInt(st.nextToken());
             map[go][end] = true;
             map[end][go] = true;
         }
         DFS(start);
         System.out.println();
         visited = new boolean[node+1];
         BFS(start);
     }
     static void BFS(int start){
         Queue<Integer> Q = new LinkedList<>();
         Q.add(start);
         visited[start] = true;
         while(!Q.isEmpty()){
             int cur = Q.poll();
             System.out.print(cur+" ");
             for(int i=1;i<=node;i++){
                 if(map[cur][i]==true && !visited[i]){
                     Q.add(i);
                     visited[i] = true;
                 }
             }
         }

     }
     static void DFS(int start){
         visited[start] = true;
         System.out.print(start+" ");
         for(int i=1;i<=node;i++){
             if(map[start][i] &&!visited[i]){
                 DFS(i);
             }
         }

     }
}