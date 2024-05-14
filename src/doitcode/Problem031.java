package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem031 {
  // 백준 1300 K번째 수

  private static int solution(int size, int K) {
    int result = 0;

    int start = 1;
    int end = K;

    while (start <= end) {
      int mid = (start + end) / 2;
      int count = 0;

      for (int i = 1; i <= size; i++) {
        count += Math.min(mid / i, size);
      }

      if (count < K) {
        start = mid + 1;
      } else {
        result = mid;
        end = mid - 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int K = Integer.parseInt(br.readLine());

      int result = solution(size, K);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
