package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem008 {

  // 백준 골드4 1253 좋은 수 구하기
  // 주어진 N개의 수 중 다른 두 수의 합으로 표현되는 수를 좋은 수 라고함.
  // N개의 수 중 좋은 수가 몇개인지 ?
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] inputs = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .sorted()
          .toArray();
      int result = 0;
      for (int i = 0; i < size; i++) {
        int find = inputs[i];
        int leftPoint = 0;
        int rightPoint = inputs.length - 1;

        while (leftPoint < rightPoint) {
          int sum = inputs[leftPoint] + inputs[rightPoint];
          if (sum == find) {
            if (leftPoint != i && rightPoint != i) {
              result++;
              break;
            } else if (leftPoint == i) {
              leftPoint++;
            } else if (rightPoint == i) {
              rightPoint--;
            }
          } else if (sum < find) {
            leftPoint++;
          } else {
            rightPoint--;
          }
        }
      }
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
