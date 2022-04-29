import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!stack.empty()&&arr[i]>arr[stack.peek()]) arr[stack.pop()] = arr[i];
            stack.push(i);
        }
        while(!stack.empty()) arr[stack.pop()] = -1;
        for(int x: arr) bw.write(x+" ");


        bw.flush();
        bw.close();
    }
}
