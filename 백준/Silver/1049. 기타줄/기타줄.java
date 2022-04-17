import java.io.*;
import java.util.*;



public class Main{

    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int minA = 1001;
        int minB = 1001;
        while(m-->0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            minA = Math.min(a,minA);
            minB = Math.min(b,minB);
        }
        int ans = Math.min(minA*(n/6+1),Math.min(minA*(n/6)+minB*(n%6),minB*n));


       bw.write(ans+"");
        bw.flush();
        bw.close();
    }
}