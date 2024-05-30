package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Problem049 {
  // 백준 2251 물통

  private static final int[] sender = {0, 0, 1, 1, 2, 2}; // 물을 옮기는 물통의 인덱스
  private static final int[] receiver = {1, 2, 0, 2, 0, 1}; // 물을 받는 물통의 인덱스
  private static boolean[][] visited;
  private static boolean[] answer;
  private static int[] now;

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      now = new int[3];
      now[0] = Integer.parseInt(inputs[0]);
      now[1] = Integer.parseInt(inputs[1]);
      now[2] = Integer.parseInt(inputs[2]);

      visited = new boolean[201][201];
      answer = new boolean[201];
      bfs();
      for (int i = 0; i < answer.length; i++) {
        if (answer[i]) {
          bw.write(i + " ");
        }
      }
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  private static void bfs() {
    Queue<State> queue = new LinkedList<>();
    queue.add(new State(0, 0));
    visited[0][0] = true;
    answer[now[2]] = true;

    while (!queue.isEmpty()) {
      State current = queue.poll();
      int A = current.A;
      int B = current.B;
      int C = now[2] - A - B;
      for (int i = 0; i < 6; i++) {
        int[] next = {A, B, C};
        int send = sender[i];
        int receive = receiver[i];
        next[receive] += next[send];  // sender 의 물을 receiver 로 옮김
        next[send] = 0; // sender의 물은 모두 옮겼으므로 0 처리
        if (next[receive] > now[receive]) { // 만약 받은 물이 용량을 초과했다면
          next[send] = next[receive] - now[receive];  // sender 에게 초과한 만큼 돌려줌
          next[receive] = now[receive]; // 돌려줬으니, receiver는 최대 용량으로 재설정함
        }
        if (!visited[next[0]][next[1]]) {
          visited[next[0]][next[1]] = true;
          queue.add(new State(next[0], next[1]));
          if (next[0] == 0) {
            answer[next[2]] = true;
          }
        }
      }
    }
  }

  static class State {

    int A;
    int B;

    State(int A, int B) {
      this.A = A;
      this.B = B;
    }
  }

}
