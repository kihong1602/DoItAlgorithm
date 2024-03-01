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
      int[][] board = new int[boardSize][boardSize];
      for (int i = 0; i < boardSize; i++) {
        int[] inputs = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        for (int j = 0; j < boardSize; j++) {
          board[i][j] = inputs[j];
        }
      }

      //여기서 구간합 구하기 -> 아침에

      while (questionSize-- > 0) {
        int[] indexes = Arrays.stream(br.readLine()
                .split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
        int x1 = indexes[0], y1 = indexes[1], x2 = indexes[2], y2 = indexes[3];

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
