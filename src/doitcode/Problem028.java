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
  private static ArrayList<Node>[] graph;
  private static boolean[] visited;
  private static int[] distance;

  private static void createGraph(String[] input) {
    int index = 0;
    int node = Integer.parseInt(input[index++]);
    graph[node] = new ArrayList<>();
    while (index < input.length) {
      int targetNode = Integer.parseInt(input[index++]);
      if (targetNode == -1) {
        break;
      }
      int distance = Integer.parseInt(input[index++]);
      graph[node].add(new Node(targetNode, distance));
    }
  }

  private static void solution(int size) {
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
  }

  private static void bfs(int index) {
    Queue<Integer> queue = new LinkedList<>();
    visited[index] = true;
    queue.add(index);

    while (!queue.isEmpty()) {
      Integer now = queue.poll();
      for (Node node : graph[now]) {
        int next = node.node;
        if (!visited[next]) {
          visited[next] = true;
          queue.add(next);
          distance[next] = distance[now] + node.distance;
        }
      }
    }
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      graph = new ArrayList[size + 1];
      for (int i = 0; i < size; i++) {
        String[] input = br.readLine().split(" ");
        createGraph(input);
      }

      solution(size);

      bw.write(String.valueOf(distance[size]));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }


  static class Node {

    int node;
    int distance;

    Node(int node, int distance) {
      this.node = node;
      this.distance = distance;
    }
  }
}
