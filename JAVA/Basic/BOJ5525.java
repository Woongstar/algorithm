//문제 백준 5525
//        N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.
//
//        P1 IOI
//        P2 IOIOI
//        P3 IOIOIOI
//        PN IOIOI...OI (O가 N개)
//        I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.
//
//        출력
//        S에 PN이 몇 군데 포함되어 있는지 출력한다.
//
//        제한
//        1 ≤ N ≤ 1,000,000
//        2N+1 ≤ M ≤ 1,000,000
//        S는 I와 O로만 이루어져 있다.
//        서브태스크
//        번호	배점	제한
//        1	50
//        N ≤ 100, M ≤ 10 000.
//
//        2	50
//        추가적인 제약 조건이 없다.
//
//        예제 입력 1
//        1
//        13
//        OOIOIOIOIIOII
//        예제 출력 1
//        4
//        OOIOIOIOIIOII
//        OOIOIOIOIIOII
//        OOIOIOIOIIOII
//        OOIOIOIOIIOII
//        예제 입력 2
//        2
//        13
//        OOIOIOIOIIOII
//        예제 출력 2
//        2
//        OOIOIOIOIIOII
//        OOIOIOIOIIOII


import java.util.Scanner;

public class BOJ5525 {

    public int solution(int n, int k, String str) {
        int answer = 0;
        char ch[] = new char[k + 1];
        for (int i = 0; i < k; i++) {
            ch[i] = str.charAt(i);
        }
        for (int i = 1; i < ch.length; i++) {
            int cnt = 0;
            if (ch[i - 1] == 'I') {
                while (ch[i] == 'O' && ch[i + 1] == 'I') {
                    i += 2;
                    cnt++;
                    if (cnt == n) {
                        cnt--;
                        answer++;
                    }
                }

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BOJ5525 T = new BOJ5525();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        String str = scan.next();
        System.out.println(T.solution(n, k, str));
    }
}

