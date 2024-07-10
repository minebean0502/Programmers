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
        for (int i = 0; i < inputNum; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" : // push
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop" : // pop
                    System.out.println(stack.isEmpty()? -1 : stack.pop());
                    break;
                case "size" : // size
                    System.out.println(stack.size());
                    break;
                case "empty" : // empty
                    System.out.println(stack.isEmpty()? 1 : 0);
                    break;
                case "top" : // top
                    System.out.println(stack.isEmpty()? -1 : stack.peek());
            }
        }
    }
}
