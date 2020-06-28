/*
Task. Given two non-negative integers 𝑚 and 𝑛, where 𝑚 ≤ 𝑛, find the last digit of the sum 𝐹𝑚 + 𝐹𝑚+1 +
· · · + 𝐹𝑛.
Input Format. The input consists of two non-negative integers 𝑚 and 𝑛 separated by a space.
Constraints. 0 ≤ 𝑚 ≤ 𝑛 ≤ 10^14.
Output Format. Output the last digit of 𝐹𝑚 + 𝐹𝑚+1 + · · · + 𝐹𝑛.
 */

import java.util.*;

public class FibonacciPartialSum {
    private static final int PISANO_PERIOD_MOD10 = 60;

    private static long getFibonacciPartialSumNaive(long from, long to) {
        int lastDigitFrom = getFibonacciSumNaive(from-1);
        int lastDigitTo = getFibonacciSumNaive(to);
        return (lastDigitTo + 10 - lastDigitFrom)%10;
    }

    private static int getFibonacciLastDigit(long n) {
        if (n <= 1)
            return (int) n;

        int prev = 0;
        int curr = 1;
        for (long i = 2; i <= n; i++) {
            int next = (prev + curr) % 10;
            prev = curr;
            curr = next;
        }
        return curr % 10;
    }

    private static int getFibonacciSumNaive(long n) {

        int lastDigit = getFibonacciLastDigit((n + 2) % PISANO_PERIOD_MOD10);

        if (lastDigit < 1){
            lastDigit+=10;
        }
            return lastDigit - 1;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}