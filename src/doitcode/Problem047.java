package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem047 {
  // 백준 1325 효율적인 해킹

  private static List<Integer>[] graph;
  private static boolean[] visited;
  private static int[] distance;

  private static String solution() {
    for (int i = 1; i < graph.length; i++) {
      visited = new boolean[graph.length];
      bfs(i);
    }
    int max = 0;
    for (int i = 1; i < distance.length; i++) {
      max = Math.max(max, distance[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < distance.length; i++) {
      if (distance[i] == max) {
        sb.append(i).append(" ");
      }
    }
    return sb.toString();
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int next : graph[now]) {
        if (!visited[next]) {
          visited[next] = true;
          distance[next]++;
          queue.add(next);
        }
      }
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int node = Integer.parseInt(size[0]);
      int edge = Integer.parseInt(size[1]);
      graph = new ArrayList[node + 1];
      distance = new int[node + 1];
      for (int i = 1; i <= node; i++) {
        graph[i] = new ArrayList<>();
      }

      for (int i = 0; i < edge; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph[u].add(v);
      }

      String result = solution();
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
