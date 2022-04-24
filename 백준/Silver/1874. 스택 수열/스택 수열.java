import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int n;
        int index = 1;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());
            if (n >= index) {
                while (index <= n) {
                    s.push(index);
                    index++;
                    sb.append("+\n");
                }
                s.pop();
                sb.append("-\n");
            } else if (n < index) {
                if (s.isEmpty()) {
                    System.out.println("NO");
                    return;
                } else {
                    while (!s.isEmpty() && s.peek() >= n) {
                        s.pop();
                        sb.append("-\n");
                    }
                }
            }
        }
        System.out.println(sb);

    }
}