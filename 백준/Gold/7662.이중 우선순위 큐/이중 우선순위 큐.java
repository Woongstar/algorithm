import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {

            int m = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            int count =0;
            while (m-->0) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                int b = Integer.parseInt(st.nextToken());
                if(a.equals("I")) {
                    map.put(b,map.getOrDefault(b,0)+1);
                }else{
                    if(map.isEmpty()) continue;
                    if(b==1){
                        int max = map.lastKey();
                        if(map.get(max)-1==0) map.remove(max);
                        else map.put(max,map.get(max)-1);
                    }else{
                       int min = map.firstKey();
                        if(map.get(min)-1==0) map.remove(min);
                        else map.put(min,map.get(min)-1);
                    }
                }

            }
            if (map.isEmpty()) bw.write("EMPTY\n");
            else bw.write(map.lastKey()+" "+map.firstKey()+"\n");
        }

        bw.flush();
        bw.close();
    }
}

