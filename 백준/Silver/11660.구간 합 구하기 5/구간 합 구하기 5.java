import java.io. *;
import java.util. *;

public class Main {
    
   
    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] -dp[i-1][j-1] + map[i][j];
            }
        }
        
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int nx = Integer.parseInt(st.nextToken());
            int ny = Integer.parseInt(st.nextToken());
            int count = 0;
            
            count = dp[nx][ny] - dp[x-1][ny] - dp[nx][y-1] + dp[x-1][y-1];
            System.out.println(count);
        }
    }
}