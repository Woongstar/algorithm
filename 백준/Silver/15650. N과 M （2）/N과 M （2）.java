import java.io.*;
import java.util.*;



public class Main{
    
    static int[] arr;
    static boolean[] visited;
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
        visited = new boolean[n];
        stack = new Stack<>();
        permutation(n,m,0);
        System.out.println(sb);

    }
     
     static void permutation(int n,int m,int index){
         if(stack.size()==m){
             for(int x: stack){
                 sb.append(x+" ");
             }
             sb.append("\n");
             return;
         }
         for(int i=index;i<n;i++){
             if(!visited[i]){
                 visited[i] = true;
                 stack.push(arr[i]);
                 permutation(n,m,i);
                 stack.pop();
                 visited[i] = false;
             }
         }
     }
}