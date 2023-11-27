import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];

        for (int i = 0; i < arr.length; i++){
            arr[i] = -1;
        }
//        Scanner scanner = new Scanner(System.in);
//        String inputString = scanner.nextLine();
//        String B = "Baekjoon";

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
//            char k = inputString.charAt(i);
            char k = s.charAt(i);
            if (arr[(int) k - 97] == -1) {
                arr[(int) k - 97] = i;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
