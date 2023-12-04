import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferReader 사용
        // 어떤 입력에 대하여 버퍼링 기능 제공
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] splitString = input.split(" ");
        int[] answer = new int[6];
        int[] standard = {1, 1, 2, 2, 2, 8};
//        for (String split : splitString) {
//            System.out.println(split);
//        }
        for (int i = 0; i < splitString.length; i++) {
            answer[i] = standard[i] - Integer.parseInt(splitString[i]);
        }
        System.out.println(String.format(
                "%d %d %d %d %d %d",
                answer[0],
                answer[1],
                answer[2],
                answer[3],
                answer[4],
                answer[5]
        ));

    }
}