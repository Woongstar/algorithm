import java.io.*;
import java.util.*;

public class Main{
        
    public static void main(String []args) throws IOException{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Long> stack = new Stack<>();

        for(int i=0; i<N; i++) {
           Long input = Long.parseLong(br.readLine());

           while(!stack.isEmpty()) {
               if(stack.peek()<=input)
                   stack.pop();
               else
                   break;
           }
           cnt += stack.size();
           stack.push(input);
        }
        System.out.println(cnt);
    }
}