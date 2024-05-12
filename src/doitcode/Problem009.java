package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Problem009 {

  // 백준 실버5 12891 DNA 비밀번호
  // 슬라이딩 윈도우
  // 문자열에 A C G T 만 들어가야함
  // 임의로 뽑은 부분문자열 중 A C G T 가 몇 번이상 등장해야한다
  // 만들 수 있는 비밀번호의 종류를 구하라

  private static int solution(String target, int[] min, int size) {
    int result = 0;
    int[] valid = new int[min.length];

    for (int i = 0; i < size; i++) {
      valid[charToIndex(target.charAt(i))]++;
    }

    if (validate(min, valid)) {
      result++;
    }

    for (int i = size; i < target.length(); i++) {
      valid[charToIndex(target.charAt(i - size))]--;
      valid[charToIndex(target.charAt(i))]++;

      if (validate(min, valid)) {
        result++;
      }
    }

    return result;
  }

  private static int charToIndex(char ch) {
    return switch (ch) {
      case 'A' -> 0;
      case 'C' -> 1;
      case 'G' -> 2;
      case 'T' -> 3;
      default -> -1;
    };
  }

  private static boolean validate(int[] min, int[] valid) {
    for (int i = 0; i < 4; i++) {
      if (valid[i] < min[i]) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] sizes = br.readLine().split(" ");
      int substringSize = Integer.parseInt(sizes[1]);
      String target = br.readLine();
      String[] inputs = br.readLine().split(" ");
      int[] min = new int[inputs.length];
      for (int i = 0; i < min.length; i++) {
        min[i] = Integer.parseInt(inputs[i]);
      }

      int result = solution(target, min, substringSize);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      System.out.println(e.getStackTrace()[0]);
    }
  }

}
