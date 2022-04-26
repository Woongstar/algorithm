import java.io.*;
import java.util.*;



public class Main{

    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        float[] arr =new float[n];
        float max = 0;
        for(int i=0;i<n;i++){
            float m = Float.parseFloat(st.nextToken());
            max = Math.max(max,m);
            arr[i] = m;
        }
        float sum = 0;
        for(int i=0;i<n;i++){
            arr[i] = (arr[i]/max)*100;
            sum = sum + arr[i];
        }
        System.out.println(sum/n);
    }
}