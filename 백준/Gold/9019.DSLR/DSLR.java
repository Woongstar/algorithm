import java.io.*;
import java.util.*;



public class Main{
  static int start, target;
    
     public static void main(String []args) throws Exception{
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringTokenizer st;
       int n = Integer.parseInt(br.readLine());
        while(n-->0){
        st = new StringTokenizer(br.readLine());
        
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        
        String s = BFS();
        
        bw.write(s+"\n");

        }
       bw.flush();
        bw.close();
     }
     static String BFS(){
         
          Queue<Integer> Q = new LinkedList();
          HashMap<Integer,String> map = new HashMap<>();
          
          Q.add(start);
          map.put(start,"");
          
          while(!Q.isEmpty()&&!map.containsKey(target)){
              int cur = Q.poll();
              if(cur==target) return map.getOrDefault(target,"");
              int D = (cur*2)%10000;
              int S = cur==0 ? 9999 : cur-1;
              int L = (cur*10 + cur/1000)%10000;
              int R = (cur%10)*1000+cur/10;
              
              if(!map.containsKey(D)){
                  Q.add(D);
                  map.put(D,map.getOrDefault(cur,"")+"D");
              }
              if(!map.containsKey(S)){
                  Q.add(S);
                 map.put(S,map.getOrDefault(cur,"")+"S");
              }
              if(!map.containsKey(L)){
                  Q.add(L);
                   map.put(L,map.getOrDefault(cur,"")+"L");
              }
              if(!map.containsKey(R)){
                  Q.add(R);
                   map.put(R,map.getOrDefault(cur,"")+"R");
              }
        
          }
          return map.getOrDefault(target,"");
}}
