package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem024 {

  // 백준 2023 골드5 신기한 소수
  // dfs
  private static int n;
  private static List<Integer> list = new ArrayList<>();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      n = Integer.parseInt(br.readLine());
      dfs(2, 1);
      dfs(3, 1);
      dfs(5, 1);
      dfs(7, 1);
      list.sort(Comparator.naturalOrder());
      for (Integer token : list) {
        bw.write(token + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void dfs(int number, int digit) {
    if (digit == n) {
      if (isPrime(number)) {
        list.add(number);
      }
      return;
    }
    for (int i = 1; i < 10; i++) {
      if (i % 2 == 0) {
        continue;
      }
      if (isPrime(number * 10 + i)) {
        dfs(number * 10 + i, digit + 1);
      }
    }
  }

  private static boolean isPrime(int num) {
    for (int i = 2; i <= num / 2; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
