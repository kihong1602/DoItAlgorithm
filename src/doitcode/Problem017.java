package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem017 {

  // 백준 1427 실버5 내림차순으로 자릿수 정렬하기
  // 선택정렬로 풀이
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] numbers = br.readLine()
          .split("");
      int[] array = new int[numbers.length];
      for (int i = 0; i < array.length; i++) {
        array[i] = Integer.parseInt(numbers[i]);
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
    for (int i = 0; i < array.length; i++) {
      int max = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] > array[max]) {
          max = j;
        }
      }
      if (array[i] < array[max]) {
        int tmp = array[i];
        array[i] = array[max];
        array[max] = tmp;
      }
    }
    Arrays.stream(array)
        .forEach(sb::append);
    return sb.toString();
  }
}