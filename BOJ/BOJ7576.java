import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y;
    Point(int x,int y){
        this.x =x;
        this.y = y;
    }
}

public class BOJ7576{

    static int n,m;
    static int[][] board, dist;
    static Queue<Point> Q = new LinkedList<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static void BFS(){
        while(!Q.isEmpty()){
            Point cur = Q.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x+dx[i];
                int ny = cur.y+dy[i];

                if(nx>=0&&ny>=0&&nx<n&&ny<m&&board[nx][ny]==0){
                    board[nx][ny]=1;
                    Q.add(new Point(nx,ny));
                    dist[nx][ny] = dist[cur.x][cur.y] + 1;
                }
            }
        }
    }


    public static void main(String []args)throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        dist = new int[n][m];

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1) Q.offer(new Point(i,j));
            }
        }
        BFS();
        boolean flag = true;
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==0) flag= false;
                answer = Math.max(dist[i][j],answer);
            }
        }
        System.out.println(flag ? answer:-1);
    }
}