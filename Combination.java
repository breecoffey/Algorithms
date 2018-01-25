import java.math.BigInteger;
import java.util.ArrayList;

/**
 * This class contains two methods to calculate the number of possible combinations of n choose k objects.
 *
 * @author Brianne Coffey
 * @version 11/9/17
 */
public class Combination {
    public static BigInteger formula(int n, int k) {
        BigInteger factDenom = BigInteger.ONE;
        BigInteger factDenom2 = BigInteger.ONE;
        BigInteger factNom = BigInteger.ONE;
        for (int i = n; i > 0; i--) {
            factNom = factNom.multiply(BigInteger.valueOf(i));
        }
        for (int j = (n - k); j > 0; j--) {
            factDenom = factDenom.multiply(BigInteger.valueOf(j));
        }
        for (int m = k; m > 0; m--) {
            factDenom2 = factDenom2.multiply(BigInteger.valueOf(m));
        }
        return factNom.divide(factDenom.multiply(factDenom2));
    }

    public static BigInteger pascal(int i, int j) {
        ArrayList<BigInteger> last = new ArrayList<BigInteger>();
        last.add(BigInteger.ONE);


        for (int k = 1; k <= i; ++k) {
            //next row of triangle
            ArrayList<BigInteger> thisRow = new ArrayList<BigInteger>();
            thisRow.add(last.get(0)); //beginning

            for (int m = 1; m < k; ++m) {//loop the number of elements in this row
                //sum from the last row
                thisRow.add(last.get(m - 1).add(last.get(m)));

            }
            thisRow.add(last.get(0)); //end

            last = thisRow;//save this row
        }

        return last.get(j);

    }

}
