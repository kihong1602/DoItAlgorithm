package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem007 {

  // 백준 실버4 1940 주몽의 명령
  // 재료의 개수와 갑옷이 완성되는 값이 주어짐
  // 재료가 주어졌을때, 몇개의 갑옷을 만들 수 있는가?

  private static int solution(int[] array, int required) {
    int result = 0;
    int start = 0;
    int end = array.length - 1;
    while (start < end) {
      int sum = array[start] + array[end];
      if (sum == required) {
        result++;
        start++;
        end--;
      }
      if (sum < required) {
        start++;
      }
      if (sum > required) {
        end--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int quantity = Integer.parseInt(br.readLine());
      int required = Integer.parseInt(br.readLine());
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[quantity];
      for (int i = 0; i < quantity; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      Arrays.sort(array);
      int result = solution(array, required);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
