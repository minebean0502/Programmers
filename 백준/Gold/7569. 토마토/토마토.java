import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x;
        int y;
        int z;
        public Point(int x, int y, int z) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    // [dx, dy]는 좌, 하, 우, 상, 위, 아래
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 입력
        // 5 3 1 (width depth height)

        // 1층(tomatoBox[0]
        // 0 0 0 0 0 // tomatoBox[0][0]
        // 0 0 0 0 0 // tomatoBox[0][1]
        // 0 0 0 0 0 // tomatoBox[0][2]

        // 2층(tomatoBox[1])
        // 0 0 0 0 0 // tomatoBox[1][0]
        // 0 0 1 0 0 // tomatoBox[1][1]
        // 0 0 0 0 0 // tomatoBox[1][2]

        // 1이 있는 위치는 toamtoBox[1][1][2]
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); // i에 해당하는 값 (5개) // 가로
        int b = Integer.parseInt(st.nextToken()); // j에 해당하는 값 (3개) // 세로
        int c = Integer.parseInt(st.nextToken()); // k에 해당하는 값 (2개) // 높이
        int count = 0;

        int[][][] tomatoBox = new int[c][b][a];
        // 나중에 visited에 시작점의 위치를 1로 저장하기 위해
        // queue의 시작하는 위치의 정보값을 저장하기 위한 ArrayList        
        ArrayList<int[]> startlist = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < b; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < a; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoBox[i][j][k] == 1) {
                        count++;
                        queue.offer(new Point(k, j, i));
                        // 시작점의 정보 입력
                        startlist.add(new int[]{k, j, i});
                    }
                }
            }
        }
        System.out.println(solution(tomatoBox, startlist));
    }
    public static int solution(int[][][] tomatobox, ArrayList<int[]> starlist) {
        int answer = 0;

        // 방문 확인용 visited
        int[][][] visited = new int[tomatobox.length][tomatobox[0].length][tomatobox[0][0].length];

        // BFS로 탐색한다
        BFS(tomatobox, visited, starlist);

        answer = visited[tomatobox.length-1][tomatobox[0].length-1][tomatobox[0][0].length-1];

        // 모든 토마토가 익었는지 확인하는 로직
        // 모든 토마토가 익었는지 확인하고, 가장 오래 걸린 일수를 찾기
        for (int i = 0; i < tomatobox.length; i++) {
            for (int j = 0; j < tomatobox[0].length ; j++) {
                for (int k = 0; k < tomatobox[0][0].length; k++) {
                    // 혹시 모르니 tomatobox 전부 다 돌아보고
                    // 아직도 tomatobox에
                    // 1) 방문한 적이 없는 토마토가 있고
                    // 2) 그 토마토 박스가 익지 않았더라면
                    if (tomatobox[i][j][k] == 0 && visited[i][j][k] == 0) {
                        // 3) 끝까지 도달하지 않은 경우이기에 -1 반환
                        return -1;
                    }
                    answer = Math.max(answer, visited[i][j][k]);
                }
            }
        }
        return answer == 0 ? -1 : answer -1;
    }

    public static void BFS(int[][][] tomatoBox, int[][][] visited, ArrayList<int[]> startlist) {
        for (int[] coordinates : startlist) {
            // 1이 있는 위치는 toamtoBox[1][1][2]
            int startz = coordinates[2];
            int starty = coordinates[1];
            int startx = coordinates[0];

            // 시작하는 위치를 1로 바꿔줍시다
            visited[startz][starty][startx] = 1;
        }
        while(!queue.isEmpty()) {
            Point point = queue.poll();
            int height = point.z;
            int depth = point.y;
            int width = point.x;

            // 6방향 탐색
            for (int i = 0; i < 6; i++) {
                // 다음에 이동할 위치(좌, 하, 우, 상, 위, 아래)
                int nX = width + dx[i];
                int nY = depth + dy[i];
                int nZ = height + dz[i];

                // 외각선 Pass
                if (nX < 0 || nY < 0 || nZ < 0 ||
                        nX >= tomatoBox[0][0].length||
                        nY >= tomatoBox[0].length||
                        nZ >= tomatoBox.length) continue;
                // 아직 익지 않는 토마토인 경우
                if (visited[nZ][nY][nX] == 0 && tomatoBox[nZ][nY][nX] == 0) {
                    // 방문할 위치에, 기존에 있었던 값 + 1값 추가
                    visited[nZ][nY][nX] = visited[height][depth][width] +1;
                    queue.add(new Point(nX, nY, nZ));
                }
            }
        }
    }
}