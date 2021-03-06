import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        while(true){
            if(n%5==0){
                count += n/5;
                bw.write("" + count);
                bw.flush();
                bw.close();
                System.exit(0);
            }
            else{
                n-=3;
                count++;
            }
            if(n<0){
                bw.write("-1");
                bw.flush();
                bw.close();
                System.exit(0);
            }
        }
    }
}
