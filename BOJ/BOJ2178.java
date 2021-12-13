package BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
    int x,y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ2178{
    static int n,m;
    static int[][] visited;
    static int[][] map;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void BFS(Location location){
        Queue<Location> Q = new LinkedList<>();
        Q.add(location);
        while(!Q.isEmpty()){
            Location cur = Q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visited[nx][ny]==1||map[nx][ny]==0) continue;
                map[nx][ny] = map[cur.x][cur.y]+1;
                visited[nx][ny] = 1;
                Q.add(new Location(nx,ny));
            }
        }
    }

    public static void main(String []args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for(int i=0;i<n;i++){
            char[] line = br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                map[i][j] = Character.getNumericValue(line[j]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1&&visited[i][j]!=1){
                    visited[i][j]=1;
                    BFS(new Location(i,j));
                }
            }
        }
        System.out.println(map[n-1][m-1]);
    }
}