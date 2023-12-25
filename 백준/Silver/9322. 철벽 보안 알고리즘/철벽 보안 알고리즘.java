import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> keyMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());
            String[] firstPublicKey = new String[M];
            String[] secondPublicKey = new String[M];
            String[] secretMessage = new String[M];
            int[] keySequence = new int[M];

            StringTokenizer st = new StringTokenizer(br.readLine());
            // firstPublicKey에 다 집어넣기 // A B C D (0 1 2 3)
            for (int j = 0; j < M; j++) {
                firstPublicKey[j] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            // 두 번째 공개키의 대응 관계 맵 생성
            // secondPublicKey에 넣기 // D A B C (3 1 2 3)
            for (int j = 0; j < M; j++) {
                secondPublicKey[j] = st.nextToken();
                keyMap.put(secondPublicKey[j], j);
            }

            // 세 번째 암호문까지 넣기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                secretMessage[j] = st.nextToken();
            }

            // 복호화 과정
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                keySequence[j] = keyMap.get(firstPublicKey[j]);
                sb.append(secretMessage[keySequence[j]] + " ");
            }
            System.out.println(sb);
        }
    }
}