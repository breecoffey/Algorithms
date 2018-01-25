/**
 * @author Brianne Coffey
 * Homework 1, problem 1
 */
import java.util.HashSet;

public class DifferenceCounter {
    /**
     * My original thought process was the traditional nested for-loop. This, however, proves to be inefficient at O(n^2).
     * So, I decided to use a HashSet (because the integer values are distinct) and determine if values had the correct difference
     * using the contains(Object o) method which is O(1).
     * Ultimately, this makes my algorithm O(n).
     */


   public static String countDifferences (int[] a, int k)
    {
        int pairNum = 0;
        String pairs = "";
        HashSet<Integer> hS = new HashSet<Integer>();

        for (int i = 0; i < a.length; i++)
            hS.add(a[i]);
        for (int j = 0; j < a.length; j++)
        {
            int x = a[j];
            if (hS.contains(x - k)){
                pairNum++;
                pairs += "(" + x + "," + ((x - k)) + ")";}
            if (hS.contains(x + k)){
                pairNum++;
                pairs += "(" + x + "," + ((x + k)) + ")";}
            hS.remove(x);
        }
        return "There are " + pairNum + " pairs with difference " + k + ": " + pairs;
    }

    public static void main(String[] args){
        int[] a = {1, 9, 2, 15, 10, 5, 3};
        int k = 5;
        System.out.println(DifferenceCounter.countDifferences(a, k));

    }
}

