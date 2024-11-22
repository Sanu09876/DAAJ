import java.math.BigInteger;
import java.util.*;

public class SquareofNumber {
    public static BigInteger karatsuba(BigInteger b1, BigInteger b2) {
        if (b1.compareTo(BigInteger.TEN) < 1 || b2.compareTo(BigInteger.TEN) < 1) {
            return b1.multiply(b2);
        }

        int len = Math.max(b1.toString().length(), b2.toString().length());
        int half = len / 2;
        BigInteger tenPowerFunc = BigInteger.TEN.pow(half);

        BigInteger a = b1.divide(tenPowerFunc); 
        BigInteger b = b1.mod(tenPowerFunc);
        BigInteger c = b2.divide(tenPowerFunc);
        BigInteger d = b2.mod(tenPowerFunc);

        BigInteger z2 = karatsuba(a, c);
        BigInteger z0 = karatsuba(b, d);
        BigInteger z1 = karatsuba(a.add(b), c.add(d));
        z1 = z1.subtract(z2).subtract(z0);

        return z2.multiply(BigInteger.TEN.pow(2 * half))
                .add(z1.multiply(BigInteger.TEN.pow(half)))
                .add(z0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number: ");
        BigInteger b1 = sc.nextBigInteger();
        
        
        BigInteger result = karatsuba(b1, b1);
        System.out.println("The square is: " + result);
        
        sc.close();
    }
}