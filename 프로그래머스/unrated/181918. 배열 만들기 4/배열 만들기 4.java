import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public ArrayList solution(int[] arr) {
        int count = 0;
        ArrayList<Integer> stk = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        // primitive 타입 리스트 변환시 -> (1) 반복문 or (2) Stream
        for (int i : arr) {
            intList.add(i); // intList = [1,2,3,4,5]
        }
        while (count != arr.length){
            if (stk.size() == 0) {
                stk.add(intList.get(count));
                count++;
            } else if (stk.get(stk.size()-1) < arr[count]){
                stk.add(arr[count]);
                count++;
            } else if (stk.get(stk.size()-1) >= arr[count]) {
                stk.remove(stk.size()-1);
            }

        }
        
        return stk;
    }
}