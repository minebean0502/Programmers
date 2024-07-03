class Solution {
    public int solution(String s) {
        String[] array = s.split("");
        String answer = "";
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("+")) {
                continue;
            } else if (array[i].equals("-")) {
                answer += array[i];
            }
            else answer += array[i];
        }
        return Integer.parseInt(answer);
    }
}