class Solution {
    public static int solution(String s) {
        int answer = 0;
        int left = 0, right = 0;
        
        char K = s.charAt(0);
        
        for (int i = 0; i < s.length(); i++) {
            if (left == right) {
                answer++;
                K = s.charAt(i);
            }
            if (K == s.charAt(i)) {
                left++;
            } else {
                right++;
            }
        }

        return answer;
    }
}