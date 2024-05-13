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

  private static void dfs(int v) {
    if (visited[v]) {
      return;
    }
    visited[v] = true;
    for (int i = 0; i < graph[v].length; i++) {
      if (graph[v][i] == 1 && !visited[i]) {
        dfs(i);
      }
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int node = Integer.parseInt(sizes[0]);
      int edge = Integer.parseInt(sizes[1]);
      graph = new int[node + 1][node + 1];
      visited = new boolean[node + 1];
      for (int i = 0; i < edge; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph[u][v] = graph[v][u] = 1;
      }

      int result = 0;
      for (int i = 1; i <= node; i++) {
        if (!visited[i]) {
          result++;
          dfs(i);
        }
      }
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}