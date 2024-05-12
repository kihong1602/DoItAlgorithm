package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem005 {

  //백준 10986 골드3 나머지 합 구하기
  // 구간합이 M으로 나눠지는 (i,j)의 개수를 반환하시오.
  private static long solution(int[] array, int target) {
    int size = array.length;
    long result = 0;

    long[] sums = new long[size + 1];
    for (int i = 1; i <= size; i++) {
      sums[i] = sums[i - 1] + array[i - 1];
    }

    long[] remains = new long[target];
    for (int i = 1; i <= size; i++) {
      int remain = (int) (sums[i] % target);
      if (remain == 0) {
        result++;
      }
      remains[remain]++;
    }

    for (long remain : remains) {
      if (remain > 1) {
        result += remain * (remain - 1) / 2;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int arraySize = Integer.parseInt(size[0]);
      int target = Integer.parseInt(size[1]);
      String[] inputs = br.readLine().split(" ");

      int[] array = new int[arraySize];

      for (int i = 0; i < arraySize; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      long result = solution(array, target);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}