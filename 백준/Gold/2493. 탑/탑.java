import java.io.*;
import java.util.*;



public class Main{

    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        stack.push(new Pair(0,Integer.MAX_VALUE));
        for(int i=1;i<=n;i++){
            int k = Integer.parseInt(st.nextToken());
            while(k>stack.peek().height){
                stack.pop();
            }
            bw.write(stack.peek().index+" ");
            stack.push(new Pair(i,k));
        }
        bw.flush();
        bw.close();
    }
    static class Pair{
        int index, height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}