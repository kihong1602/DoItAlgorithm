package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem027 {

  // 백준 2178 실버1 미로탐색하기
  // bfs 미로탐색 문제
  private static int[][] map;
  private static boolean[][] visited;
  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static int width, height;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine()
          .split(" ");
      height = Integer.parseInt(size[0]);
      width = Integer.parseInt(size[1]);
      map = new int[height][width];
      visited = new boolean[height][width];

      for (int i = 0; i < height; i++) {
        String[] input = br.readLine()
            .split("");
        for (int j = 0; j < width; j++) {
          map[i][j] = Integer.parseInt(input[j]);
        }
      }
      bfs(0, 0);
      int result = map[height - 1][width - 1];
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void bfs(int x, int y) {
    visited[y][x] = true;
    Queue<Point> queue = new LinkedList<>();
    queue.offer(new Point(x, y));

    while (!queue.isEmpty()) {
      Point now = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nextX = now.x + dx[i];
        int nextY = now.y + dy[i];
        if (nextX >= 0 && nextY >= 0 && nextX < width && nextY < height) {
          if (map[nextY][nextX] != 0 && !visited[nextY][nextX]) {
            visited[nextY][nextX] = true;
            map[nextY][nextX] = map[now.y][now.x] + 1;
            queue.offer(new Point(nextX, nextY));
          }
        }
      }
    }
  }

  private static class Point {

    int x;
    int y;

    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
