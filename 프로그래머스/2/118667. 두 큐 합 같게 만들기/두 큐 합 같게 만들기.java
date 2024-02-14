import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int length = queue1.length;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // 두 큐의 합을 구하고, LinkedList로 큐를 초기화합니다.
        for (int i = 0; i < length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long target = (sum1 + sum2) / 2; // 목표 합
        int moveCount = 0;
        int index1 = 0, index2 = 0;

        while (sum1 != sum2) {
            // 두 큐의 합이 같지 않고, 최대 이동 횟수를 넘지 않은 경우
            if (sum1 > sum2 ) {
                // 큐1에서 빼서 큐2에 넣기
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
                sum2 += num;
                index1++;
            } else if (sum1 < sum2) {
                // 큐2에서 빼서 큐1에 넣기
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
                sum2 -= num;
                index2++;
            } else {
                // 합을 맞출 수 없는 경우
                return -1;
            }
            moveCount++;
        }

        return moveCount;
    }
}