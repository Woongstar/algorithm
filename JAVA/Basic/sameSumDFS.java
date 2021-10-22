import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sameSumDFS {
    static String answer="NO";
    static int total=0;
    static int n;
    static boolean flag = false;
    public static void DFS(int index, int[] arr, int sum){
        if(flag) return;
        if(sum>total/2) return;
        if(index==n){
            if((total-sum)==sum){
                answer="YES";
                flag=true;
            }}else{
            DFS(index+1, arr, sum+arr[index]);
            DFS(index+1,arr,sum);

        }
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] =  Integer.parseInt(st.nextToken());
            total +=arr[i];
        }
        DFS(0,arr,0);
        System.out.println(answer);
    }
}