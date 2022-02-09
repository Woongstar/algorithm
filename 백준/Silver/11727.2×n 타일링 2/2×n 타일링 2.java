import java.io.*;


public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 3;
        for(int i=3;i<=n;i++){
            arr[i] = (arr[i-1]+2*arr[i-2])%10007;
        }
        bw.write(arr[n]+"");
        bw.flush();
        bw.close();

    }
    }

