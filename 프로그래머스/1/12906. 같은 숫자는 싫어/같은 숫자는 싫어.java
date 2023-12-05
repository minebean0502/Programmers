import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stackInt = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stackInt.empty() || stackInt.peek() != arr[i]){
                stackInt.push(arr[i]);
            }
        }
        int[] answer = new int[stackInt.size()];
        for (int j = stackInt.size()-1; j >= 0; j--) {
            answer[j] = stackInt.pop();
        }
        return answer;
    }
}