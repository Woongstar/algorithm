import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                if(pQ.isEmpty()) bw.write("0\n");
                else bw.write(pQ.poll()+"\n");
            }else{
                pQ.add(a);
            }
        }

        bw.flush();
        bw.close();
    }
}

