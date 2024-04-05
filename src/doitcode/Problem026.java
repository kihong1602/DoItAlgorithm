package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem026 {

  // 백준 1260 실버2 DFS와 BFS
  // DFS와 BFS로 탐색한 결과를 출력하는 프로그램
  private static List<Integer>[] graph;
  private static boolean[] visited;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine()
          .split(" ");
      int node = Integer.parseInt(size[0]);
      int line = Integer.parseInt(size[1]);
      int startPoint = Integer.parseInt(size[2]);
      graph = new ArrayList[node + 1];
      visited = new boolean[node + 1];
      for (int i = 1; i <= node; i++) {
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

      for (int i = 1; i <= node; i++) {
        graph[i].sort(Comparator.naturalOrder());
      }

      dfs(startPoint);
      visited = new boolean[node + 1];
      sb.append("\n");
      bfs(startPoint);
      bw.write(sb.toString());
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void dfs(int now) {
    visited[now] = true;
    sb.append(now)
        .append(" ");
    for (int next : graph[now]) {
      if (!visited[next]) {
        dfs(next);
      }
    }
  }

  private static void bfs(int now) {
    Queue<Integer> queue = new LinkedList<>();
    visited[now] = true;
    queue.add(now);
    while (!queue.isEmpty()) {
      Integer nowNode = queue.poll();
      sb.append(nowNode)
          .append(" ");
      for (int next : graph[nowNode]) {
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
        }
      }
    }
  }
}
