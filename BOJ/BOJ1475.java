//문제
//        다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
//
//        다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
//
//        입력
//        첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.
//
//        출력
//        첫째 줄에 필요한 세트의 개수를 출력한다.
//
//        예제 입력 1
//        9999
//        예제 출력 1
//        2
//        예제 입력 2
//        122
//        예제 출력 2
//        2
//        예제 입력 3
//        12635
//        예제 출력 3
//        1
//        예제 입력 4
//        888888
//        예제 출력 4
//        6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1475 {

    public static void main(String []args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String stringN = String.valueOf(n);
        int length = stringN.length();


        HashMap<Integer,Integer> map = new HashMap<>();
        while(n>0){
            map.put(n%10,map.getOrDefault(n%10,0)+1);
            n=n/10;
        }
        int max = Integer.MIN_VALUE;
        int temp = (map.getOrDefault(6,0) + map.getOrDefault(9,0))/2 + (map.getOrDefault(6,0) + map.getOrDefault(9,0))%2;
        for(int i=0;i<10;i++){
            if(i==6||i==9) continue;
            max = Math.max(max,map.getOrDefault(i,0));
        }
        max = Math.max(max,temp);

        System.out.println(max);
    }
}