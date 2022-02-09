import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int x=0;x<n;x++){
                for(int y=0;y<n;y++){
                    if(map[x][i]==1&&map[i][y]==1){
                        map[x][y]=1;
                    }
                }
            }
        }
        for(int x=0;x<n;x++){
            for(int y=0;y<n;y++){
                bw.write(map[x][y]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    }



