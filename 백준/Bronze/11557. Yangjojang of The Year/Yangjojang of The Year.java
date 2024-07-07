import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 2

        for (int i = 0; i < T; i++) { // 2번 반복
            Map<String, Integer> map = new HashMap<>();
            index = 0;
            int N = Integer.parseInt(br.readLine()); // 3, 2
            for (int j = 0; j < N; j++) { // map에다가 값들을 다 넣는다.
                StringTokenizer st = new StringTokenizer(br.readLine());
                String collage = st.nextToken();
                int beverage = Integer.parseInt(st.nextToken());
                map.put(collage, beverage);
                index = Math.max(index, beverage);
            }
            for (String key : map.keySet()) {
                if (map.get(key) == index) {
                    System.out.println(key);
                }
            }
        }
    }
}