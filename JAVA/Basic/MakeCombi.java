//조합구하기
//1부터N까지번호가적힌구슬이있습니다.이중 M개를뽑는방법의수를출력하는프로그 램을 작성하세요.
//        ▣ 입력설명
//        첫 번째 줄에 자연수 N(3<=N<=10)과 M(2<=M<=N) 이 주어집니다.
//        ▣ 출력설명
//        첫 번째 줄에 결과를 출력합니다.
//        출력순서는 사전순으로 오름차순으로 출력합니다.
//        ▣ 입력예제 1 42
//        ▣ 출력예제 1 12
//        13
//        14
//        23 24 34

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MakeCombi {
    static int num, pick;
    static int[] comb;
    static void DFS(int L,int start){
        if(L==pick){
            for(int x:comb) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=start;i<=num;i++){
                comb[L]=i;
                DFS(L+1,i+1);
            }
        }
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        pick = Integer.parseInt(st.nextToken());

        comb = new int[pick];

        DFS(0,1);

    }
}