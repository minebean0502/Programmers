class Solution {
    public int solution(int[][] sizes) {
        int MaxX = 0;
        int MaxY = 0;

        for (int i = 0; i < sizes.length; i++) {
            int MaxableX = Math.max(sizes[i][0], sizes[i][1]); // X Y의 큰값 들을 뽑음
            int MaxableY = Math.min(sizes[i][0], sizes[i][1]); // X Y의 작은 값들을 뽑음

            MaxX = Math.max(MaxX, MaxableX); // 큰 값들 중에 큰값 [60, 70, 60, 80 ] -> 80이 가장 큼
            MaxY = Math.max(MaxY, MaxableY); // 작은 값들 중에 가장 큰값 [50, 30, 30, 40] -> 50이 가장 큼
        }
        return MaxX*MaxY;
    }
}