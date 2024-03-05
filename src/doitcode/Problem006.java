package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem006 {

  //백준 실버5 2018 연속된 자연수의 합 구하기
  // 1~10_000_000에서 연속된 자연수의 합으로 나타낼 수 있는 가짓수를 표현하시오.
  // 투포인터 알고리즘
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int targetNumber = Integer.parseInt(br.readLine());
      int leftPoint = 1;
      int rightPoint = 1;
      int sum = 1;
      int count = 1; // targetNumber 하나만 뽑는 경우의 수를 미리 카운트
      // sum이 targetNumber와 같다면 -> count++, sum += rightPoint, rightPoint++
      // sum이 targetNumber보다 크다면 -> sum -= leftPoint, leftPoint++
      // sum이 targetNumber보다 작다면 -> sum+= rightPoint, rightPoint++
      while (rightPoint != targetNumber) {
        if (sum == targetNumber) {
          count++;
          sum += rightPoint;
          rightPoint++;
        }
        if (sum > targetNumber) {
          sum -= leftPoint;
          leftPoint++;
        }
        if (sum < targetNumber) {
          sum += rightPoint;
          rightPoint++;
        }
      }
      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
