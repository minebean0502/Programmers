import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] str = new String[M];

        // 첫번째 N개를 map에다가 다 집어넣음
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            str[i] = br.readLine();
        }
        // System.out.println(map); // 이때 map = {ohhenrie=1, baesangwook=1, charlie=1}
        // 두번째 M개의 key값을 map에 있는지 없는지 확인하여, 없을경우는 넘어가나
        // 만일 있을 경우에는 그 value값을 -1개 해준다
        // 각각 듣도 못한 배열 중복X || 보도 못한 배열 중복 X 이므로
        // 같은게 있다면 그 value는 0이 될것이고, 같은게 없으면 value는 1로 남기에 0값만 뽑아낼거임
        // 그리고 뽑아주기 위해서
        int k = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (map.containsKey(str[i])) {
                // 1) map에서 value 값들을 조정하고, 이후에 value값들이 0인 녀석들을 찾으려고 했지만
                // 3) 사실상 바로 그 값들을 list에 넣고 정렬해도 될거같음
                // map.replace(str[i], map.getOrDefault(str[i], 0)-1);

                // 4) 해당하는 str[i]값들을 list에다가 넣는다 // k값은 그 갯수를 알기위해
                list.add(str[i]);
                k++;
            }
            // 2) 사실 윗 부분(if ~ k++;)을 한 문장으로 줄이게 된다면
            // map.computeIfPresent(str[i], (key,value) -> value -1);
            // 로 줄일 수 있음
        }
        // System.out.println(map); // map = {ohhenrie=0, baesangwook=0, charlie=1}

        // 사전순으로 정렬하기 위해 list 정렬 한번 해주고
        Collections.sort(list);

        // 전부다 끝나고 나면
        // int k = 2
        // list.size = 2
        // list = [baesangwook, ohhenrie] (사전순 정렬)

        for (int i = 0; i < k; i++) {
            sb.append(list.get(i) + "\n");
        }
        System.out.println(k);
        System.out.println(sb);
    }
}