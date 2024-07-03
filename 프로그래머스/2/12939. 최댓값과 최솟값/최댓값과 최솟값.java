import java.util.Arrays;

class Solution {
    static int max = 0;
    static int min = 0;
    
    public String solution(String s) {
        String[] array = s.split(" ");
        Arrays.sort(array);
        int[] arrays = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrays[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(arrays);
        StringBuilder sb = new StringBuilder();
        return String.valueOf(sb.append(arrays[0]+ " " + arrays[arrays.length-1]));
    }
}