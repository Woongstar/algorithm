import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> arr = new ArrayList<>();
        while(n-->0){
            arr.add(br.readLine());
        }
        arr.stream().distinct().sorted().sorted(((o1, o2) -> Integer.compare(o1.length(),o2.length()))).forEach(System.out::println);
    }
}

