package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem032 {
  // 백준 11047 동전 개수의 최소값 구하기

  private static int solution(int[] wallet, int target) {
    int result = 0;

    for (int money : wallet) {
      if (target < money) {
        continue;
      }
      result += target / money;
      target %= money;
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int size = Integer.parseInt(sizes[0]);
      int target = Integer.parseInt(sizes[1]);
      int[] wallet = new int[size];
      for (int i = size - 1; i >= 0; i--) {
        int value = Integer.parseInt(br.readLine());
        wallet[i] = value;
      }
      int result = solution(wallet, target);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
