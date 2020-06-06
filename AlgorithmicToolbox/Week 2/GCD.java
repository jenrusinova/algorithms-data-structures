import java.util.*;
/*The greatest common divisor GCD(a,b) of two non-negative integers a and b (which are not both equal to 0)
 is the greatest integer d that divides both a and b. Your goal in this problem is to implement
 the Euclidean algorithm for computing the greatest common divisor.

 Task: Given two integers a and b, find their greatest common divisor.
 Input Format: The two integers a,b are given in the same line separated by space.
 Constraints:  1 ≤ a,b ≤ in 2*10^9.
 Output Format: Output GCD(a,b).
 */

public class GCD {
    //Repeatedly divide the divisor by the remainder until the remainder is 0.The GCD is last non-zero remainder.
    private static int gcd_naive(int a, int b) {
        if (b == 0){
            return a;        }
        else{
            return gcd_naive(b, a%b);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}