import java.util.Arrays;

class Solution {
    static int max = 0;
    static int min = 0;
    
    public String solution(String s) {
        String[] array = s.split(" ");
        int max = Integer.parseInt(array[0]);
        int min = Integer.parseInt(array[0]);
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, Integer.parseInt(array[i]));
            min = Math.min(min, Integer.parseInt(array[i]));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(min + " " + max);
        return String.valueOf(sb);
    }
}