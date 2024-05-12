package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Problem012 {

  // 백준 17298 골드4 오큰수 구하기
  // 스택
  // 오큰수란 Ai 보다 오른쪽에 있으면서 더 큰수 중 가장 왼쪽에 있는 수를 의미함.
  // 스택에 index를 push
  // pop index의 배열 값이 현재 순회 index 배열 값 보다 작다면 answer에 추가
  // 모두 다 순회 후, 스택에 값이 남아있다면 해당 인덱스에 -1 입력

  private static String solution(int[] array) {

    StringBuilder sb = new StringBuilder();
    int[] answer = new int[array.length];
    Deque<Integer> deque = new ArrayDeque<>();
    deque.addLast(0);
    for (int i = 1; i < array.length; i++) {
      while (!deque.isEmpty() && array[deque.peekLast()] < array[i]) {
        answer[deque.pollLast()] = array[i];
      }
      deque.addLast(i);
    }
    while (!deque.isEmpty()) {
      answer[deque.pollLast()] = -1;
    }

    Arrays.stream(answer).forEach(token -> sb.append(token).append(" "));

    return sb.toString();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
