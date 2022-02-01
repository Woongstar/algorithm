import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] hacked;
    static int count = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        hacked = new boolean[n+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(i,new ArrayList<Integer>());
        }
       while(m-->0){
           st= new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           arr.get(a).add(b);
           arr.get(b).add(a);
       }
       DFS(1,arr);
       bw.write(count+"");
        bw.flush();
        bw.close();
    }
    static void DFS(int a,ArrayList<ArrayList<Integer>> arr){
        hacked[a] = true;
        for(int x: arr.get(a)){
            if(hacked[x]==false){
                count++;
                DFS(x,arr);
            }
        }
    }
}
