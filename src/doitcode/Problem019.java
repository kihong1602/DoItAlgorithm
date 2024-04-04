package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem019 {

  // 백준 11004 실버5 K번째 수
  // 퀵정렬
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine()
          .split(" ");
      int k = Integer.parseInt(size[1]);
      int[] array = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      solution(array, 0, array.length - 1, k - 1);
      bw.write(String.valueOf(array[k - 1]));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void solution(int[] array, int start, int end, int k) {
    if (start < end) {
      int pivot = partition(array, start, end);
      if (pivot == k) {
        return;
      } else if (k < pivot) {
        solution(array, start, pivot - 1, k);
      } else {
        solution(array, pivot + 1, end, k);
      }
    }
  }

  private static int partition(int[] array, int start, int end) {
    if (start + 1 == end) {
      if (array[start] > array[end]) {
        swap(array, start, end);
      }
      return end;
    }
    int mid = (start + end) / 2;
    swap(array, start, mid);
    int pivot = array[start];
    int i = start + 1, j = end;
    while (i <= j) {
      while (j >= start + 1 && pivot < array[j]) {
        j--;
      }
      while (i <= end && pivot > array[i]) {
        i++;
      }
      if (i <= j) {
        swap(array, i++, j--);
      }
    }
    array[start] = array[j];
    array[j] = pivot;
    return j;
  }

  private static void swap(int[] array, int start, int end) {
    int tmp = array[start];
    array[start] = array[end];
    array[end] = tmp;
  }
}
