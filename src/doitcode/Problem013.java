package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem013 {

  //백준 2164 실버4 카드게임
  // 카드의 개수가 주어짐
  // 가장 위에있는 카드를 바닥에 버리고, 가장 위에있는 카드를 가장 아래에 있는 카드 밑으로 옮김
  // 1, 2, 3, 4 가 있다면, 1을 버리고 2, 3, 4 가 남음. 여기서 순서를 옮기면 3, 4, 2가 됨.
  // 3을 버리면 4, 2가 남고, 순서를 옮기면 2, 4가 됨. 마지막으로 2를 버리면 4가 남음
  // 가장 마지막에 남는 카드를 구하는 프로그램 작성
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int cardSize = Integer.parseInt(br.readLine());
      int result = solution(cardSize);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int solution(int cardSize) {
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 1; i <= cardSize; i++) {
      queue.offer(i);
    }

    while (queue.size() > 1) {
      queue.poll();
      queue.offer(queue.poll());
    }

    return queue.poll();
  }
}
