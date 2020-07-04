/*
Task. The goal in this problem is to count the number of inversions of a given sequence.

Input Format. The first line contains an integer 𝑛, the next one contains a sequence of integers
𝑎0, 𝑎1, . . . , 𝑎𝑛−1.

Constraints. 1 ≤ 𝑛 ≤ 10^5,  1 ≤ 𝑎𝑖 ≤ 10^9 for all 0 ≤ 𝑖 < 𝑛.

Output Format. Output the number of inversions in the sequence.
 */

import java.util.Scanner;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left) {            
            return numberOfInversions;
        }
        int ave = left + (right-left) / 2;
        numberOfInversions += getNumberOfInversions(a, b, left, ave);
        numberOfInversions += getNumberOfInversions(a, b, ave+1, right);
        numberOfInversions +=merge(a,b,left, ave+1,right);
        
        return numberOfInversions;
    }

    private static long merge (int[] array, int[]temp, int left, int ave, int right){
        int i = left;
        int j = ave;
        int k = left;

        long numberOfInversions = 0;

        while (i <= ave-1 && j <=right ){
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            }
            else{
                temp[k++] = array[j++];
                numberOfInversions += ave -i;
            }
        }
        while (i <=ave-1){
            temp[k++] = array[i++];
        }
        while (j<=right){
            temp[k++] = array[j++];
        }
        for (int a = left; a <=right; a++){
            array[a] = temp[a];
        }
        return numberOfInversions;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}