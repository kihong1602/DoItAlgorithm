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
      for (int token : list) {
        bw.write(token + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 한자릿수 소수와 자릿수를 입력받아 dfs 실행
  private static void dfs(int number, int digit) {
    if (digit == n) {
      // 탐색하는 수의 자릿수가 n과 같다면 소수인지 판별
      if (isPrime(number)) {
        list.add(number);
      }
      return;
    }
    for (int i = 1; i < 10; i++) {
      // 1의 자릿수를 추가해서 dfs 수행할 것
      if (i % 2 == 0) {
        // 만약 짝수라면 넘김
        continue;
      }
      // 홀수를 추가하고, 자릿수를 1 올린 number가 소수라면
      if (isPrime(number * 10 + i)) {
        // digit(자릿수)를 올리고, 새로 생성한 number로 dfs 수행
        dfs(number * 10 + i, digit + 1);
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
}
