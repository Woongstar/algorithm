import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        int[] level = new int[n+1];
        for(int i=0;i<n+1;i++) arr.add(new ArrayList<>());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.get(x).add(y);
            level[y]++;
        }
        topolSort(level, arr,n);
        bw.flush();
        bw.close();
    }
    static void topolSort(int[] level,List<List<Integer>> arr,int n){
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
            System.out.print(x+" ");
        }
    }
}



