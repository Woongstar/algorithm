//7. 조합의 경우수(메모이제이션)
//        설명
//
//        Image1.jpg로 계산합니다.
//
//        하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
//
//        입력
//        첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
//
//
//        출력
//        첫째 줄에 조합수를 출력합니다.
//
//
//        예시 입력 1
//
//        5 3
//        예시 출력 1
//
//        10
//        예시 입력 2
//
//        33 19
//        예시 출력 2
//
//        818809200

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CombineMemorization {
    static int[][] arr;
    public static int DFS(int a, int b){
        if(arr[a][b]>0) return arr[a][b];
        if(a==b) return 1;
        if(b==0) return 1;
        return arr[a][b]=DFS(a-1,b-1)+DFS(a-1,b);
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        arr=new int[a+1][b+1];
        System.out.println(DFS(a,b));
    }
}