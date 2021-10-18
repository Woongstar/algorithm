import java.io.*;
import java.util.Stack;

public class BOJ5397 {

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input;
        for(int i=0;i<n;i++){
            input = br.readLine();
            getPwd(input);
        }
    }

    public static void getPwd(String input) throws IOException{
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k= input.length();
        for(int i=0;i<k;i++){
            switch(input.charAt(i)){
                case '<':
                    if(!left.isEmpty()) right.push(left.pop());
                    break;
                case '>':
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case '-':
                    if(!left.isEmpty()) left.pop();
                    break;
                default:
                    left.push(input.charAt(i));
                    break;
            }
        }
        while(!left.isEmpty()) right.push(left.pop());

        while(!right.isEmpty()){
            bw.write(right.pop());
        }
        bw.newLine();
        bw.flush();
    }
}