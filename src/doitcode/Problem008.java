package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem008 {

  // 백준 골드4 1253 좋은 수 구하기
  // 주어진 N개의 수 중 다른 두 수의 합으로 표현되는 수를 좋은 수 라고함.
  // N개의 수 중 좋은 수가 몇개인지 ?
  private static int solution(int[] array) {
    int result = 0;
    int len = array.length;

    for (int i = 0; i < len; i++) {
      int target = array[i];
      int start = 0;
      int end = len - 1;
      while (start < end) {

        if (start == i) {
          start++;
          continue;
        }

        if (end == i) {
          end--;
          continue;
        }

        int sum = array[start] + array[end];
        if (sum == target) {
          result++;
          break;
        } else if (sum < target) {
          start++;
        } else {
          end--;
        }

      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      Arrays.sort(array);
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
