import java.io. *;
import java.util. *;
public class Main {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        int[] input = new int[length];
        int[] leftDp = new int[length];
        int[] rightDp = new int[length];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < length; i ++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < length; i ++) {
            leftDp[i] = 1;
            for (int j = 0; j < i; j ++) {
                if (input[j] < input[i]) {
                        leftDp[i] = Math.max(leftDp[j]+1,leftDp[i]);
                }
            }
        }
        for (int i = length - 1; i >= 0; i --) {
            rightDp[i] = 1;
            for (int j = length - 1; j >= i; j --) {
                if (input[i] > input[j]) {
                       rightDp[i] = Math.max(rightDp[j]+1,rightDp[i]);
                }
            }
        }
     
        int answer = 0;
        for (int i = 0; i < length; i ++) {
            answer = Math.max(answer, leftDp[i] + rightDp[i]);
        }
        bw.write(answer-1 + "");
        bw.flush();
        bw.close();
    }
}