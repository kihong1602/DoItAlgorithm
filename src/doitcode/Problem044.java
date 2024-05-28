package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Problem044 {
  // 백준 1033 칵테일

  private static List<Ratio>[] graph;
  private static long[] mass;
  private static boolean[] visited;

  private static void dfs(int node) {
    visited[node] = true;
    for (Ratio ratio : graph[node]) {
      int next = ratio.to;
      if (!visited[next]) {
        mass[next] = mass[node] * ratio.q / ratio.p;
        dfs(next);
      }
    }
  }

  private static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      graph = new ArrayList[size];
      mass = new long[size];
      visited = new boolean[size];
      for (int i = 0; i < size; i++) {
        graph[i] = new ArrayList<>();
      }

      long lcm = 1;
      for (int i = 0; i < size - 1; i++) {
        String[] inputs = br.readLine().split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        int p = Integer.parseInt(inputs[2]);
        int q = Integer.parseInt(inputs[3]);
        graph[a].add(new Ratio(b, p, q));
        graph[b].add(new Ratio(a, q, p));
        lcm = lcm * ((long) p * q / gcd(p, q));
      }

      mass[0] = lcm;
      dfs(0);

      long mgcd = mass[0];
      for (int i = 1; i < size; i++) {
        mgcd = gcd(mgcd, mass[i]);
      }

      for (int i = 0; i < size; i++) {
        bw.write(mass[i] / mgcd + " ");
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  static class Ratio {

    int to;
    int p;
    int q;

    Ratio(int to, int p, int q) {
      this.to = to;
      this.p = p;
      this.q = q;
    }
  }

}
