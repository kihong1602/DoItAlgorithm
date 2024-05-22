package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem038 {
  // 백준 1456 거의소수

  private static boolean[] createIsPrime() {
    int size = (int) Math.pow(10, 7);
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

  private static int solution(boolean[] isPrime, long min, long max) {
    List<Long> list = new ArrayList<>();
    for (int i = 2; i < isPrime.length; i++) {
      if (isPrime[i]) {
        list.add((long) i);
      }
    }

    int count = 0;
    for (long token : list) {
      long tmp = token * token;
      while (tmp <= max) {
        if (tmp >= min) {
          count++;
        }
        if (tmp > max / token) {
          break;
        }
        tmp *= token;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      long min = Long.parseLong(inputs[0]);
      long max = Long.parseLong(inputs[1]);

      boolean[] isPrime = createIsPrime();
      int result = solution(isPrime, min, max);
      
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }


}
