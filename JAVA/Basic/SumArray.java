//1. 두 배열 합치기
//        설명
//
//        오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
//
//
//        입력
//        첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
//
//        두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
//
//        세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
//
//        네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
//
//        각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
//
//
//        출력
//        오름차순으로 정렬된 배열을 출력합니다.
//
//
//        예시 입력 1
//
//        3
//        1 3 5
//        5
//        2 3 6 7 9
//        예시 출력 1
//
//        1 2 3 3 5 6 7 9

import java.util.ArrayList;
import java.util.Scanner;

public class SumArray {

    public ArrayList<Integer> solution(int n, int m, int[] ar1,int[] ar2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0,p2=0;
        while(p1<n&&p2<m){
            if(ar1[p1]<ar2[p2]) answer.add(ar1[p1++]);
            else answer.add(ar2[p2++]);
        }
        while(p1<n) answer.add(ar1[p1++]);
        while(p2<m) answer.add(ar2[p2++]);

        return answer;
    }
    public static void main(String[] args) {
        SumArray T = new SumArray();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] ar1 = new int[n];
        for(int i=0;i<n;i++){
            ar1[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] ar2 = new int[m];
        for(int i=0;i<m;i++){
            ar2[i] = scan.nextInt();
        }
        for(int x:T.solution(n,m,ar1,ar2)) System.out.print(x+" ");
    }
}


