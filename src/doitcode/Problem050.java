package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem050 {

  private static String solution(int size, String[] queries) {
    StringBuilder sb = new StringBuilder();
    int[] graph = new int[size + 1];
    for (int i = 0; i <= size; i++) {
      graph[i] = i;
    }
    for (String query : queries) {
      String[] inputs = query.split(" ");
      int a = Integer.parseInt(inputs[1]);
      int b = Integer.parseInt(inputs[2]);
      switch (inputs[0]) {
        case "0":
          union(graph, a, b);
          break;
        case "1":
          sb.append(isSame(graph, a, b) ? "YES" : "NO").append("\n");
          break;
        default:
          throw new IllegalArgumentException();
      }
    }

    return sb.toString();
  }

  private static void union(int[] graph, int a, int b) {
    a = find(graph, a);
    b = find(graph, b);
    if (a != b) {
      graph[b] = a;
    }
  }

  private static int find(int[] graph, int a) {
    if (graph[a] == a) {
      return a;
    }
    return graph[a] = find(graph, graph[a]);
  }

  private static boolean isSame(int[] graph, int a, int b) {
    a = find(graph, a);
    b = find(graph, b);
    return a == b;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int size = Integer.parseInt(sizes[0]);
      int count = Integer.parseInt(sizes[1]);
      String[] queries = new String[count];
      for (int i = 0; i < count; i++) {
        queries[i] = br.readLine();
      }
      String result = solution(size, queries);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
