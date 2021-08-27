//4. 단어 뒤집기
//        설명
//
//        N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
//
//
//        입력
//        첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
//
//        두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
//
//
//        출력
//        N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
//
//
//        예시 입력 1
//
//        3
//        good
//        Time
//        Big
//        예시 출력 1
//
//        doog
//        emiT
//        giB


import java.util.ArrayList;
import java.util.Scanner;

public class reverseWords {
//    public ArrayList<String> solution(int n, String[] words){
//        ArrayList<String> answer = new ArrayList<>();
//        for(String x: words){
//         String tmp = new StringBuilder(x).reverse().toString();
//         answer.add(tmp);
//        }
//        return answer;
public ArrayList<String> solution(int n, String[] words) {
    ArrayList<String> answer = new ArrayList<>();
    for (String x : words) {
        char[] s = x.toCharArray();
        int lt = 0, rt = x.length() - 1;
        while (lt < rt) {
            char tmp = s[lt];
            s[lt] = s[rt];
            s[rt] = tmp;
            lt++;
            rt--;
        }
        String tmp = String.valueOf(s);
        answer.add(tmp);
    }
    return answer;
}
    public static void main(String[] args) {
        reverseWords T = new reverseWords();
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        String[] words = new String[num];
        for(int i=0;i<num;i++){
            words[i]=scan.next();
        }
        for(String x: T.solution(num,words)){
            System.out.println(x);
        }
        }
}
