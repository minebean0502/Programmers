import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader 선언과 Stack 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        // 첫 줄의 갯수만큼 for 구문 반복
        // 두번째줄 ~ 마지막줄까지 stack에 push
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            stack.push(num);
        }
        // 정답용 int count와, peek값을 저장할 temp 선언

        int count = 0;
        int temp = 0;

        // for (stack 크기만큼 -> 0까지)
        // stack size는 6임
        for (int j = stack.size(); j > 0; j--) {
            // 주의! if문에 stack.pop()을 써도 마지막 값 사라지니 사용에 주의!
            // #1. stack.peek()값(#1은 6)이 temp값(0)보다 크다면
            // count에 ++하고, temp값을 pop로 대체
            if (stack.peek() > temp) {
                count++;
                temp = stack.pop();
            }
            // #2. stack.peek()값(#2는 4)이 temp값(6)보다 같거나 작을 경우들은
            // count는 추가 할 필요는 없고, 대신 pop으로 값은 추출해줘야함
            else stack.pop();
        }
        System.out.println(count);
    }
}
