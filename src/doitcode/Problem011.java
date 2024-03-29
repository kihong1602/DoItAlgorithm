package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Problem011 {

  // 백준 1874 실버3 스택으로 오름차순 수열 만들기
  // 1부터 오름차순으로 스택에 push 한다고 가정
  // 수열이 주어졌을때 주어진 수열을 만들 수 있는지 확인
  // 만들수 있다면 push와 pop을 수행해야 하는지 확인하는 프로그램을 작성

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int arraySize = Integer.parseInt(br.readLine());
      int[] numbers = new int[arraySize];
      for (int i = 0; i < arraySize; i++) {
        numbers[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(numbers);

      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String solution(int[] numbers) {
    StringBuilder sb = new StringBuilder();
    Deque<Integer> stack = new ArrayDeque<>();
    int num = 1;
    boolean result = true;
    for (int target : numbers) {
      if (target >= num) {
        while (target >= num) {
          stack.addLast(num++);
          sb.append("+")
              .append("\n");
        }
        stack.pollLast();
        sb.append("-")
            .append("\n");
      } else {
        if (stack.pollLast() > target) {
          result = false;
          break;
        } else {
          sb.append("-")
              .append("\n");
        }
      }

    }

    return result ? sb.toString() : "NO";
  }

}
