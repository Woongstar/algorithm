import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;

    static void involved(int x, int y, int r, int startX, int startY, int targetX, int targetY) {

        if (Math.pow(startX - x, 2) + Math.pow(startY - y, 2) > Math.pow(r, 2) ^ Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2) > Math.pow(r, 2))
            count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());


            int m = Integer.parseInt(br.readLine());
            count = 0;
            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                involved(x, y, r, startX, startY, targetX, targetY);
            }
            bw.write("" + count);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
