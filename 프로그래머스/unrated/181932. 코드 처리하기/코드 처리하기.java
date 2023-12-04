class Solution {
    public String solution(String code) {
        String answer= "";
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1' && mode == 0){ // mode 0일때 code[idx] = 1이면 case2
                mode = 1;
            } else if (code.charAt(i) == '1' && mode == 1) { // mode 1일때 code[idx] = 1이면 case4
                mode = 0;
            } else if (i % 2 ==0 && mode == 0) { // mode 0일때 idx짝수면 case1
                answer += code.charAt(i);
            } else if (i % 2 !=0 && mode == 1) { // mode 1일때 idx홀수면 case3
                answer += code.charAt(i);
            }
        }
        if (answer.length() == 0){
            answer = "EMPTY";
            return answer;
        }
        else return answer;
    }
}
