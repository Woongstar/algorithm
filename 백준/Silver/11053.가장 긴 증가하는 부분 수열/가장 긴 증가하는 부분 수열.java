import java.io.*;
import java.util.*;



public class Main{

    public static void main(String []args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                
                if(input[j]<input[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);
                }
            }
            answer = Math.max(answer,dp[i]);
        }

        
        bw.write(answer+"");
        bw.flush();
        bw.close();
    }
}