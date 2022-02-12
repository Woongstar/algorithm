import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) -> {
            return Math.abs(o1)==Math.abs(o2) ? Integer.compare(o1,o2) : Integer.compare(Math.abs(o1),Math.abs(o2));
        });
        while(n-->0){
            int a = Integer.parseInt(br.readLine());
            if(a==0) bw.write(pQ.isEmpty()?"0\n":pQ.poll()+"\n");
            else pQ.add(a);
        }
        bw.flush();
        bw.close();
    }
}



