import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // 아이템을 넣을때 - queue.offer
        // 아이템 회수할 때 - queue.poll
        // Queue를 만든다.
        Queue<Integer> queue = new LinkedList<>();
        // for를 이용해 1 ~ N 까지의 N개의 숫자를 Queue에 넣는다.
        for (int i = 1; i < n+1; i++) {
            queue.offer(i);
        }
        // Queue의 크기가 1보다 클 동안
        while (queue.size() > 1) {
            // Queue의 제일 앞의 아이템을 버리고
            queue.poll();
            // 그 다음 앞의 아이템을 빼서, (poll)
            int temp = queue.poll();
            // 제일 뒤로 넣는다 (offer)
            queue.offer(temp);
        }
        // 마지막 남은 아이템을 출력한다.
        System.out.println(queue.poll());
    }
}