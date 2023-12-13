import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // N개의 정수 (1<= N <= 100,000)
        // M개의 정수 (1<= M <= 100,000)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 구역 1 - N의 갯수와, 입력받은 정보들을 arr에 저장
        // N = 5일때 / 4 1 5 2 3 을 arr[0~4]에 넣어줌
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 구역 2 - M의 갯수와, 입력받은 정보들을 arr_2에 저장
        // M= 5일때 / 1 3 7 9 5 을 arr_2[0~4]에 넣어줌
        int M = Integer.parseInt(br.readLine());
        int[] arr_2 = new int[M];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr_2[i] = Integer.parseInt(st2.nextToken());
        }
        // binary search를 하기전에 arr을 정렬해준다
        Arrays.sort(arr);

        // 1) binarySearch 메서드의 결과를 M만큼 반복하여 StringBuilder에 저장시켜주고
        for (int i = 0; i < M; i++) {
            sb.append(binarySearch(arr,arr_2[i])).append("\n");
        }
        // 2) 마지막 한줄로 출력해준다
        System.out.print(sb);
    }

    public static int binarySearch(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            // 1. 가운데에 원하는게 있다.
            if (arr[mid] == n) return 1;

            // 2. 가운데가 원하는 것보다 작다.
            else if (arr[mid] < n) left = mid + 1;
            // 3. 가운데가 원하는 것보다 크다
            else if (arr[mid] > n) right = mid - 1;
        }
        // 결국 찾는게 없으면 0 반환
        return 0;
    }
}
