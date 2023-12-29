class Solution {
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        permRecursive(dungeons, dungeons.length, k);
        return answer;
    }
    // 재귀를 쓰기 때문에 전역 변수로 두기
    private static int answer = 0;
    
    //dungeons, 고를 갯수(r), 시작깊이(0), 방문했는지 used, 순서 저장용(perm), 피로도(k)
    public static void permRecurHelper(
            int[][] dungeons, int r, int depth, boolean[] used, int[] perm, int k
    ) {
        // 깊이 = 선택갯수(3)이 되면, perm에 대해 max값 계산하기
        if (depth == r) {
            calculate(dungeons, perm, k);
        } else {
            for (int i = 0; i < dungeons.length; i++) {
                // 중복을 피하기 위함
                if (used[i]) continue;
                perm[depth] = i;
                used[i] = true;
                permRecurHelper(dungeons, r, depth + 1, used, perm, k);
                used[i] = false;
            }
        }
    }
    
    // 초기값 설정용
    public static void permRecursive(int[][] dungeons, int r, int k) {
        permRecurHelper(dungeons, r, 0, new boolean[dungeons.length], new int[r], k);
    }
    
    // 계산 과정
    private static void calculate(int[][] dungeons, int[] perm, int k) {
        int count = 0;
        for (int i = 0; i < perm.length; i++) {
            int[] dungeon = dungeons[perm[i]];
            if (k >= dungeon[0]) {
                k -= dungeon[1];
                count++;
            // 현재 피로도보다 쓸 피로도가 많다면 어자피 못가고
            // 못간다면 다른 곳을 고를 필요 없이, 순열에 의해 다른 case에서 만족시킬거임
            // 그래서 break
            } else {
                break;
            }
        }
        // answer 값은 전역에 의해, 항상 최대값이 유지될거임
        // 최대값 갱신되면, 갱신값으로 유지
        answer = Math.max(answer, count);
    }
}