//최대점수구하기
//이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다. 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩 니다. 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다. (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
//        ▣ 입력설명
//        첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
//        두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
//        ▣ 출력설명
//        첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
//        ▣ 입력예제 1 5 20
//        10 5
//        25 12
//        15 8 63 74
//        ▣ 출력예제 1 41

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class largestPoint {
    static int[] points,times;
    static int timeSum = 0, pointSum=0;
    static int answer=0;
    static int n, timeLimit;
    public static void DFS(int index, int ts,int ps){
        if(ts>timeLimit) return;
        if(index == n) {
            pointSum=Math.max(pointSum,ps);
        }else{
            DFS(index+1,ts+times[index],ps+points[index]);
            DFS(index+1,ts,ps);
        }
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        timeLimit = Integer.parseInt(st.nextToken());
        points = new int[n];
        times = new int[n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            points[i] = Integer.parseInt(st.nextToken());
            times[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0,0);
        System.out.println(pointSum);
    }
}