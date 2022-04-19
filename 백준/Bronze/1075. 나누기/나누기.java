import java.io.*;



public class Main{

    public static void main(String []args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        n = (n/100) *100;
        while(n%m!=0){
            n++;
        }
        n = n%100;
        String ans =  n<10 ? "0"+n : n+"";

       bw.write(ans);
        bw.flush();
        bw.close();
    }
}