package BOJ4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y, date;

    Point(int x, int y, int date) {
        this.x = x;
        this.y = y;
        this.date = date;
    }
}

public class BOJ4179 {

    static int n, m;
    static char[][] map;
    static Queue<Point> JQ, FQ;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer;

    static boolean BFS() {
        while (!JQ.isEmpty()) {

            int size = FQ.size();

            for (int i = 0; i < size; i++) {

                Point cur = FQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        FQ.add(new Point(nx, ny, cur.date + 1));
                    }
                }
            }
            size = JQ.size();
            for (int i = 0; i < size; i++) {
                Point cur = JQ.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        answer = cur.date + 1;
                        return true;
                    }
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'J';
                        JQ.add(new Point(nx, ny, cur.date + 1));
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];

        JQ = new LinkedList<>();
        FQ = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                char a = arr[j];
                map[i][j] = a;
                if (a == 'J') JQ.add(new Point(i, j, 0));
                if (a == 'F') FQ.add(new Point(i, j, 0));
            }
        }
        System.out.println(BFS() ? answer : "IMPOSSIBLE");
    }
}