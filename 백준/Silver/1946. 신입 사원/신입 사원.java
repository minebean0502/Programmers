import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/1946

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine()); // 지원자 수
            int[][] applicants = new int[m][2];

            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[j][0] = Integer.parseInt(st.nextToken()); // 서류 심사 순위
                applicants[j][1] = Integer.parseInt(st.nextToken()); // 면접 심사 순위
            }

            // 서류 심사 순위 기준으로 오름차순 정렬
            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int count = 1; // 서류 1등은 무조건 선발
            int bestInterviewRank = applicants[0][1]; // 현재까지의 최고 면접 순위

            for (int j = 1; j < m; j++) {
                // 현재 지원자의 면접 순위가 이전 지원자의 면접 순위보다 높은 경우
                if (applicants[j][1] < bestInterviewRank) {
                    count++; // 선발
                    bestInterviewRank = applicants[j][1]; // 최고 면접 순위 갱신
                }
            }
            System.out.println(count);
        }
    }
}