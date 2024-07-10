import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static LinkedList<String> list;
    static ListIterator<String> iterator;
    static String[] inputs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < inputNum; i++) {
            list = new LinkedList<>();
            iterator = list.listIterator();
            inputs = br.readLine().split("");
            for (String str : inputs) {
                switch (str) {
                    case "<" :
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        break;
                    case ">" :
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        break;
                    case "-" :
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default :
                        iterator.add(str);
                        break;
                }
            }
            for (String str : list) {
                sb.append(str);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
