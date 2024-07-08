import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        BigInteger[] fiv = new BigInteger[inputNum+1];
        fiv[0] = BigInteger.ZERO;
        fiv[1] = BigInteger.ONE;
        if (inputNum < 2) {
            System.out.println(fiv[inputNum]);
        } else {
            for (int i = 2; i <= inputNum; i++) {
                fiv[i] = fiv[i-1].add(fiv[i-2]);
            }
            System.out.println(fiv[inputNum]);
        }
    }
}