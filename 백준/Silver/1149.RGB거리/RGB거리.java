import java.io.*;
import java.util.*;


public class Main {


    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                input[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = input[0][0];
        dp[0][1] = input[0][1];
        dp[0][2] = input[0][2];

        for(int i=1;i<n;i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+input[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+input[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+input[i][2];
        }
        System.out.println(Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2])));
    }
}



