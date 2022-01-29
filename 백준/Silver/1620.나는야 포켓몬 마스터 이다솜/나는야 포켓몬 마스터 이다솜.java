import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        int count = 0;
        while(n-->0){
            String s = br.readLine();
          map.put(s,String.valueOf(++count));
          map.put(String.valueOf(count),s);
        }
        while(m-->0){
            String s = br.readLine();
            bw.write(map.get(s));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
