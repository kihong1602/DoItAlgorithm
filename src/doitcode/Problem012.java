package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class Problem012 {

  // 백준 17298 골드4 오큰수 구하기
  // 스택
  // 오큰수란 Ai 보다 오른쪽에 있으면서 더 큰수 중 가장 왼쪽에 있는 수를 의미함.
  // 스택에 index를 push
  // pop index의 배열 값이 현재 순회 index 배열 값 보다 작다면 answer에 추가
  // 모두 다 순회 후, 스택에 값이 남아있다면 해당 인덱스에 -1 입력
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int arraySize = Integer.parseInt(br.readLine());
      int[] array = new int[arraySize];
      String[] input = br.readLine()
          .split(" ");
      for (int i = 0; i < array.length; i++) {
        array[i] = Integer.parseInt(input[i]);
      }

      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String solution(int[] array) {
    StringBuilder sb = new StringBuilder();
    int[] answer = new int[array.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    for (int i = 1; i < array.length; i++) {
      while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
        answer[stack.pop()] = array[i];
      }
      stack.push(i);
    }
    while (!stack.isEmpty()) {
      answer[stack.pop()] = -1;
    }
    Arrays.stream(answer)
        .forEach(token -> sb.append(token)
            .append(" "));
    return sb.toString();
  }
}
