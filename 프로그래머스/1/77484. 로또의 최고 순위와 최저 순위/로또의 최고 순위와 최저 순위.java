class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCount = 0; // 지워진 숫자의 개수
        int matchCount = 0; // 맞춘 숫자의 개수

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++; // 지워진 숫자 세기
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    matchCount++; // 맞춘 숫자 세기
                    break;
                }
            }
        }

        // 최고 순위와 최저 순위 계산
        int bestRank = getRank(matchCount + zeroCount); // 최고 순위는 지워진 숫자가 모두 당첨 번호일 경우
        int worstRank = getRank(matchCount); // 최저 순위는 지워진 숫자를 고려하지 않을 경우

        return new int[] {bestRank, worstRank};
    }

    // 맞춘 숫자에 따른 순위 반환
    private int getRank(int count) {
        switch (count) {
            case 6: return 1;
            case 5: return 2;
            case 4: return 3;
            case 3: return 4;
            case 2: return 5;
            default: return 6; // 1개 이하로 맞췄거나 하나도 맞추지 못한 경우
        }
    }
}