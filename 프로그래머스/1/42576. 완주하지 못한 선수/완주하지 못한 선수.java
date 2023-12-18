import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> partihash = new HashMap<>();
        // getOrDefault 방식 생각해두기
        // put으로 Key값(person 이름들), value(갯수)를 넣을거임
        // 이름이 겹치면 value 값만 +1씩 증가할거임
        // getOrDefalut를 쓰면
        // 1) key 값이 없을 때 -> defaultValue인 0을 반환 -> 0+1 = 1
        // 2) key 값이 있을 때 -> 해당 value값(기존에 1이였으면 1)반환 -> 1+1 = 2
        for (String person : participant) {
            partihash.put(person, partihash.getOrDefault(person, 0) + 1);
        }
        // 넣는건 끝났으니, 반대로 completion에 있는 key값들을 빼봅시다
        for (String person : completion) {
            partihash.replace(person, partihash.getOrDefault(person, 0) -1);
        }
        for (String person : partihash.keySet()) {
            if (partihash.get(person) == 1) return person;
        }
        return null;
    }
}
