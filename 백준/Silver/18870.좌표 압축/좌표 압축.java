import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st ;


        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] arrSort = arr.clone();
        Arrays.sort(arrSort);
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int x: arrSort){
            if(!map.containsKey(x)){
                map.put(x,count++);
            }
        }
        for(int x: arr){
            bw.write(map.get(x)+" ");
        }
        bw.flush();
        bw.close();
    }
}

