/*
Task: Compose the largest number out of a set of integers.
Input Format. The first line of the input contains an integer n. The second line contains array of integers.
Constraints. 1 ≤ n ≤ 100; 1 ≤ a(i) ≤ 10^3 for all 1 ≤ i ≤ n.
Output Format. Output the largest number that can be composed out of array.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

    public class LargestNumber implements Comparator<String>{

        @Override
        public int compare (String s1, String s2){
            String s1s2 = s1+s2;
            String s2s1 = s2+s1;
            return s2s1.compareTo(s1s2);
        }
        private static String largestNumber(String[] salaryNumbers) {
            int parts = salaryNumbers.length;
            if (salaryNumbers == null || parts == 0)
                return "";

            String[] maxSalary = new String[parts];
            for (int i = 0; i < parts; ++i) {
                maxSalary[i] = String.valueOf(salaryNumbers[i]);
            }
            Arrays.sort(maxSalary, new LargestNumber() {
            });
            StringBuilder sb = new StringBuilder();
            for (String salaryPart : maxSalary) {
                sb.append(salaryPart);
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int length = scanner.nextInt();
            String[] salaryNumbers = new String[length];
            for (int i = 0; i < length; i++) {
                salaryNumbers[i] = scanner.next();
            }
            System.out.println(largestNumber(salaryNumbers));
        }
    }