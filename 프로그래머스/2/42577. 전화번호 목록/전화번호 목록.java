import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();

        for (String phone : phone_book) {
            set.add(phone);
        }

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                // 접두사가 HashSet에 있는지 확인
                if (set.contains(phone.substring(0, i))) {
                return false;
                }
            }
        }
        return true;
    }
}