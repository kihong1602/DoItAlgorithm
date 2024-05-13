package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem017 {

  // 백준 1427 실버5 내림차순으로 자릿수 정렬하기
  // 선택정렬로 풀이
  private static String solution(int[] array) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
      int max = i;
      for (int j = i + 1; j < array.length; j++) {
        if (array[max] < array[j]) {
          max = j;
        }
      }
      if (array[i] < array[max]) {
        swap(array, i, max);
      }
    }
    for (int token : array) {
      sb.append(token);
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
      String[] inputs = br.readLine().split("");
      int[] array = new int[inputs.length];
      for (int i = 0; i < inputs.length; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      String result = solution(array);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}