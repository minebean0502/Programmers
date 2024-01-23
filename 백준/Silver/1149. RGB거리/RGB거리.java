import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/1149
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 집의 개수

        int[][] costs = new int[n][3]; // 각 집을 칠하는 비용을 저장할 배열
        int[][] dp = new int[n][3]; // 각 집까지 칠하는 비용의 최솟값을 저장할 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken()); // 비용 입력
            }
        }

        // 첫 번째 집을 칠하는 비용을 초기값으로 설정
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }

        // 나머지 집들에 대하여 최솟값 계산
        for (int i = 1; i < n; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i-1][1], dp[i-1][2]); // 빨강색으로 칠할 때의 최솟값
            dp[i][1] = costs[i][1] + Math.min(dp[i-1][0], dp[i-1][2]); // 초록색으로 칠할 때의 최솟값
            dp[i][2] = costs[i][2] + Math.min(dp[i-1][0], dp[i-1][1]); // 파랑색으로 칠할 때의 최솟값
        }

        // 마지막 집까지 칠하는 비용 중 최솟값 출력
        int minCost = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
        System.out.println(minCost);
    }
}