/*
Task. The goal of this code problem is to implement an algorithm for the fractional knapsack problem. 
Input Format. The first line of the input contains the number n of items and the capacity W of a knapsack. The next n 
lines define the values and weights of the items.The i-th line contains integers v(i) and w(i)—the value and the weight
 of i-th item, respectively. 
 Constraints. 1 ≤ n ≤ 10^3, 0 ≤ W ≤ 2·10^6; 0 ≤ v(i) ≤ 2·10^6, 0 < w(i) ≤ 2·10^6 for all 1 ≤ i ≤ n. 
 All the numbers are integers. 
 Output Format. Output the maximal value of fractions of items that fit into the knapsack. 
 The absolute value of the difference between the answer of your program and the optimal value should be at most 10−3.
 To ensure this, output your answer with at least four digits after the decimal point (otherwise your answer,
 while being computed correctly, can turn out to be wrong because of rounding issues).
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {

        //create array of items and set their weight and value
        Item[] pack= new Item[values.length];
        for (int i = 0; i <pack.length; i++){
            pack[i] = new Item(values[i], weights[i]);
        }        
        //sorting this array in reversed order
        Arrays.sort(pack, Comparator.comparingDouble(Item::valuePerWeight).reversed());

        double currentWeight = 0;
        int currentPack = 0;
        double currentValue = 0;

        while (currentWeight!= capacity&&currentPack<pack.length){
            if (currentWeight + pack[currentPack].getWeight()<capacity){
                //take whole item
                currentValue+=pack[currentPack].getValue();
                currentWeight+=pack[currentPack].getWeight();
            }
            else{
                //take only part of item
                currentValue += ((capacity-currentWeight)/(double)pack[currentPack].getWeight())*pack[currentPack].getValue();
               currentWeight = capacity;
               break;
            }
            currentPack++;
        }
        return currentValue;
    }

    public static class Item{
        private int values;
        private int weights;

        public Item(int values, int weights) {
            this.values = values;
            this.weights = weights;
        }

        public double valuePerWeight(){
            return values/(double)weights;
        }

        public int getValue() {
            return values;
        }

        private void setValue(int values) {
            this.values = values;
        }

        public int getWeight() {
            return weights;
        }

        private void setWeight(int weight) {
            this.weights = weights;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        System.out.println(getOptimalValue(capacity, values, weights));
    }
}