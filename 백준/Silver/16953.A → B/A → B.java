import java.io. *;
import java.util. *;

public class Main {
    
   
    public static void main(String[] args)throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System. in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int answer = 1;
        while(m!=n){
            if(m<n){
                answer = -1;
                break;
            }
            long last = m%10;
            if(last%2!=0 && last!=1){
                answer = -1;
                break;
            }
            if(last%2==0){
                m/=2;
            }else{
                m/=10;
            }
            answer++;
        }
        bw.write(answer +" \n");
        bw.flush();
        bw.close();
    }
}