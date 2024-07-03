import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] array = String.valueOf(n).split("");
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += Integer.parseInt(array[i]);
        }
        return answer;
    }
}