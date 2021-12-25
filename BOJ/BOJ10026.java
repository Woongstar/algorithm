package BOJ10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Location{
    int x,y;
    char z;
    Location(int x, int y, char z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class BOJ10026 {


    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        char[][] map, greenmap;
        map = new char[n][n];
        greenmap = new char[n][n];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<n;j++){
            map[i][j] = s.charAt(j);
            if(map[i][j]=='R') greenmap[i][j] = 'G';
            else greenmap[i][j] = s.charAt(j);
            }
        }
        System.out.println(BFS(map)+" "+BFS(greenmap));
    }

    static int BFS(char[][] map){
        int answer=0;
        boolean[][] mapvisited = new boolean[n][n];
        Queue<Location> Q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){

                if(mapvisited[i][j]==false) {
                    Q.add(new Location(i, j, map[i][j]));
                    answer++;
                }
                while(!Q.isEmpty()){
                    Location cur = Q.poll();
                    for(int k=0;k<4;k++){

                        int nx = cur.x+dx[k];
                        int ny = cur.y+dy[k];

                        if(nx<0||ny<0||nx>=n||ny>=n) continue;
                        if(mapvisited[nx][ny]==false&&map[nx][ny]==cur.z){
                            mapvisited[nx][ny] = true;
                            Q.add(new Location(nx,ny,cur.z));
                        }
                    }
                }
            }
        }
        return answer;
    }

}