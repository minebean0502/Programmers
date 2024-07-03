class Solution {
    static int countZero = 0; // 0이 몇개 사라짐?
    static int countChanges = 0; // 몇번 변환했지?
    
    public int[] solution(String s) {
        Recur(s);
        int[] answer = {countChanges, countZero};
        return answer;
    }
    
    public static void Recur(String s) {
        if (s.length() != 1) {
            String[] box = s.split("");
            String newOne = "";
            for (String num : box) {
                if (num.equals("0")) countZero++;
                else newOne += num;
            }
            String afterLength = Integer.toBinaryString(newOne.length());
            // System.out.println(afterLength);
            countChanges++;
            Recur(afterLength);
        }
        else return;
    }
}