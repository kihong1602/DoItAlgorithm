package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem004 {

  //백준 11660 실버1 구간합 구하기2
  // N*N 보드에 숫자가 채워져있음.
  // X1,Y1 에서 X2,Y2까지의 합을 구하려고한다.

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int[] sizes = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
      int boardSize = sizes[0];
      int questionSize = sizes[1];
      int[][] board = new int[boardSize + 1][boardSize + 1];
      for (int i = 1; i <= boardSize; i++) {
        int[] inputs = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        for (int j = 1; j <= boardSize; j++) {
          board[i][j] = inputs[j - 1];
        }
      }

      // 2차원배열 구간합 공식
      // sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + board[i][j]
      int[][] sum = new int[boardSize + 1][boardSize + 1];
      for (int i = 1; i <= boardSize; i++) {
        for (int j = 1; j <= boardSize; j++) {
          sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + board[i][j];
        }
      }

      StringBuilder sb = new StringBuilder();
      while (questionSize-- > 0) {
        int[] indexes = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int x1 = indexes[0], y1 = indexes[1], x2 = indexes[2], y2 = indexes[3];
        // 두 좌표가 주어진 구간합 공식
        // sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]
        int result = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
        sb.append(result)
            .append("\n");
      }
      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
