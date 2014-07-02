import java.math.BigInteger;

/**
 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.

 Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000. */
public class EulerProblem48 {

    public static void main(String[] args) {
        EulerProblem48 e = new EulerProblem48();
        e.run();
    }

    public void run() {
        BigInteger a = BigInteger.valueOf(405071317);
        for (int i = 11; i <= 1000; i++) {
            BigInteger b = BigInteger.valueOf(i);
            b = b.pow(i);
            a = a.add(b);
            a = a.mod(BigInteger.valueOf(((long)Math.pow(10,10))));
            System.out.println(a.toString());
        }
        System.out.println(a);
    }
}
