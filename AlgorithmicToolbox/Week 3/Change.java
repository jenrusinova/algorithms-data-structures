/*
Task. The goal in this problem is to find the minimum number of coins needed to change the input value (an integer) 
into coins with denominations 1, 5, and 10. 
Input Format. The input consists of a single integer m. 
Constraints. 1 ≤ m ≤ 103. 
Output Format. Output the minimum number of coins with denominations 1, 5, 10 that changes m.
*/

import java.util.Scanner;

public class Change {

    static int[] coins = {10, 5, 1};

    private static int getChange(int amount) {
        int result = 0;

        for (int i = 0; i < coins.length - 1; i++) {
            while (amount > 0) {
                if (coins[i] > amount) {
                    i++;
                } else {
                    result++;
                    amount = amount - coins[i];
                }
            } 
        }
        return result;        
    }

        public static void main (String[]args){
            Scanner scanner = new Scanner(System.in);
            int m = scanner.nextInt();
            System.out.println(getChange(m));
        }
    }