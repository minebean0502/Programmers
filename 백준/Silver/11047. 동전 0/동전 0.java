import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int N = Integer.parseInt(info[0]);
        int K = Integer.parseInt(info[1]); // 목표 합
        int[] coins = new int[N];
        for (int i = N-1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        int i = 0;
        while (K > 0) {
            if (K / coins[i] > 0) { // 나눠지는 경우
                count += (K / coins[i]);
                K = K % coins[i];
                i++;
            } else if (K / coins[i] == 0 ) { // 안나눠지는 경우
                i++;
            }
        }
        System.out.println(count);
    }
}