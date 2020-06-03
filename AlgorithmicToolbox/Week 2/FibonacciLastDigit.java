/*
Your goal in this problem is to find the last digit of n-th Fibonacci number. Recall that Fibonacci numbers grow exponentially fast. For example,
F200 = 280571172992510140037611932413038677189525.

Task: Given an integer n, find the last digit of the nth Fibonacci number Fn (that is, Fn mod 10). 
Input Format: The input consists of a single integer n. 
Constraints: 0 ≤ n ≤ 107. 
Output Format: Output the last digit of Fn.
*/

import java.util.*;
import java.io.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

//The last digit of Fibonacci number is the sum of two previous Fibonacci numbers
//Time complexity is O(logn)
      
        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}