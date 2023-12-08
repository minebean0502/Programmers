import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 후위연산자 원래대로 되돌리기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strs = new String[str.length()];
        Stack<String> stack = new Stack<>();

        // stack에 삽입 완료
        for (int i = 0; i < str.length(); i++) {
            String[] subs = str.split("");
            strs[i] = subs[i];
        }
        // strs = [1,2,3,*,+]

        // 계산
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals("*")) {
                int temp1 = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
                String temp2 = String.valueOf(temp1);
                stack.push(temp2);
            }
            else if (strs[i].equals("+")) {
                int temp1 = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
                String temp2 = String.valueOf(temp1);
                stack.push(temp2);
            }
            else if (strs[i].equals("-")) {
                int temp1 = Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop());
                String temp2 = String.valueOf(temp1*-1);
                stack.push(temp2);
            }
            else if (strs[i].equals("/")) {
                int temp1 = Integer.parseInt(stack.pop());
                int temp1_1 = Integer.parseInt(stack.pop());
                String temp2 = String.valueOf(temp1_1/temp1);
                stack.push(temp2);
            }
            else {
                stack.push(strs[i]);
            }
        }
        System.out.println(String.valueOf(stack.pop()));
    }
}
