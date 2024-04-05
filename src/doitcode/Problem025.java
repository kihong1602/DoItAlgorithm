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
  // A-B, B-C, C-D, D-E인 경우가 존재하는지 구하는 프로그램 작성
  private static ArrayList<Integer>[] graph;
  private static boolean[] visited;
  private static boolean arrive = false;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine()
          .split(" ");
      int node = Integer.parseInt(size[0]);
      int line = Integer.parseInt(size[1]);

      graph = new ArrayList[node];
      visited = new boolean[node];

      for (int i = 0; i < node; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < line; i++) {
        String[] input = br.readLine()
            .split(" ");
        int u = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[1]);
        graph[u].add(v);
        graph[v].add(u);
      }
      for (int i = 0; i < node; i++) {
        dfs(i, 1);
        if (arrive) {
          break;
        }
      }
      bw.write(arrive ? "1" : "0");
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void dfs(int now, int depth) {
    if (depth == 5 || arrive) {
      arrive = true;
      return;
    }
    visited[now] = true;
    for (int next : graph[now]) {
      if (!visited[next]) {
        dfs(next, depth + 1);
      }
    }
    visited[now] = false;
  }
}
