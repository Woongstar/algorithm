import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Node>> arr = new ArrayList<>();
    static int point = 0;
    static int n;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for(int i=0;i<=n;i++){
            arr.add(new ArrayList<>());
        }

        for (int i=0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr.get(a).add(new Node(b,c));
            arr.get(b).add(new Node(a,c));
        }
        visited = new boolean[n+1];
        DFS(1,0);
        visited = new boolean[n+1];
        DFS(point,0);
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
    static void DFS(int index, int dist){
        if(dist>max){
        max = dist;
        point = index;
        }
        visited[index] = true;
        for(Node x: arr.get(index)){
            if(!visited[x.target]) {
                DFS(x.target, dist + x.cost);
            }
        }
    }

}

class Node{
    int target,cost;

    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}
