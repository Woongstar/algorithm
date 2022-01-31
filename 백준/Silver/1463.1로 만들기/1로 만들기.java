import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n>=3?n+1:3];
        arr[0] = 0;
        arr[1] = 0;
        for(int i=2;i<=n;i++){
            arr[i] = Math.min(arr[i-1]+1,Math.min(i%2==0?arr[i/2]+1:Integer.MAX_VALUE,i%3==0?arr[i/3]+1:Integer.MAX_VALUE));
        }
        bw.write(arr[n]+"\n");
        bw.flush();
        bw.close();
    }
}
