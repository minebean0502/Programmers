import java.util.ArrayList;
import java.util.List;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int entrieNums = brown+yellow;
        System.out.println(entrieNums);
        List<Integer> list = new ArrayList<>(); // 전체 약수 판단
        List<Integer> lists = new ArrayList<>(); // 노랑 약수 판단
        
        // (전체)카펫의 경우의 수 (약수)
        for (int i = 1; i <= entrieNums; i++) {
            if (entrieNums % i == 0) list.add(i);
        }
        
        // 노란 카펫의 가능한 xy의 경우의 수 (약수)
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0 ) lists.add(i);
            
        }
        // 약수가 홀수인 경우와 짝수인 경우를 판단해야함
        int checklistlength;
        if (list.size() % 2 == 0) checklistlength = list.size()/2;
        else checklistlength = list.size()/2 +1;

        int[][] pairOrigin = new int[checklistlength][2];
        for (int i = 1; i <= checklistlength; i++) {
            // 세로(짧은 길이)
            pairOrigin[i-1][1] = list.get(i-1);
            // 가로(긴 길이)
            pairOrigin[i-1][0] = list.get(list.size()-i);
        }
        
        // 노란색의 짝수 홀수 판단
        int checklist;
        if (lists.size() % 2 == 0 ) checklist = lists.size()/2;
        else checklist = lists.size()/2 +1;

        int[][] pair = new int[checklist][2];
        for (int i = 1; i <= checklist; i++) {
            // 세로(짧은 길이)
            pair[i-1][1] =lists.get(i-1);
            // 가로(긴 길이)
            pair[i-1][0] = lists.get(lists.size()-i);
        }
        int width = 0;
        int height = 0;

        for (int i = 0; i < pair.length; i++) { // [24, 1] [12, 2] [8, 3] [6, 4]
            width = pair[i][0]+2;
            height = pair[i][1]+2;
            for (int j = 0; j < pairOrigin.length; j++) { // [48, 1] [24, 2] [16, 3] [12, 4] [8, 6]
                if (pairOrigin[j][0] == width && pairOrigin[j][1] == height){
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }
        return answer;
    }
}