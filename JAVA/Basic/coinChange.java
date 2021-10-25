//5. 동전교환
//        설명
//
//        다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
//
//        각 단위의 동전은 무한정 쓸 수 있다.
//
//
//        입력
//        첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
//
//        그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
//
//
//        출력
//        첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
//
//
//        예시 입력 1
//
//        3
//        1 2 5
//        15
//        예시 출력 1
//
//        3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class coinChange {
    static Integer[] values;
    static int answer=Integer.MAX_VALUE;
    static int n, target;
    public static void DFS(int sum, int count){
        if(sum>target) return;
        if(count>=answer) return;
        if(sum==target) answer=Math.min(answer,count);
        else{
            for(int i=0;i<n;i++){
                DFS(sum+values[i],count+1);
            }
        }

    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        values = new Integer[n];
        for(int i=0;i<n;i++){
            values[i]=Integer.parseInt(st.nextToken());
        }
        target = Integer.parseInt(br.readLine());
        Arrays.sort(values,Collections.reverseOrder());
        DFS(0,0);
        System.out.println(answer);
    }
}