import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        // s 길이만큼 반복
        for (int i = 0; i < s.length(); i++) {
            // #1. 만약 s.char[i]가 '('이면 stack에 추가
            if (s.charAt(i) == '(') {
                stack.push('(');
                // #2. 만약 s.char[i]가 ')'이고
                // case1 ()가 되었으니, (추가는 하지않고) '(' 제거(pop)
                // case2 s.char[i]가 먼저 ')'일 경우나
                // case2-1 s.char[i]가 ')'로 시작해서 아무것으로 끝나더라도
                // case2는 결국 전부 false가 나오니, false 반환 -> 전부 false 반환
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}