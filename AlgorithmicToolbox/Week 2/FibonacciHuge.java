import java.util.*;
/*
Problem introduction: In this problem, your goal is to compute Fn modulo m, where n may be really huge: up to 10^14.
To get an idea how to solve this problem without going through all Fi for i from 0 to n,
let’s see what happens when m is small — say, m = 2 or m = 3. Take a detailed look at this table. Do you see?
Both these sequences are periodic! For m = 2, the period is 011 and has length 3, while for m = 3 the period is
01120221 and has length 8. Therefore, to compute, say, F2015 mod 3 we just need to find the remainder of 2015 when
divided by 8. Since 2015 = 251·8 + 7, we conclude that F2015 mod 3 = F7 mod 3 = 1. This is true in general:
for any integer m ≥ 2, the sequence Fn mod m is periodic. The period always starts with 01 and is known
as Pisano period.

Task: Given two integers n and m, output Fn mod m (that is, the remainder of Fn when divided by m).
Input Format: The input consists of two integers n and m given on the same line (separated by a space).
Constraints: 1 ≤ n ≤ 1014, 2 ≤ m ≤ 103.
Output Format: Output Fn mod m
 */
public class FibonacciHuge {
    //Find pisano period of m
    public static long pisano_period(long m) {
        long a = 0;
        long b = 1;
        long c;

        for (int i = 0; i < m * m; i++) {
            c = (a + b) % m;
            a = b;
            b = c;
            //Stop iteration when we encounter 01, as it's indicates that new iteration is started
            if ((a == 0) && (b == 1))
                return (i + 1);
        }
        return -1;
    }

    private static long getFibonacciHugeNaive(long n, long m){
        long remainder = n % pisano_period(m);
        long a = 0;
        long b = 1;
        long res = remainder;

        for (int i = 1; i < remainder; i++){
            res = (a+b)% m;
            a = b;
            b = res;
        }
        return res % m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}