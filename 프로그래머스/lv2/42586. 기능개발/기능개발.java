import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] days = new int[progresses.length];
        for(int i=0;i<progresses.length;i++){
            days[i] = (100-progresses[i])/speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0){
                days[i] += 1;
            }
        }
        int start = days[0];
        int count = 1;
        for(int i=1;i<progresses.length;i++){
            if(start<days[i]){
                start = days[i];
                arr.add(count);
                count =1;
            }else{
                count++;
            }
        }
        arr.add(count);
        
        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++){
            answer[i] = arr.get(i);
        }
        return answer;
    }
}