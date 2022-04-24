import java.io.*;
import java.util.*;

public class Main{
    
     public static void main(String []args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         int n = Integer.parseInt(br.readLine());
         Stack<Integer> stack = new Stack<>();
         
         StringTokenizer st;
         for(int i=0;i<n;i++){
             st = new StringTokenizer(br.readLine());
             switch(st.nextToken()){
                 case "push":
                     stack.push(Integer.parseInt(st.nextToken()));
                     break;
                 case "top":
                     if(!stack.isEmpty()) System.out.println(stack.peek());
                    else System.out.println(-1);
                    break;
                 case "size":
                     System.out.println(stack.size());
                     break;
                 case "pop":
                     if(!stack.isEmpty()) System.out.println(stack.pop());
                    else System.out.println(-1);
                    break;
                 case "empty":
                     if(stack.isEmpty()) System.out.println(1);
                     else System.out.println(0);
                     break;
             }
         }
     }
}