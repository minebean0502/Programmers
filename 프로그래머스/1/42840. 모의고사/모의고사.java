import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 순서 배열 선언
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2,1,2,3,2,4,2,5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        // 점수 저장용 scores 선언
        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) scores[0]++;
            if (answers[i] == p2[i % p2.length]) scores[1]++;
            if (answers[i] == p3[i % p3.length]) scores[2]++;
        }
        // 최대 점수 알아보기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // max값 list에 저장하기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                list.add(i + 1);
            }
        }
        // stream으로 list를 array로 변환하기
        return list.stream().mapToInt(i -> i).toArray();
    }
}