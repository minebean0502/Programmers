import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int dividedbyFive;
    static int dividedbyFiveleft;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 봉지는 3과 5
        ArrayList<Integer> ablenums = new ArrayList<>();
        int test = Integer.parseInt(br.readLine());

        dividedbyFive = test / 5; // 몫 3
        dividedbyFiveleft = test % 5; // 나머지 3

        while (dividedbyFive >= 0) {
            if (dividedbyFiveleft % 3 == 0) {
                ablenums.add(dividedbyFive + dividedbyFiveleft/3);
                break;
            }

            // 처음엔 3 1 들어감 OK
            // 두번째 2 2 들어가지만 나머지 2 남으므로 패스
            // 세번째 1 4 들어가지만 나머지 1 남으므로 패스
            // 네번째 0 6 들어감 OK
            dividedbyFive--;
            dividedbyFiveleft += 5;
        }
        int answer = -1;
        for (int i = 0; i < ablenums.size(); i++) {
            answer= Math.max(answer, ablenums.get(i));
        }
        if (ablenums.isEmpty()) System.out.println(-1);
        else System.out.println(answer);
    }
}