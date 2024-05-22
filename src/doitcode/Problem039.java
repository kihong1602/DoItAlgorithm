package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem039 {
  // 백준 1747 소수&팰린드롬

  private static boolean[] createIsPrime() {
    int size = 2_000_000;
    boolean[] isPrime = new boolean[size + 1];
    Arrays.fill(isPrime, true);
    isPrime[0] = isPrime[1] = false;
    for (int i = 2; i <= Math.sqrt(size); i++) {
      if (!isPrime[i]) {
        continue;
      }
      for (int j = i * i; j <= size; j += i) {
        isPrime[j] = false;
      }
    }
    return isPrime;
  }

  private static int solution(int target, boolean[] isPrime) {
    int result = 0;
    for (int i = target; i < isPrime.length; i++) {
      if (!isPrime[i]) {
        continue;
      }
      String prime = String.valueOf(i);
      if (checkPalindrome(prime)) {
        result = i;
        break;
      }
    }
    return result;
  }

  private static boolean checkPalindrome(String prime) {
    for (int i = 0; i < prime.length() / 2; i++) {
      if (prime.charAt(i) != prime.charAt(prime.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int target = Integer.parseInt(br.readLine());
      boolean[] isPrime = createIsPrime();
      int result = solution(target, isPrime);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
