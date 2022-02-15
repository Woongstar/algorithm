import java.io.*;
import java.util.*;
class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int sharkSize = 2;
    static int minX, minY, minDist;
    static int eatingCount = 0;
    static int count=0;
    static int n;
    static int startX=0, startY=0;
    
     public static void main(String []args) throws IOException{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0;i<n;i++){
          
            st = new StringTokenizer(br.readLine());
            
            for(int j=0;j<n;j++){
                
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if(map[i][j] == 9){
                    startX = i;
                    startY = j;
                    map[i][j] = 0;
                }
            }
        }
        while(true){
            dist = new int[n][n];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;
            
            BFS(startX,startY);
            if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE){
                eatingCount++;
                map[minX][minY] = 0;
                startX = minX;
                startY = minY;
                count +=dist[minX][minY];
                
                if(eatingCount == sharkSize){
                    sharkSize++;
                    eatingCount=0;
                }
            }else break;
        }
                    
        System.out.println(count);
     }
     
     static void BFS(int x, int y){
         
         Queue<Point> Q = new LinkedList<>();
         Q.add(new Point(x,y));
         
         while(!Q.isEmpty()){
             Point cur = Q.poll();
             
             for(int i=0;i<4;i++){
                 int nx = cur.x+dx[i];
                 int ny = cur.y+dy[i];
                 
                 if(inArea(nx,ny)&&canMove(nx,ny)&&dist[nx][ny]==0){
                     dist[nx][ny] = dist[cur.x][cur.y]+1;
                     
                     if(canEat(nx,ny)){
                         if(dist[nx][ny]<minDist){
                             minDist = dist[nx][ny];
                             minX = nx;
                             minY = ny;
                         }else if(dist[nx][ny]==minDist){
                             if(minX==nx){
                                 if(minY>ny){
                                     minX = nx;
                                     minY = ny;
                                 }
                             }else if(minX>nx){
                                 minX = nx;
                                 minY = ny;
                             }
                         }
                     }
                     Q.add(new Point(nx,ny));
                 }
             }
         }
     }
     
     static boolean canMove(int x, int y){
         return map[x][y] <= sharkSize;
     }
     
     static boolean canEat(int x, int y){
         return map[x][y] !=0 && map[x][y] < sharkSize;
     }
     
     static boolean inArea(int x, int y){
         return x<n && x>=0 && y<n && y>=0;
     }
}