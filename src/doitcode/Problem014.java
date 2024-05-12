package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem014 {

  // 백준 11286 실버1 절댓값 힙 구현하기
  // 연산 값이 0이 아니라면 해당 값의 절댓값을 배열에 추가
  // 연산 값이 0이라면 절댓값이 가장 작은 값을 출력하고, 배열에서 제거
  // 만약, 배열이 비어있는데 출력해야한다면 0을 반환
  private static String solution(int[] query) {
    StringBuilder sb = new StringBuilder();
    Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
      int first = Math.abs(o1);
      int second = Math.abs(o2);
      if (first == second) {
        return o1 > o2 ? 1 : -1;
      } else {
        return first - second;
      }
    });

    for (int operation : query) {
      if (operation == 0) {
        if (queue.isEmpty()) {
          sb.append("0");
        } else {
          sb.append(queue.poll());
        }
        sb.append("\n");
      } else {
        queue.offer(operation);
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int querySize = Integer.parseInt(br.readLine());
      int[] query = new int[querySize];
      for (int i = 0; i < querySize; i++) {
        query[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(query);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
