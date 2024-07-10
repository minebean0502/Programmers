import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main { // https://www.acmicpc.net/problem/10828
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        List<String> list = new ArrayList<>(List.of("push", "pop", "size", "empty", "top"));
        for (int i = 0; i < inputNum; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int commandNum = list.indexOf(command);
            switch (commandNum) {
                case 0 : // push
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case 1 : // pop
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        break;
                    }
                    else {
                        System.out.println(stack.pop());
                        break;
                    }
                case 2 : // size
                    System.out.println(stack.size());
                    break;
                case 3 : // empty
                    System.out.println(stack.isEmpty()? 1 : 0);
                    break;
                case 4 : // top
                    System.out.println( (!stack.isEmpty())? stack.peek() : -1 );
            }
        }
    }
}
