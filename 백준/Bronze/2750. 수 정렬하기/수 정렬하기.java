import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main { // https://www.acmicpc.net/problem/2750
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        int[] array = new int[inputNum];
        for (int i = 0; i < inputNum; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}