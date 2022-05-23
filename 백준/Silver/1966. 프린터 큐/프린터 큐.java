import java.io.*;
import java.util.*;

class IB{
    int a;
    boolean b;

    public IB(int a, boolean b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        while(n-->0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
            Queue<IB> Q = new LinkedList<>();
            int target = 0;
            for(int i=0;i<a;i++){
                int num =  Integer.parseInt(st.nextToken());
                pQ.add(num);
                if(i==b) Q.add(new IB(num,true));
                else Q.add(new IB(num,false));
            }
            int count = 0;
            while(!Q.isEmpty()){
                if(Q.peek().a==pQ.peek()){
                    if(Q.peek().b==true){
                        count++;
                        bw.write(count+"\n");
                        break;
                    }
                    Q.poll();
                    pQ.poll();
                    count++;
                }else{
                    Q.offer(Q.poll());
                }
            }
        }

        bw.flush();
        bw.close();
    }
}
