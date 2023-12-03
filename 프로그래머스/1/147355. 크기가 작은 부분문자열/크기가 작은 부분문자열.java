class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = t.length() - p.length();
        
        for (int i = 0 ; i <= size ; i++) {
            String check = "";
            check += t.substring(i, i+p.length());
            if (Long.parseLong(check) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}