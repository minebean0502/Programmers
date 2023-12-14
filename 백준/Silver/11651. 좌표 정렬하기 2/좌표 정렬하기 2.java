import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 반복문을 피하기 위한 x와 y
    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            // 입력값을 각각 x, y값을 나눠서 받고, Po
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
//            System.out.print("points의 x좌표는 : " +points[i].x + " ");
//            System.out.println("points의 y좌표는 : " +points[i].y);
        }

        // Merge Sort를 이용한 정렬
        mergeSort(points, 0, n - 1);

        // 결과 출력
        for (Point point : points) {
            bw.write(point.x + " " + point.y + "\n");
        }

        br.close();
        bw.close();
    }


    private static void mergeSort(Point[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // 왼쪽과 오른쪽을 나누어 각각 정렬
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // 합병
            merge(arr, left, mid, right);
        }
    }

    private static void merge(Point[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Point[] leftArr = new Point[n1];
        Point[] rightArr = new Point[n2];

        // 임시 배열에 데이터 복사
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            // y 좌표를 기준으로 비교
            if (leftArr[i].y <= rightArr[j].y) {
                // y 좌표가 같으면 x 좌표를 기준으로 정렬
                if (leftArr[i].y == rightArr[j].y) {
                    // arr[k++]는 왼쪽이 크면 leftArr[i++] // 오른쪽이 크면 rightArr[j++]
                    arr[k++] = (leftArr[i].x <= rightArr[j].x) ? leftArr[i++] : rightArr[j++];
                    // 아니면 그냥 arr[k++] = leftArr[i++]입니다
                } else {
                    arr[k++] = leftArr[i++];
                }
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // 남은 데이터 복사
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
}