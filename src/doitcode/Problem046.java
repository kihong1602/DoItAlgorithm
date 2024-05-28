package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem046 {
  // 백준 18352 특정 거리의 도시 찾기

  private static List<Integer>[] graph;
  private static int[] visited;

  private static String solution(int k, int start) {
    List<Integer> list = new ArrayList<>();

    bfs(start);

    for (int i = 1; i < visited.length; i++) {
      if (visited[i] == k) {
        list.add(i);
      }
    }

    if (list.isEmpty()) {
      return "-1";
    }

    list.sort(Comparator.naturalOrder());
    StringBuilder sb = new StringBuilder();
    for (int num : list) {
      sb.append(num).append("\n");
    }

    return sb.toString();
  }

  private static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    visited[start]++;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (int next : graph[now]) {
        if (visited[next] == -1) {
          visited[next] = visited[now] + 1;
          queue.add(next);
        }
      }
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] size = br.readLine().split(" ");
      int city = Integer.parseInt(size[0]);
      int load = Integer.parseInt(size[1]);
      int k = Integer.parseInt(size[2]);
      int start = Integer.parseInt(size[3]);

      graph = new ArrayList[city + 1];
      for (int i = 1; i <= city; i++) {
        graph[i] = new ArrayList<>();
      }

      visited = new int[city + 1];
      Arrays.fill(visited, -1);

      for (int i = 0; i < load; i++) {
        String[] inputs = br.readLine().split(" ");
        int u = Integer.parseInt(inputs[0]);
        int v = Integer.parseInt(inputs[1]);
        graph[u].add(v);
      }

      String result = solution(k, start);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
