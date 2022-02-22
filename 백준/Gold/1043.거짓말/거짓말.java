import java.io.*;
import java.util.*;

public class Main{
    static  HashSet<Integer> knowPeople;
    static boolean[] know;
    static int n,m;
    static ArrayList<ArrayList<Integer>> map = new ArrayList<>();
     public static void main(String []args) throws Exception{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int knowLength = Integer.parseInt(st.nextToken());
        knowPeople = new HashSet<>();
        know = new boolean[m];
        for(int i=0;i<knowLength;i++){
            knowPeople.add(Integer.parseInt(st.nextToken()));
        }
        
        for(int i=0;i<m;i++){
            map.add(i,new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=0;j<num;j++){
                int input = Integer.parseInt(st.nextToken());
                map.get(i).add(input);
            }
        }
        for(int known : knowPeople){
            DFS(known);
        }
        int count=0;
        for(int i=0;i<m;i++){
            if(!know[i]) count++;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
     }
     static void DFS(int known){
        for(int i=0;i<m;i++){
            if(!know[i]){
            if(map.get(i).contains(known)){
                    know[i] = true;
                for(int x: map.get(i)){
                    DFS(x);
                }
            }

            }
        }
     }
}