//8. 수열 추측하기
//        설명
//
//        가장 윗줄에 1부터 N까지의 숫자가 한 개씩 적혀 있다. 그리고 둘째 줄부터 차례대로 파스칼의 삼각형처럼 위의 두개를 더한 값이 저장되게 된다.
//
//        예를 들어 N이 4 이고 가장 윗 줄에 3 1 2 4 가 있다고 했을 때, 다음과 같은 삼각형이 그려진다.
//
//        Image1.jpg
//
//        N과 가장 밑에 있는 숫자가 주어져 있을 때 가장 윗줄에 있는 숫자를 구하는 프로그램을 작성하시오.
//
//        단, 답이 여러가지가 나오는 경우에는 사전순으로 가장 앞에 오는 것을 출력하여야 한다.
//
//
//        입력
//        첫째 줄에 두개의 정수 N(1≤N≤10)과 F가 주어진다.
//
//        N은 가장 윗줄에 있는 숫자의 개수를 의미하며 F는 가장 밑에 줄에 있는 수로 1,000,000 이하이다.
//
//
//        출력
//        첫째 줄에 삼각형에서 가장 위에 들어갈 N개의 숫자를 빈 칸을 사이에 두고 출력한다.
//
//        답이 존재하지 않는 경우는 입력으로 주어지지 않는다.
//
//
//        예시 입력 1
//
//        4 16
//        예시 출력 1
//
//        3 1 2 4


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AsuumeCombine {
    static int n, target;
    static int[][] arr;
    static int[] comb, check, answer, phase;
    static boolean flag = false;
    static int CombinationArr(int a, int b){
        if(arr[a][b]>0) return arr[a][b];
        if(a==b||b==0) return 1;
        else{
            return arr[a][b]=CombinationArr(a-1,b-1)+CombinationArr(a-1,b);
        }
    }

    static void DFS(int L,int sum){
        if(flag==true) return;
        if(L==n){
            if(sum==target){
                for(int x: phase){
                    System.out.print(x + " ");
                }
                flag = true;
            }
        }
        else{
            for(int i=1;i<=n;i++){
                if(check[i]==0){
                    check[i]=1;
                    phase[L]=i;
                    DFS(L+1,sum+(phase[L]*comb[L]));
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        check = new int[n+1];
        comb = new int[n];
        phase = new int[n];

        for(int i=0;i<n;i++){
            comb[i]=CombinationArr(n-1,i);
        }


        DFS(0,0);

    }
}