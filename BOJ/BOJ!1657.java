package BOJ11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Point {
    int x, y, cost;

    Point(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

class BOJ11657 {

    static int n, m;
    static long[] dist;
    static ArrayList<Point> points = new ArrayList<>();
    private static final Long INF = Long.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new long[n + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y, cost));
        }

        if (BellmanFord()) {
            for (int i = 2; i <= n; i++) {
                System.out.println((dist[i]==INF)? -1 : dist[i]);
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean BellmanFord() {
        dist[1] = 0L;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Point cur = points.get(j);
                int x = cur.x;
                int y = cur.y;
                int cost = cur.cost;

                if (dist[x] != INF && dist[y] > dist[x] + cost) {
                    dist[y] = dist[x] + cost;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            Point cur = points.get(i);
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;
            if (dist[x] != INF && dist[y] > dist[x] + cost) {
                return false;
            }
        }
        return true;
    }
}