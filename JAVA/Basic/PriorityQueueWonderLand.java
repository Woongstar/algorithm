package WonderLandPriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int start, cost;
    Edge(int start, int cost){
        this.start = start;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob){
        return this.cost - ob.cost;
    }
}

public class PriorityQueueWonderLand{
    static int[] check;


    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        check = new int[n+1];
        ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b,cost));
            graph.get(b).add(new Edge(a,cost));
        }

        int answer = 0;
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(1,0));
        while(!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int tmpStart = tmp.start;
            if(check[tmpStart]==0){
                check[tmpStart] = 1;
                answer += tmp.cost;
                for(Edge ob: graph.get(tmpStart)){
                    if(check[ob.start]==0) pQ.offer(new Edge(ob.start, ob.cost));
                }
            }
        }
        System.out.println(answer);
    }
}