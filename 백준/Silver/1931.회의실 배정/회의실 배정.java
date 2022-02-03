import java.io.*;
import java.util.*;
class Schedule implements Comparable<Schedule>{
    int start;
    int end;

    public Schedule(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Schedule o) {
        if(this.end==o.end){
            return this.start- o.start;
        }
        return this.end-o.end;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Schedule> pQ = new PriorityQueue<>();

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pQ.add(new Schedule(a,b));
        }
        int time = 0;
        int count = 0;
        while(!pQ.isEmpty()){
            Schedule x = pQ.poll();
            if(x.start>=time){
                time =x.end;
                count++;
            }
        }
        bw.write(""+count);
        bw.flush();
        bw.close();
    }
}

