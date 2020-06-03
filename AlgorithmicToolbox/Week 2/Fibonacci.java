import java.util.Scanner;
/*
Problem Introduction: Recall the definition of Fibonacci sequence: F0 = 0, F1 = 1, and Fi = Fi−1 +Fi−2 for i ≥ 2.
Your goal in this problem is to implement an efficient algorithm for computing Fibonacci numbers.
Task: Given an integer n, find the nth Fibonacci number Fn.
Input Format: The input consists of a single integer n.
Constraints: 0 ≤ n ≤ 45.
Output Format: Output Fn.
 */
public class Fibonacci {
    //Calculating  nth term of the Fibonacci sequence using Binet's formula (φ≈1.6180339887 or (1 + Math.sqrt(5)) / 2)
    //Time complexity is O(1)
  public static int calc_fib(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int)Math.round(Math.pow(goldenRatio, N)/ Math.sqrt(5));
    }
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    System.out.println(calc_fib(n));
  }
}
