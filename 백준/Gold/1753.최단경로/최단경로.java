import java.io. *;
import java.util. *;

public class Main {
    
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static int n;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i <= n; i ++) {
            arr.add(new ArrayList<>());
        }
        
        int start = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.get(a).add(new Node(b, c));
        }
        
        int[] dist = dijk(start);
        
        for (int i=1;i<=n;i++) {
            if (dist[i] == 100000000) 
                bw.write("INF\n");
             else {
                bw.write(dist[i] + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }
    
    public static int[] dijk(int start) {
        
        PriorityQueue < Node > pQ = new PriorityQueue<>();
        int[] answer = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        visited[start] = true;
        Arrays.fill(answer, 100000000);
        answer[start] = 0;
        pQ.add(new Node(start, 0));
        
        while (!pQ.isEmpty()) {
            Node cur = pQ.poll();
            if (cur.cost > answer[cur.target]) continue;
            for (Node x : arr.get(cur.target)){
                if (answer[x.target] > cur.cost + x.cost) {
                 answer[x.target] = cur.cost + x.cost;
                 pQ.add(new Node(x.target, cur.cost + x.cost));
                }
            } 
    }
    
    return answer;
    }
}   
class Node implements Comparable < Node > {
    int target,cost;
    public Node(int target, int cost) {
    this.target = target;
    this.cost = cost;
}
@Override public int compareTo(Node o) {
    return this.cost - o.cost;
    }
}