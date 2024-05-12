package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem013 {

  //백준 2164 실버4 카드게임

  private static int solution(int[] array) {
    Queue<Integer> queue = new LinkedList<>();
    Arrays.stream(array).forEach(queue::offer);
    while (queue.size() != 1) {
      queue.poll();
      queue.offer(queue.poll());
    }
    return queue.poll();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = i + 1;
      }
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
