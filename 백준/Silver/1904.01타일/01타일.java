import java.io.*;

public class Main {
    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr[0]=0;
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        arr[4]=5;
        System.out.println(dp(n));
    }
    public static int dp(int n){
        if(arr[n]==0){
            arr[n] = dp(n-1) + dp(n-2);
            arr[n] %=15746;
        }
        return arr[n];
    }
}

