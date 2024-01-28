import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] array, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n=3 동전의 갯수
        int k = Integer.parseInt(st.nextToken()); // k=10 만들기 위한 점수

        array = new int[n]; // {1, 2, 5}
        // dp : n개를 썼을 때 가능한 경우의 수들의 합
        dp = new int[k+1]; // dp[10]

        // array에 다 집어넣기
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // dp 계산용
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (array[i] <= j) {
                    dp[j] += dp[j - array[i]];
                }
            }
        }
        System.out.println(dp[k]);
    }
}