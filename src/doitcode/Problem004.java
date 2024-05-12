package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem004 {

  //백준 11660 실버1 구간합 구하기2
  // N*N 보드에 숫자가 채워져있음.
  // X1,Y1 에서 X2,Y2까지의 합을 구하려고한다.

  private static int[][] solution(int[][] map) {
    int size = map.length;
    int[][] sectionSum = new int[size][size];

    for (int i = 1; i < size; i++) {
      for (int j = 1; j < size; j++) {
        // 2차원배열 누적합 공식
        // sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + board[i][j]
        sectionSum[i][j] = sectionSum[i][j - 1] + sectionSum[i - 1][j] - sectionSum[i - 1][j - 1] + map[i][j];
      }
    }

    return sectionSum;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int mapSize = Integer.parseInt(size[0]);
      int querySize = Integer.parseInt(size[1]);

      int[][] map = new int[mapSize + 1][mapSize + 1];
      for (int i = 1; i <= mapSize; i++) {
        String[] inputs = br.readLine().split(" ");
        for (int j = 1; j <= mapSize; j++) {
          map[i][j] = Integer.parseInt(inputs[j - 1]);
        }
      }

      int[][] sections = solution(map);

      while (querySize-- > 0) {
        String[] query = br.readLine().split(" ");
        Point start = new Point(query[0], query[1]);
        Point end = new Point(query[2], query[3]);
        // 두 좌표가 주어진 구간합 공식
        // sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1]
        int result =
            sections[end.x][end.y] - sections[start.x - 1][end.y]
                - sections[end.x][start.y - 1] + sections[start.x - 1][start.y - 1];
        bw.write(result + "\n");
      }
      bw.flush();

    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  static class Point {

    int x;
    int y;

    Point(String x, String y) {
      this.x = Integer.parseInt(x);
      this.y = Integer.parseInt(y);
    }
  }


}
