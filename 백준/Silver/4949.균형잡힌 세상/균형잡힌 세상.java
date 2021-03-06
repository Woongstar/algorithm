import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        String str = "";
        while(true){
            str = br.readLine();
            if(str.equals(".")){
                break;
            }
            char[] input = str.toCharArray();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for(char x:input){
                if(x=='('||x=='[') stack.push(x);
                if(x==')'){
                    if(stack.isEmpty()||stack.peek()!='('){
                        flag = false;
                        break;
                    };
                    stack.pop();
                }
                if(x==']'){
                    if(stack.isEmpty()||stack.peek()!='['){
                        flag = false;
                        break;
                    };
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) flag=false;
            if(flag) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
            }
        br.close();
        System.out.println(sb);
    }
}
