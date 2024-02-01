import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 몸무게 오름차순 정렬
        int answer = 0;
        int i = 0, j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있으면 함께 태움
                i++;
            }
            // 가장 무거운 사람은 항상 태움
            j--;
            answer++;
        }

        return answer;
    }
}