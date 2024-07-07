import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int avg = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(Integer.parseInt(br.readLine()));
            avg += list.get(i);
        }
        list.sort((i1, i2) -> i1 - i2);
        System.out.println(avg/5);
        System.out.println(list.get(2));
    }
}