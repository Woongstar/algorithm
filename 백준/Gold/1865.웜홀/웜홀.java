import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static ArrayList<ArrayList<Point>> arr;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arr = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                arr.add(new ArrayList<>());
            }

            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (i < m) {
                    arr.get(a).add(new Point(b, c));
                    arr.get(b).add(new Point(a, c));
                } else {
                    arr.get(a).add(new Point(b, -c));
                }
            }
            boolean answer = false;
            for (int i = 1; i <= n; i++) {
                if (cycleCheck(i, n)) {
                    answer = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if (!answer) {
                sb.append("NO\n");
            }
        }
        bw.write(sb.toString()+"");
        bw.flush();
        bw.close();
    }

    static boolean cycleCheck(int start, int n) {
        boolean update = false;
        int[] dist = new int[n+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;
        for(int i=1;i<n;i++){
            update = false;

            for(int j = 1;j<=n;j++){
                for(Point x : arr.get(j)){
                    if(dist[j] !=INF &&dist[x.target]>dist[j]+x.cost){
                        dist[x.target]=dist[j]+x.cost;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }
        if(update){
            for(int j = 1;j<=n;j++){
                for(Point x : arr.get(j)){
                    if(dist[j] !=INF &&dist[x.target]>dist[j]+x.cost){
                        dist[x.target]=dist[j]+x.cost;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class Point {
    int target, cost;

    public Point(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }
}


