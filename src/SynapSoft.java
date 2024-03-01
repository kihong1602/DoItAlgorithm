public class SynapSoft {

  private static String columnNumberToName(int n) {
    StringBuilder sb = new StringBuilder();
    // 알파벳 순서대로 열을 구하기 위해 1을 빼줌
    while (n-- > 0) {
      // 현재 열의 마지막 알파벳 조회
      char token = (char) (n % 26 + 'A');
      // 해당 알파벳을 결과에 추가
      sb.insert(0, token);
      // 다음 열을 계산하기 위해 n을 26으로 나눔
      n /= 26;
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(columnNumberToName(100000000));
  }
}
