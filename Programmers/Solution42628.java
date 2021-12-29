import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution42628 {

    public static void main(String[] args) throws IOException {
        String[] input = {"I 7","I 5","I -5","D -1"};
        for(int x : solution(input)){
            System.out.println(x);
        }
        solution(input);
    }
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        PriorityQueue<Integer> bigQ = new PriorityQueue<>(Collections.reverseOrder());
        for(String s : operations){
            StringTokenizer st = new StringTokenizer(s);
            String a = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            if(pQ.size()<1 && a.equals("D")) continue;
            if(a.equals("I")){
                pQ.add(b);
                bigQ.add(b);
                continue;
            }
            if(b<0){
                bigQ.remove(pQ.poll());
                continue;
            }
            pQ.remove(bigQ.poll());
        }
        if(pQ.size()>0){
            answer[0] = bigQ.poll();
            answer[1] = pQ.poll();
        }
        return answer;
    }
}
