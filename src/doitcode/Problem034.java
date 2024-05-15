package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem034 {
  // 백준 1744 수 묶기
  // 그리디 알고리즘

  private static int solution(int[] array) {
    Queue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
    Queue<Integer> minusQueue = new PriorityQueue<>();
    int zero = 0, one = 0;

    for (int token : array) {
      if (token == 0) {
        zero++;
      }
      if (token == 1) {
        one++;
      }
      if (token > 1) {
        plusQueue.add(token);
      }
      if (token < 0) {
        minusQueue.add(token);
      }
    }

    int result = one;
    while (plusQueue.size() > 1) {
      int first = plusQueue.remove();
      int second = plusQueue.remove();
      result += first * second;
    }
    if (!plusQueue.isEmpty()) {
      result += plusQueue.remove();
    }

    while (minusQueue.size() > 1) {
      int first = minusQueue.remove();
      int second = minusQueue.remove();
      result += first * second;
    }
    if (!minusQueue.isEmpty()) {
      if (zero == 0) {
        result += minusQueue.remove();
      }
    }
    return result;
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
