import java.io.*;
import java.util.*;

public class Main {

    static boolean[] arr = new boolean[101];
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            st = new StringTokenizer(br.readLine());
            bw.write(solution(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"\n");
        }

        bw.flush();
        bw.close();
    }
    static int solution(int M,int N, int x, int y){
        int answer = -1;
        int n = 0;
        int lcm = lcm(M,N);
        while(n*M<lcm){
            if((n*M+x-y)%N==0){
                answer = n*M+x;
            }
            n++;
        }
        return answer;
    }
    public static int lcm(int a, int b) {
        int x = a*b;
        while (b != 0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return x/a;
    }
}



