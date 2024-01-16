import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E;
    static ArrayList<ArrayList<Integer>> graph;  // 인접 리스트
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // N과 E를 입력 받음
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        // 그래프와 방문 배열 초기화
        graph = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 정보를 입력 받음
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        // 노드 0부터 DFS 시작
        for (int i = 0; i < N; i++) {
            if (dfs(i, 0)) { // ★ 결과값
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    // 재귀함수로 구현한 DFS
    static boolean dfs(int node, int depth) {
        visited[node] = true; // 현재 노드를 방문했다고 표시
        if (depth == 4) return true; // ☆의 체크용(2)
        
        for (int next : graph.get(node)) {
            // 아직 방문하지 않은 node이고, 간선이 존재한다면 (연결되어 있다면)
            if (!visited[next]) {
                if (dfs(next, depth + 1)) { // ☆끝에가서 depth가 4 이상 있는지 확인용(1)
                    return true; // ★->☆ 있으니까 true 반환
                }
            }
        }
        visited[node] = false; // 탐색 종료 후, 방문 해제
        return false; // ★depth가 4가 없다면 (4 이상 포함) false return
    }
}