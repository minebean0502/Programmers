import java.util.Stack;

class Solution{
    public static int solution(String s){
        // 조건에 대해 세울 수 없다면 Stack으로 푸는게 좋음
        Stack<Character> stack = new Stack<>(); // LIFO였다
        char[] box = s.toCharArray();
        for (char one : box) {
            // 비어있다면 넣어줌
            if (stack.isEmpty()) stack.push(one);
            // 비어있지 않다면 빼야하는데 조건에 따라 빼야함
            else if (!stack.isEmpty()) {
                if (stack.peek().equals(one)) stack.pop();
                else stack.push(one);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}