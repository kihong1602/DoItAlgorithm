package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem002 {

  // 백준 1546 브론즈1 평균구하기
  // 자신의 시험점수 중 최댓값을 선택
  // 모든 점수를 점수/ 최댓값 * 100 으로 수정
  // 이때 평균이 몇인가?

  private static String solution(int[] records) {
    int max = Integer.MIN_VALUE;
    int sum = 0;

    for (int record : records) {
      max = Math.max(max, record);
      sum += record;
    }
    double result = sum * 100.0 / max / records.length;
    return String.valueOf(result);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      int[] records = new int[size];
      for (int i = 0; i < size; i++) {
        records[i] = Integer.parseInt(inputs[i]);
      }

      String result = solution(records);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
