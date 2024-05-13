package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem024 {

  // 백준 2023 골드5 신기한 소수
  // dfs
  private static int N;
  private static StringBuilder sb = new StringBuilder();

  private static void dfs(int number, int digit) {
    if (digit == N) {
      if (isPrime(number)) {
        sb.append(number).append("\n");
      }
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (i % 2 == 0) {
        continue;
      }
      int value = number * 10 + i;
      if (isPrime(value)) {
        dfs(value, digit + 1);
      }
    }
  }

  private static boolean isPrime(int number) {
    for (int i = 2; i <= number / 2; i++) {
      if (number % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      N = Integer.parseInt(br.readLine());
      dfs(2, 1);
      dfs(3, 1);
      dfs(5, 1);
      dfs(7, 1);
      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}