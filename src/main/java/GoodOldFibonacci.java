public class GoodOldFibonacci {

  public int recursive(int n) {
    if (n <= 1) {
      return n;
    }
    return recursive(n - 1) + recursive(n - 2);
  }

  public int dynamic(int n) {
    int[] fibonacciSequence = new int[n + 2];
    fibonacciSequence[0] = 0;
    fibonacciSequence[1] = 1;

    for (int i = 2; i <= n; i++) {
      fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
    }

    return fibonacciSequence[n];
  }

  public int lastTwo(int n) {
    int fibonacci = n <= 1 ? n : 0;
    int firstValue = 0;
    int secondValue = 1;

    for (int i = 2; i <= n; i++) {
      fibonacci = firstValue + secondValue;
      firstValue = secondValue;
      secondValue = fibonacci;
    }

    return fibonacci;
  }

}
