import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFSFindRoute {

    static int[][] Graph;
    static int n;
    static int[] check;
    static int answer;

    public static void DFS(int v){
        if(v==n) answer++;
        else{
            for(int i=1;i<=n;i++){
                if(Graph[v][i]==1&&check[i]==0){
                    check[i]=1;
                    DFS(i);
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Graph = new int[n+1][n+1];
        check = new int[n+1];
        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            Graph[v1][v2] = 1;
        }
        answer=0;
        check[1]=1;
        DFS(1);
        System.out.println(answer);
    }
}