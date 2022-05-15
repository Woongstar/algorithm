import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;

        for(int i=0;i<input.length;i++){
            char n = input[i];
            if(n=='('||n=='['){
                stack.push(n);
                tmp*= n=='(' ? 2 :3;
            }else{
                if(n==')'){
                    if(stack.isEmpty()||stack.peek()!='('){
                        System.out.println(0);
                        System.exit(0);
                    }
                    try{
                        if(input[i-1]=='(') answer+=tmp;
                    }catch (Exception e){
                        System.out.println(0);
                        System.exit(0);
                    }
                    stack.pop();
                    tmp/=2;
                }else if(n==']'){
                    if(stack.isEmpty()||stack.peek()!='['){
                        System.out.println(0);
                        System.exit(0);
                    }
                    try{
                        if(input[i-1]=='[') answer+=tmp;
                    }catch (Exception e){
                        System.out.println(0);
                        System.exit(0);
                    }
                    stack.pop();
                    tmp/=3;
                }
            }
        }

        bw.write(stack.isEmpty() ? answer+"":0+"");
        bw.flush();
        bw.close();

    }
}
