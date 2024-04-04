package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem015 {

  // 백준 2750 브론즈1 수 정렬하기1
  // 버블정렬을 이용해 풀이
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int numberSize = Integer.parseInt(br.readLine());
      int[] array = new int[numberSize];
      for (int i = 0; i < numberSize; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String solution(int[] array) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          swap(j, j + 1, array);
        }
      }
    }

    Arrays.stream(array)
        .forEach(token -> sb.append(token)
            .append("\n"));
    return sb.toString();
  }

  private static void swap(int index1, int index2, int[] array) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }
}
