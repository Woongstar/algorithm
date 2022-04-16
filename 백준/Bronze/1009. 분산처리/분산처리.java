import java.io.*;
import java.util.*;



public class Main{

    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ans = 1;
            while(b-->0){
                ans = ans*a%10;
            }
            if(ans==0){
                ans = 10;
            }
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
    }
}