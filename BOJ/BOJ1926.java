//문제
//        어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라. 단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자. 가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다. 그림의 넓이란 그림에 포함된 1의 개수이다.
//
//        입력
//        첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다. 두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)
//
//        출력
//        첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라. 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
//
//        예제 입력 1
//        6 5
//        1 1 0 1 1
//        0 1 1 0 0
//        0 0 0 0 0
//        1 0 1 1 1
//        0 0 1 1 1
//        0 0 1 1 1
//        예제 출력 1
//        4
//        9

import java.io.*;
import java.util.*;

class Location{
    int x,y;
    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BOJ1926{
    static int n,m;
    static int[][] visited;
    static int[][] map;
    static int max,count;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int BFS(Location location){
        Queue<Location> Q = new LinkedList<>();
        Q.add(location);
        int area = 1;

        while(!Q.isEmpty()){
            Location cur = Q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx<0||ny<0||nx>=n||ny>=m) continue;
                if(visited[nx][ny]==1||map[nx][ny]==0) continue;
                visited[nx][ny] = 1;
                Q.add(new Location(nx,ny));
                area++;
            }
        }
        return max = Math.max(area,max);
    }

    public static void main(String []args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        max=0;
        count=0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1&&visited[i][j]!=1){
                    visited[i][j]=1;
                    BFS(new Location(i,j));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
}