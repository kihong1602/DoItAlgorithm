package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem040 {
  // 백준 1016 제곱ㄴㄴ수

  private static int solution(long min, long max) {
    boolean[] check = new boolean[(int) (max - min + 1)];
    for (long i = 2; i <= Math.sqrt(max); i++) {
      long pow = i * i;
      long start = min / pow;
      if (min % pow != 0) {
        start++;
      }
      start *= pow;
      for (long j = start; j <= max; j += pow) {
        check[(int) (j - min)] = true;
      }
    }

    int count = 0;
    for (boolean flag : check) {
      if (!flag) {
        count++;
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
      int result = solution(min, max);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
