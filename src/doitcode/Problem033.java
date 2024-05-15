package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem033 {

  // 백준 1715 카드 정렬하기
  // 그리디 알고리즘
  private static int solution(int[] cards) {
    Queue<Integer> queue = new PriorityQueue<>();

    Arrays.stream(cards).forEach(queue::add);

    int result = 0;
    while (queue.size() > 1) {
      int first = queue.remove();
      int second = queue.remove();
      int sum = first + second;
      result += sum;
      queue.add(sum);
    }
    return result;
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] cards = new int[size];
      for (int i = 0; i < size; i++) {
        int value = Integer.parseInt(br.readLine());
        cards[i] = value;
      }
      int result = solution(cards);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
