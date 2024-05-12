package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem010 {

  // 백준 11003 플래티넘 최솟값 찾기
  // 슬라이딩 윈도우
  private static String solution(int[] array, int window) {
    StringBuilder sb = new StringBuilder();
    Deque<Node> deque = new ArrayDeque<>();
    for (int i = 0; i < array.length; i++) {
      int now = array[i];

      while (!deque.isEmpty() && deque.getLast().value > now) {
        deque.removeLast();
      }
      deque.addLast(new Node(i, now));

      if (deque.getFirst().index <= i - window) {
        deque.removeFirst();
      }
      sb.append(deque.getFirst().value).append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int size = Integer.parseInt(sizes[0]);
      int window = Integer.parseInt(sizes[1]);
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(array, window);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  static class Node {

    int index;
    int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

}
