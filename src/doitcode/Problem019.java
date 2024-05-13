package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem019 {
  // 백준 11004 실버5 K번째 수
  // 퀵정렬

  private static void solution(int[] array, int start, int end, int K) {
    if (start < end) {
      int pivot = partition(array, start, end);
      if (pivot == K) {
        return;
      }
      if (K < pivot) {
        solution(array, start, pivot - 1, K);
      }
      if (K > pivot) {
        solution(array, pivot + 1, end, K);
      }
    }
  }

  private static int partition(int[] array, int start, int end) {
    if (start + 1 == end) {
      if (array[start] > array[end]) {
        swap(array, start, end);
        return end;
      }
    }
    int mid = (start + end) / 2;
    swap(array, start, mid);
    int pivot = array[start];
    int i = start + 1;
    int j = end;
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

  private static void swap(int[] array, int index1, int index2) {
    int tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int size = Integer.parseInt(sizes[0]);
      int K = Integer.parseInt(sizes[1]) - 1;
      String[] inputs = br.readLine().split(" ");
      int[] array = new int[size];
      for (int i = 0; i < size; i++) {
        array[i] = Integer.parseInt(inputs[i]);
      }
      solution(array, 0, size - 1, K);
      bw.write(String.valueOf(array[K]));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
