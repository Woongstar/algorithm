import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int bitMasking = 0;
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int a = 0;
            switch (s) {
                case "add":
                    a = Integer.parseInt(st.nextToken());
                    bitMasking = bitMasking| 1<<(a-1);
                    break;
                case "remove":
                    a = Integer.parseInt(st.nextToken());
                    bitMasking = bitMasking & ~(1<<(a-1));
                    break;
                case "check":
                    a = Integer.parseInt(st.nextToken());
                    if((bitMasking & (1<<(a-1))) == (1<<a-1)){
                        bw.write(1+"\n");
                    }else{
                        bw.write(0+"\n");
                    }
                    break;
                case "toggle":
                    a = Integer.parseInt(st.nextToken());
                    bitMasking = bitMasking ^ 1<<(a-1);
                    break;
                case "all":
                    bitMasking = ~0;
                    break;
                case "empty":
                    bitMasking = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}
