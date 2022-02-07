import java.io.*;
import java.util.*;


public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        Stack<Integer> stack = new Stack<>();
        while(n-->0){
            stack.push(Integer.parseInt(br.readLine()));
        }
        int count = 0;
        while(!stack.isEmpty()){
            int a = stack.pop();
            if(target>=a){
                count += target/a;
                target = target%a;
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();

    }
    }

