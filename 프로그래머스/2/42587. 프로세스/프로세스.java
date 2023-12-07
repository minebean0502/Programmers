import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int solution(int[] priorities, int location) {
        // 우선순위 큐 선언(내림 차순)
        PriorityQueue<Integer> qu1 = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;

        // 우선순위 큐에 우선순위 요소 추가
        for (int i : priorities) {
            qu1.offer(i);
        }
        // queue = [3, 2, 2, 1]
        // 큐가 빌 때까지 반복
        while (!qu1.isEmpty()) {
            // prior 길이만큼 반복
            for (int i = 0; i < priorities.length; i++) {
                // #1 만약
                // priorties[0](A=2) 와 qu1.peek(3)이 같다면? NO
                // priorties[1](B=1) 와 qu1.peek(3)이 같다면? NO
                // priorties[2](C=3) 와 qu1.peek(3)이 같다면? YES
                // priorties[3](D=2) 와 qu1.peek(3)이 같다면? NO
                if (priorities[i] == qu1.peek()) {
                    qu1.poll();
                    answer++;
                    // #1 i=2인데 location(2)와 같나?
                    // answer(1) return
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}