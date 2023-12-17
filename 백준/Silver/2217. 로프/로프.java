import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 로프 개수 입력
        int n = Integer.parseInt(br.readLine());

        // 로프안에 넣기
        int[] ropes = new int[n];
        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }
        // 일단 정렬
        Arrays.sort(ropes);
        // 내림차순 정렬 (큰거~작은거)
        for (int i = 0; i < n / 2; i++) {
            int temp = ropes[i];
            ropes[i] = ropes[n - 1 - i];
            ropes[n - 1 - i] = temp;
        }
        // 최대를 구하는 방법
        // input N = 5
        // 2, 10, 8, 5, 7 일때 -> [2, 5, 7, 8, 10] -> [10, 8, 7, 5, 2]
        // 한개만 쓸 때 ) 10 vs 10*1 (10*1)
        // 두개만 쓸 때 ) 10+8 vs 8+8 (8*2)
        // 세개만 쓸 때 ) 10+8+7 vs 7+7+7 (7*3)
        // 네개만 쓸 때 ) 10+8+7+5 vs 5+5+5+5 (5*4)
        // 다섯개 쓸 때 ) 10+8+7+5+2 vs 2+2+2+2+2 (2*5)
        
        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int weight = ropes[i] * (i+1);
            maxWeight = Math.max(maxWeight, weight);
        }
        System.out.println(maxWeight);

        
    }
}