package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Problem016 {

  // 백준 1377 버블소트 골드2
  // 정렬이 발생하지 않은 횟수를 구하라
  private static int solution(Data[] array) {
    Arrays.sort(array, Comparator.comparingInt(o -> o.value));
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      int indexDiff = array[i].index - i;
      max = Math.max(max, indexDiff);
    }
    return max + 1;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      Data[] array = new Data[size];
      for (int i = 0; i < size; i++) {
        array[i] = new Data(i, br.readLine());
      }
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  static class Data {

    int index;
    int value;

    Data(int index, String value) {
      this.index = index;
      this.value = Integer.parseInt(value);
    }

  }
}
