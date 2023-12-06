import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static boolean isVPS(String line) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean answer= true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i)== '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
//        // false
//        System.out.println(isVPS("(())())"));
//        // false
//        System.out.println(isVPS("(((()())()"));
//        // true
//        System.out.println(isVPS("(()())((()))"));

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int tests = Integer.parseInt(reader.readLine());

        // 테스트 케이스의 갯수만큼 반복
        for (int i = 0; i < tests; i++) {
            // 다음 입력받은 줄을 테스트한 결과가 참이면,
            if (isVPS(reader.readLine())) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
