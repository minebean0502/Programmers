import java.util.*;

class Solution {
    public int solution(String numbers) {
        int cnt = 0;
        // 순열 생성 "17의 경우" Set = [1, 7, 17, 71]
        Set<Integer> combinations = generateCombinations(numbers);
        // 최대값 생성 "17의 경우" -> 71
        int check = Integer.parseInt(maxableNum(numbers));
        
        // for 문으로 combination의 각 요소들이 소수인지 체크
        for (int i : combinations) {
            if (isPrimeCheck(check)[i]) cnt++;
        }

        return cnt;
    }
    // Part 1 순열 조합 부분
    // 모든 숫자 조합 생성
    private static Set<Integer> generateCombinations(String number) {
        Set<Integer> combinations = new HashSet<>();
        permutation("", number, combinations);
        return combinations;
    }

    // 순열 생성 함수
    private static void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if (!prefix.isEmpty()) {
            set.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), set);
        }
    }
    
    // Part 2 소수 판단 부분
    static boolean[] isPrime;
    static boolean[] isPrimeCheck (int n){
        
        // 0~n까지 배열 선언(size는 n+1개)
        isPrime = new boolean[n+1];

        // 초기값 true로 다채움
        for (int i = 0; i < n+1; i++) {
            isPrime[i] = true;
        }

        // 0과 1은 소수가 아니기 때문에 false
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i <= Math.sqrt(n)+1; i++) {
            if (isPrime[i]) {
                // 2) i의 배수들을 false(소수가 아님)
                for (int j = i*i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
    
    // String으로 만들 수 있는 가장 큰 수
    static String maxableNum(String n) {
        String[] numbers = n.split("");
        Arrays.sort(numbers, Collections.reverseOrder());
        // String numbers = "17"의 경우 -> "71" 반환
        return String.join("", numbers);
    }
}