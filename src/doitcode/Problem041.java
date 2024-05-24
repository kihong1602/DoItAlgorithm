package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem041 {
  // 백준 11689 오일러 피 함수 구현하기

  private static long solution(long value) {
    long result = value;
    for (long i = 2; i <= Math.sqrt(value); i++) {
      if (value % i == 0) {
        result -= result / i;
        while (value % i == 0) {
          value /= i;
        }
      }
    }
    if (value > 1) {
      result -= result / value;
    }
    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      long value = Long.parseLong(br.readLine());
      long result = solution(value);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
