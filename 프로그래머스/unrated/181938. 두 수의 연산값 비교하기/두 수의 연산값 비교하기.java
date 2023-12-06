class Solution {
    public int solution(int a, int b) {
        String resultA = "" + a + b;
        int resultB =  2 * b * a;

        int resultAInt = Integer.parseInt(resultA);
          
        return Math.max(resultAInt, resultB);
        
    }
}