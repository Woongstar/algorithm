import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        while(n-->0){
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if (pQ.isEmpty()) bw.write(0+"\n");
                        else bw.write(pQ.poll()+"\n");
            }else{
                pQ.add(x);
            }
        }
        bw.flush();
        bw.close();

    }

}

