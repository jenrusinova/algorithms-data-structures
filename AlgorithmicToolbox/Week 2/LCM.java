import java.util.Scanner;
/*
Problem introduction: The least common multiple of two positive integers a and b is the least positive integer m
that is divisible by both a and b.
Task: Given two integers a and b, find their least common multiple.
Input format:  The two integers a and b are given in the same line separated by space.
Constraints:  1 ≤ a,b ≤ 10^7.
Output format: Output the least common multiple of a and b.
 */

public class LCM {
    private static long gcd_naive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd_naive(b, a % b);
        }
    }
    private static long lcm_naive(int a, int b){
        long l = ((long)a*(long)b);
        return (l/gcd_naive(a,b));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(lcm_naive(a, b));
    }
}