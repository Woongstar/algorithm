import java.io.*;
import java.util.*;



public class Main{
    
    static int[] arr;
    static Stack<Integer> stack;
    static StringBuilder sb;
    public static void main(String []args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
       
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
      
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        stack = new Stack<>();
        permutation(n,m);
        System.out.println(sb);

    }
     
     static void permutation(int n,int m){
         if(stack.size()==m){
             for(int x: stack){
                 sb.append(x+" ");
             }
             sb.append("\n");
             return;
         }
         for(int i=0;i<n;i++){
             if(stack.isEmpty()||stack.peek()<=arr[i]){
                 stack.push(arr[i]);
                 permutation(n,m);
                 stack.pop();
             }
         }
     }
}