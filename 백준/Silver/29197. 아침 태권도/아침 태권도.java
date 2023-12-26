import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Student {
        int x, y;

        Student(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isBlocking(Student other) {
            // 1) 내적 비교
            return this.y * other.x == this.x * other.y //
                    // 2) 원점을 기준으로 같은 방향 (같은 선분 위에 있는지 내적)
                    && this.x * other.x + this.y * other.y > 0
                    // 3) 거리가 가까운지 (원점으로부터의 선분의 길이 비교)
                    && this.x * this.x + this.y * this.y
                    < other.x * other.x + other.y * other.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Student[] students = new Student[n];

        // 모든 학생들을 다 읽기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            students[i] = new Student(x, y);
        }

        // 보이는 학생수
        int visibleStudents = 0;

        // 학생이 보이는지 안보이는지 체크하기
        for (int i = 0; i < n; i++) {
            boolean isVisible = true;
            for (int j = 0; j < n; j++) {
                if (i != j && students[j].isBlocking(students[i])) {
                    isVisible = false;
                    break;
                }
            }
            // 만약에 보인다면 (isVisible = true -> visbleStudents ++)
            if (isVisible) {
                visibleStudents++;
            }
        }

        System.out.println(visibleStudents);
    }
}
