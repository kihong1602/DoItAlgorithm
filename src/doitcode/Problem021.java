package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem021 {

  // 백준 1517 플래티넘 버블소트 2
  // 병합정렬 시 swap이 일어나는 것으로 간주해, index가 이동한 거리를 계산

  private static int[] array, temp;
  private static long result;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      array = new int[size + 1];
      temp = new int[size + 1];
      String[] input = br.readLine()
          .split(" ");
      for (int i = 1; i <= size; i++) {
        array[i] = Integer.parseInt(input[i - 1]);
      }
      mergeSort(1, size);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void mergeSort(int start, int end) {
    if (end - start < 1) {
      return;
    }
    int mid = start + (end - start) / 2;
    mergeSort(start, mid);
    mergeSort(mid + 1, end);

    for (int i = start; i <= end; i++) {
      temp[i] = array[i];
    }
    int k = start;
    int index1 = start;
    int index2 = mid + 1;

    while (index1 <= mid && index2 <= end) {
      if (temp[index1] > temp[index2]) {
        array[k] = temp[index2];
        result = result + index2 - k;
        k++;
        index2++;
      } else {
        array[k] = temp[index1];
        k++;
        index1++;
      }
    }

    while (index1 <= mid) {
      array[k] = temp[index1];
      k++;
      index1++;
    }
    while (index2 <= end) {
      array[k] = temp[index2];
      k++;
      index2++;
    }
  }
}
