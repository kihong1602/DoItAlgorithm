package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem035 {
  // 백준 1931 회의실 배정하기
  // 회의 시작시간, 종료시간을 저장하는 객체 정의
  // 종료시간 순으로 정렬
  // 종료시간이 같을 때는 시작시간이 빠른순으로 정렬

  private static int solution(Meeting[] meetings) {
    int result = 0;
    Arrays.sort(meetings);

    int end = 0;

    for (Meeting meeting : meetings) {
      if (meeting.start >= end) {
        end = meeting.end;
        result++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      int size = Integer.parseInt(br.readLine());
      Meeting[] meetings = new Meeting[size];
      for (int i = 0; i < size; i++) {
        String[] inputs = br.readLine().split(" ");
        int start = Integer.parseInt(inputs[0]);
        int end = Integer.parseInt(inputs[1]);
        meetings[i] = new Meeting(start, end);
      }
      int result = solution(meetings);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

  static class Meeting implements Comparable<Meeting> {

    int start;
    int end;

    Meeting(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Meeting other) {
      if (this.end == other.end) {
        return this.start - other.start;
      }
      return this.end - other.end;
    }
  }

}
