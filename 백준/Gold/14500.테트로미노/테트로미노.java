import java.io.*;
import java.util.*;



public class Main{
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,m;
    static int max = 0;
     public static void main(String []args) throws Exception{
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st  = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       
       map = new int[n][m];
       visited = new boolean[n][m];
       
       for(int i=0;i<n;i++){
           st = new StringTokenizer(br.readLine());
           for(int j=0;j<m;j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       
       for(int i=0;i<n;i++){
           for(int j=0;j<m;j++){
               DFS(i,j,1,map[i][j]);
              calEcept(i,j);
           }
       }
       
     
       bw.write(max+"");
       bw.flush();
       bw.close();
     }
     
     static void DFS(int x, int y, int count, int point){
         visited[x][y] = true;
         if(count>4) return;
         if(count==4){
             max = Math.max(max,point);
             return;
         }
         for(int i=0;i<4;i++){
             int nx = x+dx[i];
             int ny = y+dy[i];
             if(nx<0||ny<0||nx>=n||ny>=m) continue;
             if(!visited[nx][ny]){
                 visited[nx][ny] = true;
                 DFS(nx,ny,count+1,point+map[nx][ny]);
                 visited[nx][ny] = false;
             }
         }
         visited[x][y] = false;
     }
     
     static void calEcept(int x, int y){
         int wing = 4; 
         int sum=map[x][y];
         int min = 1000;
         for(int i=0;i<4;i++){
             
             int nx = x+dx[i];
             int ny = y+dy[i];
             
             if(wing<=2) return;
             if(nx<0||ny<0||nx>=n||ny>=m){
                 wing--;
                 continue;
             }
             
             int a = map[nx][ny];
             sum+=a;
             min = Math.min(min,a);
         }
        if(wing==4) sum = sum-min;
         max=Math.max(max,sum);
     }
    
}