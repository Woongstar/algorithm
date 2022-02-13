import java.io.*;
import java.util.*;

public class Main {

    static boolean[] arr = new boolean[101];
    static boolean[] visited = new boolean[101];
    static int[] count = new int[101];
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        BFS();
        bw.flush();
        bw.close();
    }

    static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(1);
        visited[1] = true;


        while (!Q.isEmpty()) {
            int cur = Q.poll();
            if (cur == 100) {
                System.out.println(count[100]);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int nx = cur + i;
                if (nx >= 101) continue;
                if (visited[nx]) continue;
                visited[nx] = true;
                if (map.containsKey(nx)) {
                    if (!visited[map.get(nx)]) {
                        Q.offer(map.get(nx));
                        visited[map.get(nx)] = true;
                        count[map.get(nx)] = count[cur]+1;
                    }
                } else {
                    Q.offer(nx);
                    count[nx] = count[cur]+1;
                }
            }
        }
    }
}



