package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem023 {

  // 백준 11724 실버2 연결요소의 개수
  // DFS
  private static int[][] graph;
  private static boolean[] visited;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine()
          .split(" ");
      int node = Integer.parseInt(size[0]);
      int line = Integer.parseInt(size[1]);
      graph = new int[node + 1][node + 1];
      visited = new boolean[node + 1];

      for (int i = 0; i < line; i++) {
        String[] nodes = br.readLine()
            .split(" ");
        int u = Integer.parseInt(nodes[0]);
        int v = Integer.parseInt(nodes[1]);
        graph[u][v] = graph[v][u] = 1;
      }

      int count = 0;
      for (int i = 1; i < node + 1; i++) {
        if (!visited[i]) {
          count++;
          dfs(i);
        }
      }

      bw.write(String.valueOf(count));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void dfs(int value) {
    visited[value] = true;
    for (int i = 0; i < graph[value].length; i++) {
      if (graph[value][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

}