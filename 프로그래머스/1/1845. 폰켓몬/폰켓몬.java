import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int selectableNums = nums.length /2;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return Math.min(set.size(), selectableNums);
    }
}