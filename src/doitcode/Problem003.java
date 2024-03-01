package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem003 {

  // 백준 11659 실버3 구간합 구하기
  // 1번째 줄에 수의 개수 N, 합을 구해야하는 횟수 M 이 주어짐.
  // 2번째 줄에 N개의 수가 주어짐. 3번째 줄에는 합을 구해야하는 구간 i와 j가 주어짐

  private static int[] getSectionSumArray(int[] array) {
    int[] sectionSumArray = new int[array.length + 1];
    for (int i = 1; i <= array.length; i++) {
      sectionSumArray[i] = sectionSumArray[i - 1] + array[i - 1];
    }
    return sectionSumArray;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] values = br.readLine()
          .split(" ");
      int size = Integer.parseInt(values[0]);
      int questionSize = Integer.parseInt(values[1]);

      int[] array = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      int[] sectionSumArray = getSectionSumArray(array);

      StringBuilder sb = new StringBuilder();
      while (questionSize-- > 0) {
        int[] inputs = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        sb.append(sectionSumArray[inputs[1]] - sectionSumArray[inputs[0] - 1])
            .append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}
