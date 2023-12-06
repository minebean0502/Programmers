class Solution {
    public int solution(int a, int b) {
        String resultA = "" + a + b;
        // String resultA = String.format("%d%d", a, b);
        // StringBuilder aBuilder = new StringBuilder();
        // aBuilder.append(a).append(b);
        String resultB = "" + b + a;

        int resultAInt = Integer.parseInt(resultA);
        int resultBInt = Integer.parseInt(resultB);
        
        if (resultAInt > resultBInt) {
            return resultAInt;
        }
        else {
            return resultBInt;
        }
    }
}