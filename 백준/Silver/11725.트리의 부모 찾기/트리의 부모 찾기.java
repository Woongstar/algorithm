import java.io. *;
import java.util. *;
public class Main {
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for(int i=0;i<=n;i++){
            arr.add(i,new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());    
            
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        
        boolean[] visited = new boolean[n+1];
        int[] answer = new int[n+1];
        
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        
        while(!Q.isEmpty()){
            
            int cur = Q.poll();
            for(int x: arr.get(cur)){
                if(!visited[x]){
                    visited[x] = true;
                    answer[x] = cur;
                    Q.add(x);
                }
            }
        }
        for(int i=2;i<n+1;i++){
            bw.write(answer[i]+"\n");
        }
        bw.flush();
        bw.close();
    }
}