import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 성격 유형 점수를 저장할 HashMap 초기화
        Map<Character, Integer> typeScores = new HashMap<>();
        typeScores.put('R', 0);
        typeScores.put('T', 0);
        typeScores.put('C', 0);
        typeScores.put('F', 0);
        typeScores.put('J', 0);
        typeScores.put('M', 0);
        typeScores.put('A', 0);
        typeScores.put('N', 0);

        // 질문별로 선택한 선택지에 따라 점수 계산
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0); // 비동의 성격 유형
            char agree = survey[i].charAt(1); // 동의 성격 유형
            int choice = choices[i];

            // 4가 중립이므로 점수를 부여하지 않습니다.
            if (choice < 4) {
                typeScores.put(disagree, typeScores.get(disagree) + (4 - choice));
            } else if (choice > 4) {
                typeScores.put(agree, typeScores.get(agree) + (choice - 4));
            }
        }

        // 최종 성격 유형 결정
        StringBuilder result = new StringBuilder();
        result.append(typeScores.get('R') >= typeScores.get('T') ? 'R' : 'T');
        result.append(typeScores.get('C') >= typeScores.get('F') ? 'C' : 'F');
        result.append(typeScores.get('J') >= typeScores.get('M') ? 'J' : 'M');
        result.append(typeScores.get('A') >= typeScores.get('N') ? 'A' : 'N');

        return result.toString();
    }
}