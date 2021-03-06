import java.io.*;
public class Main {
    static int[] arr;
    public static int dp(int n){
        if(n==0||n==1) return 1;
        if(arr[n]>0) return arr[n];

        arr[n] = dp(n-1) + dp(n-2);
        arr[n] %= 10007;
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr= new int[n+1];
        System.out.println(dp(n));
    }
}

