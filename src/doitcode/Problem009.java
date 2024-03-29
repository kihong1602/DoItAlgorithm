package doitcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Problem009 {

  // 백준 실버5 12891 DNA 비밀번호
  // 슬라이딩 윈도우
  // 문자열에 A C G T 만 들어가야함
  // 임의로 뽑은 부분문자열 중 A C G T 가 몇 번이상 등장해야한다
  // 만들 수 있는 비밀번호의 종류를 구하라

  public static void main(String[] args) {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] inputSizes = br.readLine()
          .split(" ");
      int substringLength = Integer.parseInt(inputSizes[1]);
      String dna = br.readLine();
      int[] minAppearances = Arrays.stream(br.readLine()
              .split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();

      int result = solution(dna, substringLength, minAppearances);
      bw.write(String.valueOf(result));
      bw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int solution(String dna, int substringLength, int[] minAppearances) {
    int validCount = 0;

    int[] valid = new int[4];

    for (int i = 0; i < substringLength; i++) {
      valid[charToIndex(dna.charAt(i))]++;
    }

    if (validCheck(valid, minAppearances)) {
      validCount++;
    }

    for (int i = substringLength; i < dna.length(); i++) {
      valid[charToIndex(dna.charAt(i - substringLength))]--;
      valid[charToIndex(dna.charAt(i))]++;

      if (validCheck(valid, minAppearances)) {
        validCount++;
      }
    }
    return validCount;
  }


  public static int charToIndex(char ch) {
    return switch (ch) {
      case 'A' -> 0;
      case 'C' -> 1;
      case 'G' -> 2;
      case 'T' -> 3;
      default -> -1;
    };
  }

  public static boolean validCheck(int[] valid, int[] minAppearances) {
    for (int i = 0; i < valid.length; i++) {
      if (valid[i] < minAppearances[i]) {
        return false;
      }
    }
    return true;
  }

}
