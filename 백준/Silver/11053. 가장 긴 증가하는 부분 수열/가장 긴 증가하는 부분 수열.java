import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // 최소 길이는 1
            for (int j = 0; j < i; j++) {
                // 이전 위치에서 끝나는 LIS와 비교하여 길이 업데이트
                if (array[j] < array[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            count = Math.max(count, dp[i]);
        }
        System.out.println(count);
    }
}