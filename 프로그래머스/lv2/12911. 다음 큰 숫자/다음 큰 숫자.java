import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = countOne(n);
        while(true){
            if(countOne(++n) == num) break;
        }
      
        return n;
    }
    private int countOne(int tmp){
        int count = 0;
        while(tmp>0){
            if((tmp&1)==0) tmp/=2;
            else {
                count++;
                tmp/=2;
            }
        }
        return count;
    }
}