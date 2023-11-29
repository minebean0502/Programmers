class Solution {
    public static String solution(String new_id) {
        String answer = "";
        // 1단계 대문자 -> 소문자
        // toLowerCase 사용 <-> toUpperCase
        String steps = new_id.toLowerCase();
        
        // 2단계 특수문자 제거
        // replaceall 사용
        // steps = steps.replaceAll("[*!@#^=+]", "");
        
        steps = steps.replaceAll("[^0-9|a-z|\\-_\\.]", "");

        // 3단계 ..+ -> . 축소
        // 정규표현식 참고
        steps = steps.replaceAll("[.]{2,}", ".");

        // 4단계 처음의 . 제거
        // System.out.println(steps.charAt(0)); -> . 반환
        if ((char)(steps.charAt(0)) == 46) steps = steps.substring(1);
        if (steps.length() > 1 && (char)(steps.charAt(steps.length()-1)) == 46) steps = steps.substring(0, steps.length()-1);

        // 5단계 문자열 없을 경우 a삽입
        if (steps.length() == 0) steps += "a";

        // 6단계 [0:15]
        if (steps.length() >= 16) steps = steps.substring(0, 15);
        steps = steps.replaceAll("\\.$","");

        // 7단계 2자 이하 -> 반복
//        if (steps.length() == 1) {
//            steps += steps.charAt(0);
//            steps += steps.charAt(0);
//        } else if (steps.length() == 2) {
//            steps += steps.charAt(0);
//        }
        
        if (steps.length() <3) {
            while(steps.length() != 3) steps += steps.charAt(steps.length()-1);
        }
        return steps;
    }
}
