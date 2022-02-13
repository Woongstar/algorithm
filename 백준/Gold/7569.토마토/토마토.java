import java.io.*;
import java.util.*;

class Tomato{
    int h,i,j;

    public Tomato(int h, int i, int j) {
        this.h = h;
        this.i = i;
        this.j = j;
    }
}

public class Main {

    static int[][][] map;
    static boolean[][][] visited;
    static int[] di = {0,0,1,0,-1,0};
    static int[] dj = {0,0,0,1,0,-1};
    static int[] dh = {1,-1,0,0,0,0};
    static int m,n,h;
    static int max = 1;
    static Queue<Tomato> Q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];
        visited = new boolean[h][n][m];


        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                   int a = Integer.parseInt(st.nextToken());
                   map[k][i][j] = a;
                   if(a==1){
                        Q.add(new Tomato(k,i,j));
                        visited[k][i][j] = true;
                   }
                }
            }
        }

        BFS();
        boolean full = true;
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {

                    if(map[k][i][j] ==0) full =false;
                }
            }
        }
        bw.write(full ? max-1+"":-1+"");
        bw.flush();
        bw.close();
    }
    static void BFS(){

        while(!Q.isEmpty()){
            Tomato cur = Q.poll();
            for(int i=0;i<6;i++){
                int ni = cur.i+di[i];
                int nj = cur.j+dj[i];
                int nh = cur.h+dh[i];
                if(ni<0||nj<0||nh<0||ni>=n||nj>=m||nh>=h) continue;
                if(map[nh][ni][nj]==0&&!visited[nh][ni][nj]){
                    Q.add(new Tomato(nh,ni,nj));
                    map[nh][ni][nj]=map[cur.h][cur.i][cur.j]+1;
                    visited[nh][ni][nj] = true;
                    max = Math.max(max,map[nh][ni][nj]);
                }
            }
        }
    }
}



