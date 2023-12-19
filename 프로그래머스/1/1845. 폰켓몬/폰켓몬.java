import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int selectableNums = nums.length /2;
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        return Math.min(set.size(), selectableNums);
    }
}