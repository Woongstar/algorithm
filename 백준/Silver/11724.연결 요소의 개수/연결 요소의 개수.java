import java.io.*;
import java.util.*;

public class Main {

    static boolean[] visited;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        map = new boolean[n+1][n+1];
        int count = 0;
        for(int i=1;i<=m;i++){

            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = true;
            map[end][start] = true;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                DFS(i,n);
                count++;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
    static void DFS(int a,int n){
        visited[a] = true;
        for(int i=1;i<=n;i++){
            if(map[a][i]&& !visited[i]){
                DFS(i,n);
            }
        }
    }
}

