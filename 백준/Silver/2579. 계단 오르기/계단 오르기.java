import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/2579
public class Main {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        int[] dp = new int[test+1];
        int[] stairs = new int[test+1];
        for (int i = 1; i <= test; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = stairs[1]; // 첫 번째 계단의 최대 점수는 첫 번째 계단의 점수와 같음
        if (test >= 2) {
            dp[2] = stairs[1] + stairs[2]; // 두 번째 계단의 최대 점수는 첫 번째와 두 번째 계단의 점수 합
        }

        for (int i = 3; i <= test; i++) {
            // i번째 계단까지의 최대 점수는 두 가지 경우 중 최댓값
            // 1. i-2번째 계단에서 두 계단을 오른 경우
            // 2. i-1번째 계단에서 한 계단을 오른 경우(이 경우 i-3번째 계단에서 i-1번째 계단으로 오른 것)
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i-1] + stairs[i]);
        }

        System.out.println(dp[test]); // n번째 계단까지의 최대 점수 출력
    }
}