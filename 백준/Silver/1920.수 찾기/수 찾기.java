import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            map.put(k, 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int a = Integer.parseInt(st.nextToken());
            if (map.containsKey(a)) System.out.println(1);
            else System.out.println(0);
        }


    }
}