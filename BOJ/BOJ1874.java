import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = true;
        int index = 1;
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            if(flag) {
                if(index <= arr[i]) {
                    while(index <= arr[i]) {
                        st.push(index++);
                        sb.append("+ \n");
                    }
                }
                if(st.isEmpty()) flag = false;
                else {
                    while(st.peek() >= arr[i]) {
                        st.pop();
                        sb.append("- \n");
                        if(st.isEmpty()) {
                            break;
                        }
                    }
                }}}
        System.out.println(flag ? sb : "NO");
    }
}