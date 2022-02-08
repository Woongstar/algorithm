import java.io.*;
import java.util.*;



public class Main{
     static boolean[] arr;
     public static void main(String []args) throws Exception{
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st ;
       
       int target = Integer.parseInt(br.readLine());
       int n = Integer.parseInt(br.readLine());

       arr = new boolean[10];
       if(n!=0){
        st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
           arr[Integer.parseInt(st.nextToken())] = true;
       }
       }
      
       int answer = Math.abs(target-100);
       for(int i=0; i<=1000000;i++){
           int len = check(i);
           if(len>0){
               int press = Math.abs(target-i);
               answer = Math.min(answer,len+press);
           }
       }
       bw.write(answer+"");
       bw.flush();
       bw.close();
     }
     static int check(int n){
         if (n==0){
             if(arr[0]){
                 return 0;
             }else{
                 return 1;
             }
         }
         int len = 0;
         while(n>0){
             if(arr[n%10]){
                 return 0;
             }
             n /=10;
             len +=1;
         }
         return len;
     }
}