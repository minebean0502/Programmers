import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] tree;
    static int[] colors;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        colors = new int[N+1];
        visited = new boolean[N+1];
        tree = new List[N+1];
        for (int i = 0; i <= N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            colors[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);
        System.out.println(answer);
    }

    static void dfs(int node, int parentColor) {
        if (visited[node]) return;
        visited[node] = true;

        // 색이 부모와 다르면 칠해야 함
        if (colors[node] != parentColor) {
            answer++;
        }

        for (int child : tree[node]) {
            dfs(child, colors[node]);
        }
    }
}