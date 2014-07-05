import java.math.BigInteger;

/**
 * Created by Mike on 2014-07-03.
 */
public class EulerProblem448 {
    public static void main(String[] args) {
        EulerProblem448 e = new EulerProblem448();
        e.run();
    }

    private void run() {


        System.out.println(A(BigInteger.valueOf(10)).toString());
        /*
        BigInteger temp1 = BigInteger.valueOf(2);
        //System.out.println(temp1.add(BigInteger.valueOf(3)).toString());
        System.out.println(S(BigInteger.valueOf(100)));
        System.out.println(S(BigInteger.valueOf(99999999019l)).mod(BigInteger.valueOf(999999017l)));
        */
        System.out.println(eulerTotientFunc(BigInteger.valueOf(6)));
    }

    private static BigInteger gcd(BigInteger a, BigInteger b) {
        while (b.signum() == 1) {
            BigInteger temp = b;
            b = a.mod(b);
            a = temp;
        }
        return a;
    }

    private static BigInteger lcm(BigInteger a, BigInteger b) {
        return a.multiply(b.divide(gcd(a, b)));
    }

    private static BigInteger A(BigInteger n) {
        BigInteger sum = BigInteger.valueOf(0);
        for (BigInteger i = new BigInteger("1"); i.compareTo(n) < 0; i = i.add(BigInteger.valueOf(1))) {
            if (n.mod(i).equals(BigInteger.valueOf(0))) {
                sum = sum.add(i.multiply(eulerTotientFunc(i)));
            }
        }
        return n.divide(BigInteger.valueOf(2)).multiply(BigInteger.valueOf(1).add(sum));
        /*
        BigInteger res = BigInteger.valueOf(0);
        BigInteger index = BigInteger.ONE;
        while (n.subtract(index).signum() >= 0) {
            //System.out.println(index.toString());
            //System.out.print(lcm(index,n));
            res = res.add(lcm(index,n));
            index = index.add(BigInteger.ONE);

        }

        return res.divide(n);
        */
    }

    private static BigInteger eulerTotientFunc(BigInteger n) {
        BigInteger count = new BigInteger("0");
        for(BigInteger i = new BigInteger("1"); i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger check = gcd(n, i);

            if(check.compareTo(BigInteger.ONE)==0)  {//coprime
                count = count.add(BigInteger.ONE);
            }
        }
        return count;
    }

    private static BigInteger S(BigInteger n) {
        BigInteger res = BigInteger.valueOf(0);
        BigInteger index = BigInteger.ONE;
        while (n.subtract(index).signum() >= 0) {
            res = res.add(A(index));
            index = index.add(BigInteger.ONE);
        }
        return res;
    }
}
