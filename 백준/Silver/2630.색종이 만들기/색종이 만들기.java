import java.io.*;
import java.util.*;

public class Main {
    static int whiteCount = 0;
    static int blueCount = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        divide(0,0,n);
        bw.write(whiteCount+"\n");
        bw.write(blueCount+"\n");
        bw.flush();
        bw.close();
    }
    static void divide(int startX, int startY, int length){
            int blueOrWhite = arr[startX][startY];
            boolean sameColor = true;
            for(int i= startX; i<startX+length;i++){
                for(int j=startY;j<startY+length;j++){
                    if(arr[i][j]!=blueOrWhite){
                        sameColor = false;
                    }
                }
            }
            if (sameColor){
                if (blueOrWhite==1){
                    blueCount++;
                }else whiteCount++;
            }else{
                divide(startX,startY,length/2);
                divide(startX+length/2,startY,length/2);
                divide(startX,startY+length/2,length/2);
                divide(startX+length/2,startY+length/2,length/2);
            }
    }
}
