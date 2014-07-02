import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mike on 2014-07-01.
 */
public class EulerProblem7 {

    public static void main(String[] args) {
        EulerProblem7 e = new EulerProblem7();
        e.run();
    }

    public void run() {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int count = 3;
        while(true) {
            if(primes.size() >= 10001) {
                break;
            }
            boolean isPrime = true;
            for (Integer i : primes) {
                if (count % i == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                primes.add(count);
                //System.out.println(count);
            }
            count++;
        }
        System.out.println(primes.get(10000));
    }
}
