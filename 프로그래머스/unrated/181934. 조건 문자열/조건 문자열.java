class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals("<")) {
            if (eq.equals("=")) {
                System.out.println("case1");
                return (n <= m ? 1 : 0);

            } else {
                System.out.println("case2");
                return (n > m ? 0 : 1);
            }
        }
        else if (ineq.equals(">")) {
            if (eq.equals("=")) {
                System.out.println("case3");
                return (n >= m ? 1 : 0);
            } else {
                System.out.println("case4");
                return (n < m ? 0 : 1);
            }
        }
        return 1;
    }
}