package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem037 {
  // 백준 1929 소수 구하기

  private static String solution(int start, int end) {
    boolean[] isPrime = createPrimes(end);
    StringBuilder sb = new StringBuilder();
    for (int i = start; i <= end; i++) {
      if (isPrime[i]) {
        sb.append(i).append("\n");
      }
    }
    return sb.toString();
  }

  private static boolean[] createPrimes(int end) {
    boolean[] isPrime = new boolean[end + 1];
    for (int i = 2; i < isPrime.length; i++) {
      isPrime[i] = true;
    }
    for (int i = 2; i <= Math.sqrt(end); i++) {
      if (!isPrime[i]) {
        continue;
      }
      for (int j = i * i; j <= end; j += i) {
        isPrime[j] = false;
      }
    }
    return isPrime;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int start = Integer.parseInt(inputs[0]);
      int end = Integer.parseInt(inputs[1]);
      String result = solution(start, end);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
