import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long a = Long.parseLong(st.nextToken());
        Long b = Long.parseLong(st.nextToken());
        Long c = Long.parseLong(st.nextToken());

        System.out.println(cal(a,b,c)%c);
    }
    static Long cal(Long a, Long b, Long c){
        if(b==0){
            return 1L;
        }else if(b==1){
            return a;
        }else if(b%2==0){
            long n = cal(a,b/2,c)%c;
            return n*n %c;
        }else{
            long n = cal(a, b / 2, c) % c;
            return (((n * n) % c) * a) % c;
        }
    }
}