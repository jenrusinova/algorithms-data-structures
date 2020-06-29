import java.util.*;

public class FibonacciSquaresSum {
    private static final int PISANO_PERIOD_MOD10 = 60;

    private static int getFibonacciLastDigit(long n) {
        if (n <= 1)
            return (int) n;

        int previous = 0;
        int current = 1;
        for (long i = 2; i <= n; i++) {
            int next = (previous + current) % 10;
            previous = current;
            current = next;
        }

        return current % 10;
    }

    private static int getFibonacciSumSquares(long n) {
        int verticalSide = getFibonacciLastDigit(n % PISANO_PERIOD_MOD10);

        int horizontalSide = getFibonacciLastDigit((n + 1) % PISANO_PERIOD_MOD10);

        int sumSquares = verticalSide * horizontalSide;
        return sumSquares % 10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquares(n);
        System.out.println(s);
    }
}
