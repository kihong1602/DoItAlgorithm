package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem030 {

  // 백준 2343 기타레슨
  // 이분탐색
  private static int solution(int[] array, int bluRay) {
    int start = 0;
    int end = 0;
    for (int token : array) {
      start = Math.max(start, token);
      end += token;
    }
    while (start <= end) {
      int mid = (start + end) / 2;
      int sum = 0;
      int counts = 0;
      for (int token : array) {
        if (sum + token > mid) {
          counts++;
          sum = 0;
        }
        sum += token;
      }
      if (sum != 0) {
        counts++;
      }
      if (counts > bluRay) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return start;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int size = Integer.parseInt(sizes[0]);
      int bluRay = Integer.parseInt(sizes[1]);
      int[] array = new int[size];
      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      int result = solution(array, bluRay);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
