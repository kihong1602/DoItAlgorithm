package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem028 {

  // 백준 골드2 1167 트리의 지름 구하기
  // bfs
  // 임의의 노드에서 가장 먼 노드를 찾고,
  // 그 노드에서 가장 먼 노드까지의 거리가 트리의 지름이 된다
  private static boolean[] visited;
  private static int[] distance;
  private static ArrayList<Edge>[] graph;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      graph = new ArrayList[size + 1];
      for (int i = 1; i <= size; i++) {
        graph[i] = new ArrayList<>();
      }
      for (int i = 0; i < size; i++) {
        String[] input = br.readLine()
            .split(" ");
        int startPoint = Integer.parseInt(input[0]);
        int index = 1;
        while (index < input.length) {
          int e = Integer.parseInt(input[index++]);
          if (e == -1) {
            break;
          }
          int value = Integer.parseInt(input[index++]);
          graph[startPoint].add(new Edge(e, value));
        }
      }
      distance = new int[size + 1];
      visited = new boolean[size + 1];
      bfs(1);
      int max = 1;
      for (int i = 2; i <= size; i++) {
        if (distance[max] < distance[i]) {
          max = i;
        }
      }
      distance = new int[size + 1];
      visited = new boolean[size + 1];
      bfs(max);
      Arrays.sort(distance);
      bw.write(String.valueOf(distance[size]));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void bfs(int index) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(index);
    visited[index] = true;
    while (!queue.isEmpty()) {
      int now = queue.poll();
      for (Edge edge : graph[now]) {
        int e = edge.e;
        if (!visited[e]) {
          visited[e] = true;
          queue.offer(e);
          distance[e] = distance[now] + edge.value;
        }
      }
    }
  }

  private static class Edge {

    int e;
    int value;

    Edge(int e, int value) {
      this.e = e;
      this.value = value;
    }
  }
}
