import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static int one = 0;
    static int zero = 0;
    static int mOne = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        devide(0, 0, n);
        bw.write(mOne + "\n");
        bw.write(zero + "\n");
        bw.write(one + "\n");
        bw.flush();
        bw.close();
    }

    static void devide(int startX, int startY, int length) {
        boolean same = true;
        int num = map[startX][startY];
        for (int i = startX; i < startX+length; i++) {
            for (int j = startY; j < startY+length; j++) {
                if (map[startX][startY] != map[i][j]) {
                    same = false;
                }
            }
        }
        if (same) {
           if(num==1){
               one++;
           }else if(num==0){
               zero++;
           }else{
               mOne++;
           }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    devide(startX + (i * length / 3), startY + (j * length / 3), length / 3);
                }
            }
        }
    }
}


