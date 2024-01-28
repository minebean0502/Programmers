class Solution {
    public int solution(int[][] triangle) {
        // dp에 대한 배열 설정
        int[][] dp = new int[triangle.length][]; // triangle.length = 5
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        // 초기값 설정 완료
        dp[0][0] = triangle[0][0]; // 7
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 2까지는 괜찮음 // 3부터는 다시 설정
                if (j == 0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][0];
                }
                else if (j == triangle[i].length-1) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                }
                else dp[i][j] = Math.max(dp[i-1][j-1]+ triangle[i][j], dp[i-1][j] + triangle[i][j]);

            }
        }
        
        int max = 0;
        for (int i = 0; i < triangle.length; i++) {
            for (int j : dp[i]) {
                max = Math.max(max, j);
            }
        }
        return max;
    }
}