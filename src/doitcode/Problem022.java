package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem022 {

  // 백준 10989 실버5 수 정렬하기 3
  // 카운팅 정렬
  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      int[] count = new int[10001];
      for (int i = 0; i < size; i++) {
        count[Integer.parseInt(br.readLine())]++;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < 10001; i++) {
        while (count[i] > 0) {
          sb.append(i)
              .append("\n");
          count[i]--;
        }
      }
      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
