import java.io.*;
import java.util.*;



public class Main{
    static ArrayList<List<Integer>> arr = new ArrayList<>();
    static int[] level;
    static BufferedWriter bw;
    public static void main(String []args) throws Exception{
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        level = new int[n+1];
        
        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<Integer>());
        }
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            level[y]++;
        }
        sort(n);
     
        bw.flush();
        bw.close();
     }
    static void sort(int n) throws IOException{
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        
        for(int i=1;i<=n;i++){
            if(level[i]==0){
                pQ.add(i);
            }
        }
        while(!pQ.isEmpty()){
            int x = pQ.poll();
            for(int y : arr.get(x)){
                level[y]--;
                if(level[y]==0){
                    pQ.add(y);
                }
            }
            bw.write(x+" ");
        }
    }
}