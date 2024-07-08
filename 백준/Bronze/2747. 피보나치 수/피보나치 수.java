import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // https://www.acmicpc.net/problem/2747
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] fiv = new int[46];
        fiv[0] = 0;
        fiv[1] = 1;
        int inputNum = Integer.parseInt(br.readLine());
        if (inputNum < 2) {
            System.out.println(fiv[inputNum]);
        } else {
            for (int i = 2; i <= inputNum; i++) {
                fiv[i] = fiv[i-1] + fiv[i-2];
            }
            System.out.println(fiv[inputNum]);
        }
    }
}