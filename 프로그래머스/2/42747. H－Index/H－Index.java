class Solution {
    public int solution(int[] citations) {
        int n = citations.length;;
        int H_index = 0;
        heapSort(citations);
        
        for (int i = 0; i < n; i++) {
            int h = citations[i] <= n-i ? citations[i] : n-i;
            H_index = H_index <= h ? h : H_index;
        }
        
        return H_index;
    }
    
    private static void heapSort(int[] arr) {
        int n = arr.length;

        // 최대 힙 구성
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 힙 정렬 수행
        for (int i = n - 1; i > 0; i--) {
            // 최대값(루트)을 배열 끝으로 이동
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 힙 재구성
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            // 최대값이 루트가 아니라면 교환
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // 변경된 부분에 대해 재귀적으로 힙 재구성
            heapify(arr, n, largest);
        }
    }
}