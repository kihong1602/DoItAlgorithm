package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Problem010 {

  // 백준 11003 플래티넘 최솟값 찾기
  // 슬라이딩 윈도우
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputSizes = br.readLine()
          .split(" ");
      int windowSize = Integer.parseInt(inputSizes[1]);

      int[] array = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      String result = solution(array, windowSize);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String solution(int[] array, int windowSize) {
    StringBuilder sb = new StringBuilder();
    Deque<Node> deque = new LinkedList<>();

    for (int i = 0; i < array.length; i++) {
      int now = array[i];

      while (!deque.isEmpty() && deque.getLast().value > now) {
        deque.removeLast();
      }

      deque.addLast(new Node(i, now));
      if (deque.getFirst().index <= i - windowSize) {
        deque.removeFirst();
      }
      sb.append(deque.getFirst().value)
          .append(" ");

    }
    return sb.toString();
  }

  static class Node {

    public int index;
    public int value;

    Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

}
