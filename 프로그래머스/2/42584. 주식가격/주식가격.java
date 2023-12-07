import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
 
        for (int i : prices) {
            queue.add(i);
        }
 
        int idx = 0;
        while (!queue.isEmpty()) {
            int currentPrice = queue.poll();
            // 최근 가격의 다음 가격부터 반복 진행
            for (int i = (prices.length - queue.size()); i < prices.length; i++) {
                // 가격이 떨어지지 않았을 경우
                if (currentPrice <= prices[i]) {
                    answer[idx]++;
                    // 가격이 떨어 졌을 경우
                } else if (currentPrice > prices[i]) {
                    answer[idx]++;
                    break;
                }
                
                }
            idx++;
            }
            return answer;
    }
}