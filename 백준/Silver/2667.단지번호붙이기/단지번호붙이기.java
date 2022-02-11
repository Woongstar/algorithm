import java.io.*;
import java.util.*;



public class Main{
    static boolean[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n,k;
    static ArrayList<Integer> arr = new ArrayList<>();
     public static void main(String []args) throws Exception{
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       
        n = Integer.parseInt(br.readLine());
         map = new boolean[n][n];
         visited = new boolean[n][n];
         
        
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<n;j++){
                if(s.charAt(j)=='1') map[i][j] = true;
                else map[i][j] = false;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] && !visited[i][j]) {
                    k=0;
                    visited[i][j] = true;
                    DFS(i,j);
                    count++;
                    arr.add(k);
                }
            }
        }
        
        Collections.sort(arr);
        System.out.println(count);
        for(int x: arr){
            System.out.println(x);
        }
        
    }
    
    static void DFS(int x, int y){
        k++;
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0&&nx<n&&ny>=0&&ny<n){
                
            if(map[nx][ny]==true && !visited[nx][ny]){
                visited[nx][ny] = true;
                DFS(nx,ny);
             }
            
            }
        }
    }
}