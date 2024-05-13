package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem018 {

  // 백준 11399 실버3 ATM 인출시간 계산하기
  private static int solution(int[] array) {
    int[] sums = new int[array.length + 1];

    for (int i = 1; i < array.length; i++) {
      int insertPoint = i;
      int insertValue = array[i];
      for (int j = i - 1; j >= 0; j--) {
        if (array[j] < array[i]) {
          insertPoint = j + 1;
          break;
        }
        if (j == 0) {
          insertPoint = 0;
        }
      }
      for (int j = i; j > insertPoint; j--) {
        array[j] = array[j - 1];
      }
      array[insertPoint] = insertValue;
    }

    for (int i = 1; i <= array.length; i++) {
      sums[i] = sums[i - 1] + array[i - 1];
    }

    return Arrays.stream(sums).sum();
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] array = new int[size];
      String[] inputs = br.readLine().split(" ");
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
