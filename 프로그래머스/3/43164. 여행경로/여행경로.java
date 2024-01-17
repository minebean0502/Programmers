import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    static ArrayList<String> routes = new ArrayList<>();
    static boolean visited[];
    
    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length]; // ICN JFK HND

        dfs(0, "ICN", "ICN", tickets);

        // 오름차순 정렬
        Collections.sort(routes);
        answer = routes.get(0).split(",");
        return answer;
    }
    public static void dfs(int depth, String start, String path, String[][] tickets) {
        if (depth == tickets.length) { // 티켓을 모두 사용했으면, 리스트에 추가해주기
            routes.add(path);
            return;
        }
        for (int next = 0; next < tickets.length; next++) {
            // 만약 다음에 갈 곳의 경로가 일치하고, 아직 방문한 적이 없다면
            if (start.equals(tickets[next][0]) && !visited[next]) {
                visited[next] = true;
                dfs(depth+1, tickets[next][1], path + "," + tickets[next][1], tickets);
                // 모든 배열 돌고나서 초기화
                visited[next] = false;
            }
        }
    }
}