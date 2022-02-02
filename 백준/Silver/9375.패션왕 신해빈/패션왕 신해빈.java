import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            HashMap<String, Integer> map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            int count = 1;
            if (map.size() > 1) {
                for (int x : map.values()) {
                    count *= (x+1);
                }
            } else count = m+1;
            bw.write(count-1 + "\n");
        }
        bw.flush();
        bw.close();
    }

}

