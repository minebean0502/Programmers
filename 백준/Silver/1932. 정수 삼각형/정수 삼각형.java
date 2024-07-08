import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // https://www.acmicpc.net/problem/1932
    static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        int[][] array = new int[inputNum][inputNum];
        int[][] dp = new int[inputNum][inputNum];
        for (int i = 0; i < inputNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                array[i][j++] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = array[0][0];
        for (int i = 1; i < inputNum; i++) {
            for (int j = 0; j < i+1; j++) {
                if (j == 0) {
                    dp[i][j] = array[i][j] + dp[i-1][j];
                } else if (j == i) {
                    dp[i][j] = array[i][j] + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(array[i][j] + dp[i-1][j] ,array[i][j] + dp[i-1][j-1]);
                }
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        System.out.println(inputNum == 1 ? array[0][0] : maxValue);
    }
}