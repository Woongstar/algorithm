import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int size = String.valueOf(input).length();

        int start = input-(9*size);
        int answer = 0;

        for(int i=start; i<input; i++) {
            int sum = i;
            int k = i;
            while(k > 0) {
                sum += k%10;
                k /= 10;
            }
            if(sum == input) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);





}
}