import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 방문 -> Queue에 추가 -> 주변에 있으면 Queue에 추가하지 않음
    // 마지막까지 돌고나서, 1) 방문하지도 않은 곳이 없고, 2) 큐에도 아무것도 없다면 종료
    // (n, m)이 방문한게 있다면 distacne return // 만약 (n, m) 방문이 안된다면 -1 리턴

    // [dx, dy]는 좌, 하, 우, 상의 순서임
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        // 방문 거리를 저장할 곳
        // 거리를 반환할 값, 도착 못하면 -1
        int answer = 0;
        
        // 방문했는지 확인할 check
        int[][] check = new int[maps.length][maps[0].length];
        check[0][0] = 1; // 시작점은 방문 check

        BFS(maps, check);
        
        // 도착점 입력
        // 도착점은 5행 5열 // 실제 좌표값(4, 4)
        answer = check[maps.length-1][maps[0].length-1];

        if (answer == 0) {
            return -1;
        } else return answer;
    }
    
    public static void BFS(int[][] maps, int[][] check) {
        Queue<int[]> queue = new LinkedList<>();
        // 시작점을 queue에 넣어줌
        // 시작점은 (0, 0 // 1행 1열) 에 있음
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int X = now[0];
            int Y = now[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                // 다음에 이동할 위치 (좌, 하, 우, 상)
                int nX = X + dx[i];
                int nY = Y + dy[i];

                // 외각선을 벗어나는 경우는 pass
                if (nX < 0 || nY < 0 || nX > maps.length-1 || nY > maps[0].length-1) continue;

                // 현재 위치가 갈 수 있는곳 (1)이고
                // 다음 위치가 간 적 없다면 check[][] = 0
                if (check[nX][nY] == 0 && maps[nX][nY] == 1) {
                    // 다음에 갈 위치에 갔다고 체크하고 ( check = 0 ) -> ( check = 1 )
                    check[nX][nY] = check[X][Y] + 1;
                    // queue에 현재 위치를 다시 추가해줌
                    queue.add(new int[]{nX, nY});
                }
            }
        }
    }
}