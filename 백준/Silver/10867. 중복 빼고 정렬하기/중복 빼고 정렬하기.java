import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 중복 제거를 위해 Set 사용
        Set<Integer> set = new HashSet<>();
        
        //set에다가 넣은 숫자들 넣기
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // Set을 ArrayList으로 변환하여 정렬
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // 결과 출력
        for (int num : sortedList) {
            bw.write(num + " ");
        }
        br.close();
        bw.close();
    }

}