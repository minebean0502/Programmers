import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/11000

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] rooms = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            rooms[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 시작 시간 기준으로 오름차순 정렬
        Arrays.sort(rooms, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] lecture : rooms) {
            if (!pq.isEmpty() && pq.peek() <= lecture[0]) {
                pq.poll();
            }
            pq.offer(lecture[1]);
        }

        System.out.println(pq.size()); // 필요한 강의실의 최소 개수
    }
}