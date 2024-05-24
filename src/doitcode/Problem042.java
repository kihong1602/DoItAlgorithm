package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem042 {
  // 백준 1934 최소공배수

  private static int solution(int first, int second) {
    return (first * second) / gcd(first, second);
  }

  private static int gcd(int first, int second) {
    if (second == 0) {
      return first;
    }
    return gcd(second, first % second);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      while (size-- > 0) {
        String[] inputs = br.readLine().split(" ");
        int first = Integer.parseInt(inputs[0]);
        int second = Integer.parseInt(inputs[1]);
        int result = solution(first, second);
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }


}
