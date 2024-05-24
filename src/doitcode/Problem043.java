package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem043 {
  // 백준 1850 최대공약수

  private static String solution(long first, long second) {
    StringBuilder sb = new StringBuilder();

    long count = gcd(first, second);
    while (count > 0) {
      sb.append(1);
      count--;
    }

    return sb.toString();
  }

  private static long gcd(long first, long second) {
    if (second == 0) {
      return first;
    }
    return gcd(second, first % second);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      long first = Long.parseLong(inputs[0]);
      long second = Long.parseLong(inputs[1]);
      String result = solution(first, second);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }


}
