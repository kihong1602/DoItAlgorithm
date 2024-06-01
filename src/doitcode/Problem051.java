package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem051 {
  // 백준 1976 여행가자

  private static String solution(int[][] cities, int[] route) {
    int len = cities.length;
    int[] graph = new int[len];
    for (int i = 1; i < len; i++) {
      graph[i] = i;
    }
    for (int i = 1; i < cities.length; i++) {
      for (int j = 1; j < cities.length; j++) {
        if (cities[i][j] == 1) {
          union(graph, i, j);
        }
      }
    }

    int index = find(graph, route[1]);
    for (int i = 2; i < route.length; i++) {
      if (index != find(graph, route[i])) {
        return "NO";
      }
    }
    return "YES";
  }

  private static void union(int[] graph, int a, int b) {
    a = find(graph, a);
    b = find(graph, b);
    if (a != b) {
      graph[b] = a;
    }
  }

  private static int find(int[] graph, int a) {
    if (a == graph[a]) {
      return a;
    }
    return graph[a] = find(graph, graph[a]);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int city = Integer.parseInt(br.readLine());
      int planCity = Integer.parseInt(br.readLine());
      int[][] cities = new int[city + 1][city + 1];
      for (int i = 1; i <= city; i++) {
        String[] inputs = br.readLine().split(" ");
        for (int j = 0; j < city; j++) {
          cities[i][j + 1] = Integer.parseInt(inputs[j]);
        }
      }

      int[] route = new int[planCity + 1];
      String[] routes = br.readLine().split(" ");
      for (int i = 1; i <= planCity; i++) {
        route[i] = Integer.parseInt(routes[i - 1]);
      }
      String result = solution(cities, route);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
