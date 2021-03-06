import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
       for(int i=0;i<9;i++){
        arr[i] = Integer.parseInt(br.readLine());
    }
       int max = Arrays.stream(arr).max().getAsInt();
       int index = IntStream.range(0,arr.length).filter(i -> arr[i]==max).findFirst().getAsInt()+1;
        System.out.println(max);
        System.out.println(index);
    }
}

