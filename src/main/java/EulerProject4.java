/**
 * Created by Mike on 2014-07-04.
 */
public class EulerProject4 {

    public static void main(String[] args) {
        /*
        int i = 999;
        int j = 999;
        while (i >= 1 && j >= 1) {
            if (isPalindrome(i*j)) {
                System.out.println(i*j);
                break;
            }
        }
        */
        int max = 0;
        outer: for (int i = 999;i >= 1; i--) {
            for (int j = 999; j >= 1; j--) {
                if (isPalindrome(i*j) && i*j > max) {
                    max = i*j;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isPalindrome(int n) {
        int first = 1;
        int last = (int)(Math.log10(n)+1);
        while (last >= first) {
            if (getNthDigit(n, first) != getNthDigit(n, last)) {
                return false;
            }
            first++;
            last--;
        }
        return true;
    }

    private static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) {
                // number is perfectly divisible - no prime
                return false;
            }
        }
        return true;
    }

    private static int getNthDigit(int number, int n) {
        return (int) ((number / Math.pow(10, n - 1)) % 10);
    }
}

//Answer: 906609
