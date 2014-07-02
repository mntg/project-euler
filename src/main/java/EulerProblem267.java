import org.apache.commons.math3.util.*;

import java.math.BigInteger;

/**
 * Created by Mike on 2014-07-01.
 */
public class EulerProblem267 {
    public static void main(String[] args) {
        EulerProblem267 e = new EulerProblem267();
        e.run();
    }

    public void run() {
        BigInteger nbrNodesOverBillion = nbrNodes(0.5);
        System.out.println(nbrNodesOverBillion);
    }

    public BigInteger nbrNodes(double f) {
        BigInteger count = BigInteger.valueOf(0);
        for(int i = 0; i <= 1000; i++) {
            double val = Math.pow((1-f),i) * Math.pow(1+2*f,1000-i);
            //System.out.println(val);
            if (val > Math.pow(10,9)) {
                count = count.add(BigInteger.valueOf(((long)CombinatoricsUtils.binomialCoefficientDouble(1000,i))));
            }
        }
        return count;
    }
}