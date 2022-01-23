import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[1000001];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < Math.sqrt(b + 1); i++) {
            if(arr[i]) continue;;
            for (int j = i + i; j <= 1000000; j += i) {
                arr[j] = true;
            }
        }
        for(int i=a;i<=b;i++){
            if(!arr[i])bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
