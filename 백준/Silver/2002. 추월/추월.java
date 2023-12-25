import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> inOrder = new HashMap<>();
        StringTokenizer st;

        // 처음에 들어감
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            inOrder.put(st.nextToken(), i);
        }

        int count = 0;
        int[] outOrder = new int[n];

        // 나중에 나온 결과를 넣고
        // 순서를 저장함
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            outOrder[i] = inOrder.get(st.nextToken());
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (outOrder[i] > outOrder[j]) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}