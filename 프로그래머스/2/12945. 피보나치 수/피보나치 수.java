class Solution {
    static int[] boxes = new int[100001];
    
    public int solution(int n) {
        // TODO n = 2 이상 100000이하 자연수
        // 재귀를 쓰면 시간 오버가 나기에 바로 쓸 수 있도록 해야함 (DP 추천)
        //          0  1  2  3  4  5  6 ...
        // boxes = {0, 1, 1, 2, 3, 5, 8 ...}
        boxes[0] = 0;
        boxes[1] = 1;
        for (int i = 2; i <= n; i++) {
            boxes[i] = (boxes[i-1] + boxes[i-2])%1234567;
        }
        return boxes[n] % 1234567;
    }
}