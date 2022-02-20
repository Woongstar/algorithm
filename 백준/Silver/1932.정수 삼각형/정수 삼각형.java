import java.io.*;
import java.util.*;


public class Main {


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<i+1;k++){
                dp[i][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[i][j] = Math.max(dp[i+1][j],dp[i+1][j+1])+dp[i][j];
            }
        }
        System.out.println(dp[0][0]);
    }
}



