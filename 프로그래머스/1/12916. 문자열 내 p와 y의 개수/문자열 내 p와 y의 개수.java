class Solution {
    static int countP;
    static int countY;
    
    boolean solution(String s) {
        String[] array = s.split("");
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("p") || array[i].equals("P")) {
                countP++;
            } else if (array[i].equals("y") || array[i].equals("Y")) {
                countY++;
            }
        }
        if (countY==countP) return true;
        else return false;
    }
}