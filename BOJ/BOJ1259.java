import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ1259 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input;
        while ((input = Integer.parseInt(br.readLine()))!=0){
            String answer = "yes";
            String inputString = String.valueOf(input);
            int length = inputString.length();
            for(int i=0;i<(length/2);i++){
                char left = inputString.charAt(i);
                char right = inputString.charAt(length-1-i);
                if(left!=right){
                    answer = "no";
                    break;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}