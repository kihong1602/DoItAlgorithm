package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem005 {

  //백준 10986 골드3 나머지 합 구하기
  // 구간합이 M으로 나눠지는 (i,j)의 개수를 반환하시오.
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int[] sizes = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      int arraySize = sizes[0];
      int num = sizes[1];
      int[] inputs = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      int[] sum = new int[arraySize + 1];
      for (int i = 1; i < arraySize; i++) {
        sum[i] = sum[i - 1] + inputs[i - 1];
      }
      int result = 0;
      int[] remains = new int[num];
      for (int i = 0; i < arraySize; i++) {
        int remain = (sum[i] % num);
        if (remain == 0) {
          result++;
        }
        remains[remain]++;
      }

      for (int i = 0; i < num; i++) {
        if (remains[i] > 1) {
          result = result + (remains[i] * (remains[i] - 1) / 2);
        }
      }
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}