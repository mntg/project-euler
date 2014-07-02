import java.util.*;

/**
 * Created by Mike on 2014-07-01.
 */
public class EulerProblem14 {

    public static void main(String[] args) {
        EulerProblem14 e = new EulerProblem14();
        e.run();
    }

    public void run() {
        HashSet<Long> visited = new HashSet<Long>();
        HashMap<Long,Long> lengthsMap = new HashMap<Long, Long>();
        long max = 0;
        long largest = 0;
        for (long i = 1 ; i <= 9999999 ; i++) {
            if(!visited.contains(i)) {
                long val = calcLengthOfSeq(i,lengthsMap,visited);
                lengthsMap.put(i,val);
                //System.out.println("Starting in " + i + " with length " + val);
                if (val > max) {
                    max = val;
                    largest = i;
                }
                System.out.println(i);
            }
        }
        System.out.println("The max is: " + largest + " with length " + max);
    }

    public long calcLengthOfSeq(long starting, HashMap<Long,Long> map, HashSet<Long> visited) {
        long current = starting;
        long count = 1;
        while(current != 1) {
            if (current % 2 == 0) {
                current = current/2;
            } else {
                current = 3*current + 1;
            }
            //System.out.println(current);
            visited.add(current);

            if (map.containsKey(current)) {
                //System.out.println("hej");
                return count + map.get(current);
            }
            count++;
        }
        return count;
    }
}
