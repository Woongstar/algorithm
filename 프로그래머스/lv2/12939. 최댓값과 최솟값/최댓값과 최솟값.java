import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int min = 1000000;
        int max = -1000000;
        while(st.hasMoreTokens()){
            int tmp = Integer.valueOf(st.nextToken());
            if(min>tmp) min = tmp;
            if(max<tmp) max = tmp;
        }
        
        String answer = min+" "+max;
        return answer;
    }
}