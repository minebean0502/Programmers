class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1]; // n=3, m=4
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;

        // 처음 출발하는 곳은 1로 설정 dp[0][0] ~ dp[2][3]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] == -1) { // 물웅덩이는 건너뜀
                    dp[i][j] = 0;
                } else {
                    if (i != 1) dp[i][j] += dp[i - 1][j] % 1000000007; // 위에서 온 경우
                    if (j != 1) dp[i][j] += dp[i][j - 1] % 1000000007; // 왼쪽에서 온 경우
                }
            }
        }
        return dp[n][m] % 1000000007;
    }
}
