import java.math.BigInteger;

/**
 * Created by Mike on 2014-07-04.
 */
public class EulerProblem6 {

    public static void main(String[] args) {
        /*
        System.out.println(sumOfSqures(BigInteger.valueOf(10)).toString());
        System.out.println(squareOfSum(BigInteger.valueOf(10)).toString());
        */
        System.out.println(diff(BigInteger.valueOf(100)).toString());

    }

    private static BigInteger sumOfSqures(BigInteger n) {
        return n.multiply(n.add(BigInteger.valueOf(1)).multiply(n.multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1)))).divide(BigInteger.valueOf(6));
    }

    private static BigInteger squareOfSum(BigInteger n) {
        BigInteger sum = BigInteger.valueOf(0);
        for (BigInteger i = new BigInteger("1"); i.compareTo(n) <= 0; i = i.add(BigInteger.valueOf(1))) {
            sum = sum.add(i);
        }
        return sum.multiply(sum);
    }

    private static BigInteger diff(BigInteger n) {
        return squareOfSum(n).subtract(sumOfSqures(n));
    }
}

//Answer: 25164150