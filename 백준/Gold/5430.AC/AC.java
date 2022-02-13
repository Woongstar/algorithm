import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        while(n-->0){
            String s = br.readLine();
            int num = Integer.parseInt(br.readLine());
            Deque<Integer> dQ = new LinkedList<>();
            String str = br.readLine();
            for(String x: str.substring(1,str.length()-1).split(",")){
                if(!x.equals("")) {
                    dQ.add(Integer.valueOf(x));
                }
            }
            sb.append(solution(dQ,s)).append("\n");
        }
        System.out.println(sb);
    }
    static String solution(Deque<Integer> dQ, String commands) {
        boolean reverse = false;
        for (char x : commands.toCharArray()) {
            if (x == 'R') reverse = !reverse;
            else {
                if (dQ.size() == 0) return "error";
                if (reverse) dQ.removeLast();
                else dQ.removeFirst();
            }
        }
        StringBuilder sb = new StringBuilder("[");
        while(!dQ.isEmpty()){
            sb.append(reverse ? dQ.removeLast():dQ.removeFirst());
            if(!dQ.isEmpty()) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}



