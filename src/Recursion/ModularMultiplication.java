package Recursion;

import java.math.BigInteger;

public class ModularMultiplication {
    public static void main(String[] args) {
        final BigInteger MOD = BigInteger.valueOf(1_000_000_007);

        BigInteger five = BigInteger.valueOf(5);
        BigInteger four = BigInteger.valueOf(4);

        BigInteger fivePow25 = five.modPow(BigInteger.valueOf(25), MOD); // 5^25 % MOD
        BigInteger fourPow24 = four.modPow(BigInteger.valueOf(24), MOD); // 4^24 % MOD

        BigInteger result = fivePow25.multiply(fourPow24).mod(MOD); // (5^25 * 4^24) % MOD

        System.out.println(result);
    }
}