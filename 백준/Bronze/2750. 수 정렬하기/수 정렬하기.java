import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < inputNum; i++) {
            array.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
    }
}