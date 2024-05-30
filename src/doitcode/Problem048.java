package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem048 {

  // 백준 1707 이분그래프
  private static List<Integer>[] graph;
  private static boolean[] visited;
  private static int[] check;
  private static boolean flag;

  private static String solution() {
    for (int i = 1; i < graph.length; i++) {
      if (flag) {
        dfs(i);
      } else {
        break;
      }
    }
    return flag ? "YES" : "NO";
  }

  private static void dfs(int start) {
    visited[start] = true;
    for (int next : graph[start]) {
      if (!visited[next]) {
        check[next] = (check[start] + 1) % 2;
        dfs(next);
      } else if (check[start] == check[next]) {
        flag = false;
      }
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int count = Integer.parseInt(br.readLine());
      while (count-- > 0) {
        String[] size = br.readLine().split(" ");
        int node = Integer.parseInt(size[0]);
        int edge = Integer.parseInt(size[1]);
        graph = new ArrayList[node + 1];
        visited = new boolean[node + 1];
        check = new int[node + 1];
        for (int i = 1; i <= node; i++) {
          graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
          String[] inputs = br.readLine().split(" ");
          int u = Integer.parseInt(inputs[0]);
          int v = Integer.parseInt(inputs[1]);
          graph[u].add(v);
          graph[v].add(u);
        }

        flag = true;
        String result = solution();
        bw.write(result + "\n");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
