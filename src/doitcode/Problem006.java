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
  private static int solution(int[] array, int target) {
    int sum = 1;
    int result = 1;
    int left = 0;
    int right = 0;

    while (right < target - 1) {
      if (sum == target) {
        result++;
        right++;
        sum += array[right];
      }
      if (sum < target) {
        right++;
        sum += array[right];
      }
      if (sum > target) {
        sum -= array[left];
        left++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int target = Integer.parseInt(br.readLine());
      int[] array = new int[target];
      for (int i = 0; i < target; i++) {
        array[i] = i + 1;
      }
      int result = solution(array, target);
      bw.write(String.valueOf(result));
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
