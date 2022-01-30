import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Boolean> map = new HashMap<>();
        while(n-->0){
            map.put(br.readLine(), true);
        }
        ArrayList<String> arr = new ArrayList<>();
        while(m-->0){
            String s = br.readLine();
            if(map.getOrDefault(s,false)){
               arr.add(s);
            }
        }
        Collections.sort(arr);
        bw.write(arr.size()+"");
        bw.newLine();
        for(String x:arr){
            bw.write(x);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
