class Solution {
    public int solution(int n) {
        int count = 2;
        while(true){
            if (count*count == n){
                return 1;
            } else if(count*count > n){
                return 2;
            } else {
                count++;
            }
        }
    }
}