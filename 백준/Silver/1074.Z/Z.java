import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        divide(0, 0, n);
        System.out.println(count);
    }

    public static void divide(int startX, int startY, int length) {
        if (length == 1) return;
        length = length / 2;
        if(y>=startX&&y<startX+length&&x>=startY&&x<startY+length){
            divide(startX, startY, length);
        }else if(y>=startX+length&&y<startX+2*length&&x>=startY&&x<startY+length){
            count += length*length;
            divide(startX+length, startY, length);
        }else if(y>=startX&&y<startX+length&&x>=startY+length&&x<startY+2*length){
            count += length*length*2;
            divide(startX, startY+length, length);
        }else if(y>=startX+length&&y<startX+2*length&&x>=startY+length&&x<startY+2*length){
            count += length*length*3;
            divide(startX+length, startY+length, length);
        }
    }

}

