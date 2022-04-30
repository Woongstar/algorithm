import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> stack = new Stack<>();
        long count=0;
        for(int i=0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            Pair tmp = new Pair(k,1);
            while(!stack.empty()&&stack.peek().height<=k){
                Pair pop = stack.pop();
                count+= pop.c;
                if(pop.height == k) tmp.c+= pop.c;
            }
            if(!stack.isEmpty()) count++;
            stack.push(tmp);
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
class Pair{
    int height, c;

    public Pair(int height, int c) {
        this.height = height;
        this.c = c;
    }
}