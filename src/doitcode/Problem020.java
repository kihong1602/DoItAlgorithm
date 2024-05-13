package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem020 {

  // 백준 2751 실버5 수 정렬하기 2
  // 병합정렬
  private static int[] array;
  private static int[] tmp;

  private static void solution(int start, int end) {
    if (end - start < 1) {
      return;
    }
    int mid = start + (end - start) / 2;
    solution(start, mid);
    solution(mid + 1, end);
    for (int i = start; i <= end; i++) {
      tmp[i] = array[i];
    }
    int k = start;
    int index1 = start;
    int index2 = mid + 1;
    while (index1 <= mid && index2 <= end) {
      if (tmp[index1] > tmp[index2]) {
        array[k] = tmp[index2];
        k++;
        index2++;
      } else {
        array[k] = tmp[index1];
        k++;
        index1++;
      }
    }

    while (index1 <= mid) {
      array[k] = tmp[index1];
      k++;
      index1++;
    }
    while (index2 <= end) {
      array[k] = tmp[index2];
      k++;
      index2++;
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      array = new int[size + 1];
      tmp = new int[size + 1];
      for (int i = 1; i <= size; i++) {
        array[i] = Integer.parseInt(br.readLine());
      }
      solution(1, size);
      for (int i = 1; i <= size; i++) {
        bw.write(array[i] + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}