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
  // 배열에 정수 x를 넣는다
  // 배열에서 절댓값이 가장 작은 값을 출력한 후 그 값을 배열에서 제거한다.
  // 절댓값이 가장 작은 값이 여러개일 경우에는 그 중 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
  // 배열이 비어있는데 절댓값이 가장 작은 값을 출력하라고 할 때는 0을 출력
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int operationSize = Integer.parseInt(br.readLine());
      int[] operations = new int[operationSize];
      for (int i = 0; i < operationSize; i++) {
        operations[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(operations);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String solution(int[] operations) {
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
    for (int operation : operations) {
      if (operation == 0) {
        if (queue.isEmpty()) {
          sb.append(0)
              .append("\n");
        } else {
          sb.append(queue.poll())
              .append("\n");
        }
      } else {
        queue.offer(operation);
      }
    }
    return sb.toString();
  }

}
