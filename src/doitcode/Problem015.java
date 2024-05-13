package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem015 {

  // 백준 2750 브론즈1 수 정렬하기1
  // 버블정렬을 이용해 풀이

  private static String solution(int[] array) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < array.length - 1; i++) {
      for (int j = 0; j < array.length - i - 1; j++) {
        int value = array[j];
        int target = array[j + 1];
        if (value > target) {
          swap(array, j, j + 1);
        }
      }
    }

    for (int token : array) {
      sb.append(token).append("\n");
    }
    return sb.toString();
  }

  private static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }
      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
