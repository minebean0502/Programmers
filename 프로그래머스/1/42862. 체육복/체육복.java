import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] array1 = new int[n+2];
        int[] array2 = new int[n+2];
        Arrays.fill(array1, 1);
        array1[0] = -1;
        array1[n+1] = -1;
        Arrays.fill(array2, 1);
        array2[0] = -1;
        array2[n+1] = -1;

        for (int i : lost) {
            array1[i] = 0;
            array2[i] = 0;
        }
        for (int j : reserve) {
            array1[j] += 1;
            array2[j] += 1;
        }

        // 0 2 일 때 1 1 만드는 (왼쪽 전달)
        for (int i = 1; i <= n; i++) {
            if (array1[i] == 2 && array1[i-1] == 0) {
                array1[i] -= 1;
                array1[i-1] += 1;
            }
        }
        // 2 0 일 때 1 1 만드는 (오른쪽 전달)
        for (int i = 1; i <= n; i++) {
            if (array1[i] == 2 && array1[i+1] == 0) {
                array1[i] -= 1;
                array1[i+1] += 1;
            }
        }
        // 2 0 일 때 1 1 만드는 (오른쪽 전달)
        for (int i = 1; i <= n; i++) {
            if (array2[i] == 2 && array2[i+1] == 0) {
                array2[i] -= 1;
                array2[i+1] += 1;
            }
        }
        // 0 2 일 때 1 1 만드는 (왼쪽 전달)
        for (int i = 1; i <= n; i++) {
            if (array2[i] == 2 && array2[i-1] == 0) {
                array2[i] -= 1;
                array2[i-1] += 1;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i : array1) {
            if (i > 0) count1++;
        }
        for (int i : array2) {
            if (i > 0) count2++;
        }
        return Math.max(count1, count2);
    }
}