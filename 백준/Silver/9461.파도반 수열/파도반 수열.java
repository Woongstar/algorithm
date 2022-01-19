import java.io.*;

public class Main {
    static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        arr[0]=0L;
        arr[1]=1L;
        arr[2]=1L;
        arr[3]=1L;
        while(n-->0){
            sb.append(dp(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.println(sb);
    }
    public static long dp(int n){
        if(arr[n]==null){
            arr[n] = dp(n-2) + dp(n-3);
        }
        return arr[n];
    }
}

