package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem029 {

  // 백준 1920 원하는 정수 찾기
  // 이진탐색
  private static String solution(int[] array, int target) {
    boolean isFind = false;

    int start = 0;
    int end = array.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      int find = array[mid];
      if (find == target) {
        isFind = true;
        break;
      } else if (find > target) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return isFind ? "1" : "0";
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

      size = Integer.parseInt(br.readLine());
      inputs = br.readLine().split(" ");

      Arrays.sort(array);
      for (String input : inputs) {
        int target = Integer.parseInt(input);
        String result = solution(array, target);
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
