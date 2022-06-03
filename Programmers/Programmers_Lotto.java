public class Programmers_Lotto {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int[] answer = new int[2];
            int min = 0;
            int cantSee = 0;
            for(int x : lottos){
                if(inWinNum(x,win_nums)) min++;
                if(x==0) cantSee++;
            }
            answer[0] = min+cantSee >1 ? 7- (min+cantSee) : 6;
            answer[1] = min>1 ? 7-min : 6;
            return answer;
        }
        public boolean inWinNum(int num, int[] win_nums){
            for(int x : win_nums){
                if(num==x) return true;
            }
            return false;
        }
    }
}
