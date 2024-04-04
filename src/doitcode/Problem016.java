package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem016 {

  // 백준 1377 버블소트 골드2
  // 정렬이 발생하지 않은 횟수를 구하라
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int arraySize = Integer.parseInt(br.readLine());
      MetaData[] array = new MetaData[arraySize];
      for (int i = 0; i < arraySize; i++) {
        array[i] = new MetaData(i, Integer.parseInt(br.readLine()));
      }
      int result = solution(array);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static int solution(MetaData[] array) {
    Arrays.sort(array);
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (max < array[i].index - i) {
        max = array[i].index - i;
      }
    }
    return max + 1;
  }

  private static class MetaData implements Comparable<MetaData> {

    int index;
    int value;

    public MetaData(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(MetaData o) {
      return this.value - o.value;
    }
  }
}
