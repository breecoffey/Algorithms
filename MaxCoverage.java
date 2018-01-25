/**
 * new minCoins method calculates the minimum number of coins needed to make change for a given value
 *
 * @author Brianne Coffey
 * @version 11/13/2017
 */
import java.util.*;
public class MaxCoverage {


    static int numCoins = 500;
    static ArrayList<Integer> denominations = new ArrayList<Integer>(Arrays.asList(1, 5, 7, 13));
    int maxCoverage;
    List<Integer> cList = new LinkedList<Integer>();
    static int[] minChangeArr = new int[10000000];

    public static int minCoins(int value) {
        int[] results = new int[value+1];
        int[] coinChange = new int[denominations.size()]; //this stores the the solution for a given value using all the coins
        results[0] = 0;
        //iterate through all the amounts that lead up to the value and calculate minimum coins needed for that amount
        for (int amount = 1; amount <= value; amount++) {
            //Set all values to -1 in the array to reset CoinChange
            for (int j = 0; j < coinChange.length; j++) {
                coinChange[j] = -1;
            }

            //iterate through the coins and add them up to get to the value
            for (int j = 0; j < denominations.size(); j++) {
                if (denominations.get(j) <= amount) {
                    coinChange[j] = results[amount - denominations.get(j)] + 1;
                }
            }

            //take out the minimum number from the ways we can make change for that amount and add it to the results array
            results[amount]=-1;
            for(int j=0;j<coinChange.length;j++){
                if(coinChange[j]>0 && (results[amount]==-1 || results[amount]>coinChange[j])){
                    results[amount]=coinChange[j];
                    System.out.println(results[amount]);
                }
            }
        }

        return results[value];

    }

    int minChange(int changeValue) {

        for (int i = 0; i < denominations.size() && changeValue >= denominations.get(i); i++) {
            cList.add(minChangeArr[changeValue - denominations.get(i)] + 1);
        }
        minChangeArr[changeValue] = Collections.min(cList);
        cList.clear();
        return minChangeArr[changeValue];

    }

    public static void main(String[] args) {
/*
        for (int i = 0; i < denominations.size(); i++)
            minChangeArr[denominations.get(i)] = 1;
        MaxCoverage obj = new MaxCoverage()
        int i = 1;
        while (obj.minChange(i) <= numCoins)
            i++;

        System.out.println("maxCoverage = " + (i - 1));*/
        MaxCoverage obj = new MaxCoverage();
        System.out.println(MaxCoverage.minCoins(20));
        System.out.println(MaxCoverage.minCoins(1));
    }
}



