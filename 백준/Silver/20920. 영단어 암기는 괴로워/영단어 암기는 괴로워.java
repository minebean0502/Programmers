import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer>map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.length() >= M) map.put(str, map.getOrDefault(str, 0)+1);
        }
        //System.out.println(map); // {apple=2, sand=3, append=1}

        // 1) 자주 나오는 단어일수록 앞에
        // 2) 해당 단어의 길이가 길수록
        // 3) 알파벳 사전 순으로

        // ◈해시맵 -> 리스트로 변환
        List<Map.Entry<String, Integer>> lists = new ArrayList<>(map.entrySet());
        lists.sort((entry1, entry2) -> {
            if (entry1.getValue().equals(entry2.getValue())) {
                if (entry1.getKey().length() == entry2.getKey().length()) {
                    // #3 value값도 같고, 길이값도 같다면, 사전순(key값)으로 정렬
                    return entry1.getKey().compareTo(entry2.getKey());
                }
                // #2 value 값이 같다면, 길이순대로 정렬
                return Integer.compare(entry2.getKey().length(), entry1.getKey().length());
            }
            // #1 먼저 value 값을 비교해서 정렬
            return Integer.compare(entry2.getValue(), entry1.getValue());
        });
        StringBuilder sb = new StringBuilder();
        // ◈ for 구문으로 lists에 넣었던 key value값 표현하는법
        for (Map.Entry<String, Integer> list : lists) {
            sb.append(list.getKey()+"\n");
        }
        System.out.println(sb);
    }
}