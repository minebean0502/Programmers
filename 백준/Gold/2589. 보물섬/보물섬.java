import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point { // 포인터
        int x;
        int y;
        public Point(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }

    // 좌 하 우 상
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = 0;
    static int height, width;

    // 최단 거리중 가장 긴 구간
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력값은 세로(5) 가로(7)
        height = Integer.parseInt(st.nextToken()); // 세로 5
        width = Integer.parseInt(st.nextToken()); // 가로 7
        int[][] map = new int[height][width];
        ArrayList<int[]> startlist = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String c = br.readLine();
            for (int j = 0; j < width; j++) {
                char d = c.charAt(j);
                if (d == 'W') {
                    map[i][j] = 0;
                } else if (d == 'L') {
                    map[i][j] = 1;
                    startlist.add(new int[]{i, j});
                }
            }
        }
        System.out.println(solution(map, startlist));
    }

    public static int solution(int[][] map, ArrayList<int[]> startlist){
        // L인 지점들에 대해 BFS들 진행
        for (int[] startpoint : startlist) {
            // 모든 시작점들에 대해 최대값 갱신
            answer = Math.max(answer, BFS(map, startpoint[0], startpoint[1]));
        }
        return answer;
    }

    public static int BFS(int[][] map, int startY, int startX){
        int[][] visited = new int[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            Arrays.fill(visited[i], -1); // 방문하지 않은 곳 -1로 초기화
        }

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startY][startX] = 0;
        int localMax = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int Y = point.y;
            int X = point.x;

            for (int i = 0; i < 4; i++) {
                int nY = Y + dy[i];
                int nX = X + dx[i];

                // 범위를 벗어나거나 이미 방문했거나 바다('W')인 경우
                if (nX < 0 || nY < 0 || nX >= width || nY >= height ||
                        visited[nY][nX] != -1 || map[nY][nX] == 0) continue;

                visited[nY][nX] = visited[Y][X] + 1;
                // 한번 시작점 기준, 최대값 갱신
                localMax = Math.max(localMax, visited[nY][nX]);
                queue.add(new Point(nX, nY));
            }
        }
        return localMax;
    }
}