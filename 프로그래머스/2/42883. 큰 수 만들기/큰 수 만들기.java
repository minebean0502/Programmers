class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);

        for (int i = 0; i < sb.length() - 1 && k > 0; ) {
            if (sb.charAt(i) < sb.charAt(i + 1)) {
                sb.deleteCharAt(i);
                k--;
                if (i != 0) { // 삭제 후 한 칸 뒤로 이동
                    i--;
                }
            } else {
                i++;
            }
        }

        // 남은 k만큼의 숫자를 끝에서 제거
        if (k > 0) {
            sb.delete(sb.length() - k, sb.length());
        }

        return sb.toString();
    }
}