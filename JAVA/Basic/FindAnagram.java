//4. 모든 아나그램 찾기
//        설명
//
//        S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
//
//        아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
//
//
//        입력
//        첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
//
//        S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
//
//
//        출력
//        S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
//
//
//        예시 입력 1
//
//        bacaAacba
//        abc
//        예시 출력 1
//
//        3
//        힌트
//
//        출력설명: {bac}, {acb}, {cba} 3개의 부분문자열이 "abc"문자열과 아나그램입니다.

import java.util.HashMap;
import java.util.Scanner;

public class FindAnagram {

    public int solution(String str1, String str2){
        int answer = 0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for (char x: str2.toCharArray()) map2.put(x, map2.getOrDefault(x,0)+1);
        int length = str2.length()-1;
        for(int i=0;i<length;i++) map1.put(str1.charAt(i),map1.getOrDefault(str1.charAt(i),0)+1);
        int lt=0;
        for(int rt=length; rt<str1.length();rt++){
            map1.put(str1.charAt(rt),map1.getOrDefault(str1.charAt(rt),0)+1);
            if(map1.equals(map2)) answer++;
            map1.put(str1.charAt(lt),map1.get(str1.charAt(lt))-1);
            if(map1.get(str1.charAt(lt))==0) map1.remove(str1.charAt(lt));
            lt++;
        }
      return answer;
    }
    public static void main(String[] args) {
        FindAnagram T = new FindAnagram();
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();
        System.out.println(T.solution(str1, str2));
    }
}


