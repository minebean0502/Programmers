import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 진출 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        int camera = -30001;

        for (int[] route : routes) {
            // 현재 카메라 위치가 차량의 진입 지점보다 앞에 있는 경우
            if (camera < route[0]) {
                camera = route[1]; // 새 카메라 설치
                answer++;
            }
        }

        return answer;
    }
}