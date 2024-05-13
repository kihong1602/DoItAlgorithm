package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Problem025 {

  // 백준 13023 골드5 ABCDE
  // DFS
  private static ArrayList<Integer>[] graph;
  private static boolean[] visited;
  private static boolean arrive;

  private static void dfs(int v, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }
    visited[v] = true;
    for (int next : graph[v]) {
      if (!visited[next]) {
        dfs(next, depth + 1);
      }
    }
    visited[v] = false;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int node = Integer.parseInt(sizes[0]);
      int edge = Integer.parseInt(sizes[1]);
      graph = new ArrayList[node];
      visited = new boolean[node];

      for (int i = 0; i < node; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < edge; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph[u].add(v);
        graph[v].add(u);
      }
      for (int i = 0; i < node; i++) {
        dfs(i, 1);
        if (arrive) {
          break;
        }
      }
      String result = arrive ? "1" : "0";
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }
}
