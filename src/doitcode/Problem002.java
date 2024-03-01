package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem002 {

  // 백준 1546 브론즈1 평균구하기
  // 자신의 시험점수 중 최댓값을 선택
  // 모든 점수를 점수/ 최댓값 * 100 으로 수정
  // 이때 평균이 몇인가?

  private static double getNewAverage(int[] array, int size) {
    int max = Integer.MIN_VALUE;
    int sum = 0;
    for (int token : array) {
      if (token > max) {
        max = token;
      }
      sum += token;
    }
    return sum * 100.0 / max / size;
  }


  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine()
          .split(" ");
      int[] array = Arrays.stream(inputs)
          .mapToInt(Integer::parseInt)
          .toArray();
      double result = getNewAverage(array, size);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
