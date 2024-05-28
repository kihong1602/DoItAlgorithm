package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem045 {
  // 백준 21568 Ax+By=C

  // 확장 유클리드 호제법
  // Ax+By=C 에서 해의 최소값은 C%gcd(A,B) == 0 일 때
  // A B의 나머지가 0이 나올때 까지 gcd 반복
  // gcd에서 나오는 값(몫,나머지)을 모두 저장해뒀다가, 역순으로 계산 시작
  // x = y`, y = x`-y`*몫 로 해서 계산
  // 최종적으로 나온 x, y 값에 C를 gcd(x,y)로 나눈 값을 각각 곱한다.
  private static String solution(int A, int B, int C) {
    StringBuilder sb = new StringBuilder();
    int gcd = gcd(A, B);
    if (C % gcd != 0) {
      return "-1";
    }
    int quota = C / gcd;
    long[] ret = execute(A, B);
    sb.append(ret[0] * quota).append(" ").append(ret[1] * quota);

    return sb.toString();
  }

  private static long[] execute(int A, int B) {
    long[] ret = new long[2];
    if (B == 0) {
      ret[0] = 1;
      return ret;
    }
    long q = A / B;
    long[] v = execute(B, A % B);
    ret[0] = v[1];
    ret[1] = v[0] - v[1] * q;
    return ret;
  }

  private static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputs = br.readLine().split(" ");
      int A = Integer.parseInt(inputs[0]);
      int B = Integer.parseInt(inputs[1]);
      int C = Integer.parseInt(inputs[2]);
      String result = solution(A, B, C);
      bw.write(result);
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
