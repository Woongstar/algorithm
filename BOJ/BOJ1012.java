package BOJ1012;

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

public class BOJ1012 {


    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int BFS(int[][] map,int a, int b){

        int answer = 0;
        Queue<Location> Q = new LinkedList<>();

        for(int i=0;i<a;i++){
            for(int j=0;j<b;j++){

                if(map[i][j]==1){
                    Q.offer(new Location(i,j));
                    map[i][j]=0;
                    while(!Q.isEmpty()){
                        Location cur = Q.poll();
                        for(int k=0;k<4;k++){
                            int nx = cur.x+dx[k];
                            int ny = cur.y+dy[k];

                            if(nx<0||ny<0||nx>=a||ny>=b) continue;
                            if(map[nx][ny]==1){
                                Q.add(new Location(nx,ny));
                                map[nx][ny] = 0;
                            }
                        }
                    }
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int[][] map = new int[a][b];

            for(int j=0;j<c;j++){
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                map[d][e] = 1;
            }
            sb.append(BFS(map,a,b)).append("\n");
        }
        System.out.println(sb);
    }
}