class Solution {
    public String solution(int[] numLog) {
        StringBuilder answerBuilder = new StringBuilder();
        // 인덱스(순서)가지고 순회를 할 것이며
        // n-1까지만 순회
        for (int i = 0; i < numLog.length - 1; i++) {
            int diff = numLog[i + 1] - numLog[i];
            switch (diff) {
                case 1:
                    answerBuilder.append("w");
                    break;
                case -1:
                    answerBuilder.append("s");
                    break;
                case 10:
                    answerBuilder.append("d");
                    break;
                case -10:
                    answerBuilder.append("a");
                    break;
            }
        }
        return answerBuilder.toString();
    }
}